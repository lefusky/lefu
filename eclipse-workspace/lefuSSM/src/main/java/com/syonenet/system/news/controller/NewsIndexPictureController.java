package com.syonenet.system.news.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.syonenet.entity.NewsIndexPicture;
import com.syonenet.entity.PageBean;
import com.syonenet.system.news.service.NewsIndexPictureService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/system")
public class NewsIndexPictureController {
	@Autowired
	private NewsIndexPictureService newsIndexPictureService;
	//��ѯ
	@RequestMapping(value = "/newsIndexPictureList.do")
	public String newsIndexPictureList(
		@RequestParam(value = "page", required = false) String page,
		@RequestParam(value = "rows", required = false) String rows, 
		@RequestParam(value = "id", required = false) Integer id,
		@RequestParam(value = "name", required = false) String name,
		HttpSession session,HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//��ҳ+����
		if(page!=null && rows!=null) {
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
		}
		map.put("sortingid","diminishing");
		//��ѯ����
		if (id != null) {map.put("id",id);}
		if (name != null) {map.put("type",name);}
		//��ѯ����+�б�
		int total = newsIndexPictureService.findNewsIndexPictureCount(map);
		List<NewsIndexPicture> PictureList = newsIndexPictureService.findNewsIndexPictureList(map);
		//ʱ��
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(PictureList, jsonConfig);
		//��������
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}
	//���+�޸�
	@RequestMapping(value = "/newsIndexPictureSave.do")
	public File newsIndexPictureSave(NewsIndexPicture newsIndexPicture,MultipartFile[] photos,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		int total = 0;	
		JSONObject object = new JSONObject();	
		
		//�ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0  
		System.out.println(photos);
        if(photos!=null&&photos.length>0){  
            //ѭ����ȡfile�����е��ļ�  
            for(int i = 0;i<photos.length;i++){  
                MultipartFile file = photos[i]; 
                File tempFile=null;               
                
                //����ļ�����·��
                //String path2=request.getSession().getServletContext().getRealPath("/")+ "upload\\pic\\"+file.getOriginalFilename();
                //String path1="D:\\apache-tomcat-7.0.82\\webapps\\computerSSM\\src\\main\\webapp\\upload\\pic\\"+file.getOriginalFilename();
                String path1="D:\\apache-tomcat-7.0.82\\webapps\\computerSSM\\upload\\pic\\"+file.getOriginalFilename();
            	//����ļ��������ݿ�·��
                String path="upload\\pic\\"+file.getOriginalFilename();
                System.out.println(path);
                tempFile=new File(path1); 
                tempFile.createNewFile();
                //�����ļ�
                if(i==0) {                	
                	//�ж��޸�ͼƬʱ�ļ��Ƿ��Ѿ��򿪣���׽�쳣��������
                	try {file.transferTo(tempFile);		
	                	newsIndexPicture.setPicture_name1(file.getOriginalFilename());
	                	newsIndexPicture.setPicture_url1(path);  
                	}catch(Exception e){}               	
                }
            }  
        }		
		// ���⸳ֵ
        newsIndexPicture.setAdd_time(new Date());
        //ִ����� �� �޸�
		if (newsIndexPicture.getId() == null) {
			// ���
			total = newsIndexPictureService.addNewsIndexPicture(newsIndexPicture);
		} else {
			// �޸�
			total = newsIndexPictureService.updateNewsIndexPicture(newsIndexPicture);
		}
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}
	//ɾ��
	@RequestMapping(value = "/newsIndexPictureDelete.do")
	public String PictureDelete(@RequestParam(value = "ids", required = false) 
		String ids, HttpServletResponse response)throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			if (Integer.parseInt(idsStr[i]) != 1) {
				newsIndexPictureService.deleteNewsIndexPicture(Integer.parseInt(idsStr[i]));
			}
		}
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}
}
