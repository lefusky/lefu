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
	//查询
	@RequestMapping(value = "/newsIndexPictureList.do")
	public String newsIndexPictureList(
		@RequestParam(value = "page", required = false) String page,
		@RequestParam(value = "rows", required = false) String rows, 
		@RequestParam(value = "id", required = false) Integer id,
		@RequestParam(value = "name", required = false) String name,
		HttpSession session,HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//分页+排序
		if(page!=null && rows!=null) {
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
		}
		map.put("sortingid","diminishing");
		//查询条件
		if (id != null) {map.put("id",id);}
		if (name != null) {map.put("type",name);}
		//查询总数+列表
		int total = newsIndexPictureService.findNewsIndexPictureCount(map);
		List<NewsIndexPicture> PictureList = newsIndexPictureService.findNewsIndexPictureList(map);
		//时间
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(PictureList, jsonConfig);
		//返回数据
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}
	//添加+修改
	@RequestMapping(value = "/newsIndexPictureSave.do")
	public File newsIndexPictureSave(NewsIndexPicture newsIndexPicture,MultipartFile[] photos,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		int total = 0;	
		JSONObject object = new JSONObject();	
		
		//判断file数组不能为空并且长度大于0  
		System.out.println(photos);
        if(photos!=null&&photos.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<photos.length;i++){  
                MultipartFile file = photos[i]; 
                File tempFile=null;               
                
                //获得文件保存路径
                //String path2=request.getSession().getServletContext().getRealPath("/")+ "upload\\pic\\"+file.getOriginalFilename();
                //String path1="D:\\apache-tomcat-7.0.82\\webapps\\computerSSM\\src\\main\\webapp\\upload\\pic\\"+file.getOriginalFilename();
                String path1="D:\\apache-tomcat-7.0.82\\webapps\\computerSSM\\upload\\pic\\"+file.getOriginalFilename();
            	//获得文件存入数据库路径
                String path="upload\\pic\\"+file.getOriginalFilename();
                System.out.println(path);
                tempFile=new File(path1); 
                tempFile.createNewFile();
                //保存文件
                if(i==0) {                	
                	//判断修改图片时文件是否已经打开，捕捉异常不做处理
                	try {file.transferTo(tempFile);		
	                	newsIndexPicture.setPicture_name1(file.getOriginalFilename());
	                	newsIndexPicture.setPicture_url1(path);  
                	}catch(Exception e){}               	
                }
            }  
        }		
		// 额外赋值
        newsIndexPicture.setAdd_time(new Date());
        //执行添加 或 修改
		if (newsIndexPicture.getId() == null) {
			// 添加
			total = newsIndexPictureService.addNewsIndexPicture(newsIndexPicture);
		} else {
			// 修改
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
	//删除
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
