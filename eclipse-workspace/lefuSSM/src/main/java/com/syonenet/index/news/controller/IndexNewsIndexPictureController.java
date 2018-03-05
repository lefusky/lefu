package com.syonenet.index.news.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.NewsIndexPicture;
import com.syonenet.entity.PageBean;
import com.syonenet.system.news.service.NewsIndexPictureService;
@Controller
public class IndexNewsIndexPictureController {
	@Autowired
	private NewsIndexPictureService indexNewsPictureService;
	
	@RequestMapping(value = "/NewsIndexPictureList.html")
	public String NewsIndexPictureList(
		Integer id,
		String name,
		String sortingadd_time,//��Ʒ�����ѯ;��������
		String conditionsByAll,//������ģ����ѯ����
		Integer page, HttpServletRequest request) {
		//---------------------------------------��ѯ������ʼ
		Map<String, Object> map = new HashMap<String, Object>();
		if(id!=null) {map.put("id", id);}//�Ƿ��Ǹ���id��ѯ�����򷵻ص���ϸ��Ʒ��Ϣҳ��
		if(name!=null) {
			try {name = new String (name.getBytes("iso8859-1"),"UTF-8");
				 map.put("name", name);//������ģ����ѯ����
			} catch (UnsupportedEncodingException e) {}//�������
		}else{name=null;}
		//��ҳ����������������Ʒ
		if(conditionsByAll!=null) {
			try {
				conditionsByAll = new String (conditionsByAll.getBytes("iso8859-1"),"UTF-8");
				map.put("conditionsall", conditionsByAll);//��������
			} catch (UnsupportedEncodingException e) {}//�������
		}else{conditionsByAll=null;}
		//��Ʒ�����ѯ;��������
		if(sortingadd_time!=null) {
			if(sortingadd_time!=null && sortingadd_time.equals("diminishing")) {map.put("sortingadd_time","diminishing");}
		}else {map.put("sortingid","diminishing");}
		//---------------------------------------��ѯ��������
		//---------------------------------------��ҳ��ʼ
		int num=10;//ÿҳ��ʾ����
		int count = indexNewsPictureService.findNewsIndexPictureCount(map);// ��ѯ��¼��
		int maxPage = PageBean.maxPage(count, num);// ��ȡ��ҳ��
		if (page == null || page < 1) {page = 1;}// ��֤page
		if (page > maxPage) {page = maxPage;}// ��֤page
		PageBean pageBean = new PageBean(page, num);// ��װ��ҳ
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//---------------------------------------��ҳ����
		List<NewsIndexPicture> NewsIndexPictureList= indexNewsPictureService.findNewsIndexPictureList(map);
		
		//---------------------------------------�������ݿ�ʼ
		request.setAttribute("NewsIndexPicturepage", page);
		request.setAttribute("NewsIndexPicturetotal", count);
		request.setAttribute("NewsIndexPicturemaxPage", maxPage);
		request.setAttribute("NewsIndexPictureList", NewsIndexPictureList);
		request.setAttribute("conditionsByAll", conditionsByAll);
		request.setAttribute("sortingadd_time", sortingadd_time);
		//---------------------------------------�������ݽ���
		//����ҳ��
		
		return "index";
	}
}
