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
import com.syonenet.entity.NewsIndexMessage;
import com.syonenet.entity.PageBean;
import com.syonenet.system.news.service.NewsIndexMessageService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/system")
public class NewsIndexMessageController {
	@Autowired
	private NewsIndexMessageService newsIndexMessageService;
	//��ѯ
	@RequestMapping(value = "/newsIndexMessageList.do")
	public String newsIndexMessageList(
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
			map.put("sortingid","diminishing");
		}
		//��ѯ����
		if (id != null) {map.put("id",id);}
		if (name != null) {map.put("type",name);}
		//��ѯ����+�б�
		int total = newsIndexMessageService.findNewsIndexMessageCount(map);
		List<NewsIndexMessage> MessageList = newsIndexMessageService.findNewsIndexMessageList(map);
		//ʱ��
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(MessageList, jsonConfig);
		//��������
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}
	//���+�޸�
	@RequestMapping(value = "/newsIndexMessageSave.do")
	public File newsIndexMessageSave(NewsIndexMessage newsIndexMessage,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		int total = 0;	
		JSONObject object = new JSONObject();	
		
		// ���⸳ֵ
        newsIndexMessage.setAdd_time(new Date());
        //ִ����� �� �޸�
		if (newsIndexMessage.getId() == null) {
			// ���
			total = newsIndexMessageService.addNewsIndexMessage(newsIndexMessage);
		} else {
			// �޸�
			total = newsIndexMessageService.updateNewsIndexMessage(newsIndexMessage);
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
	@RequestMapping(value = "/newsIndexMessageDelete.do")
	public String MessageDelete(@RequestParam(value = "ids", required = false) 
		String ids, HttpServletResponse response)throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			if (Integer.parseInt(idsStr[i]) != 1) {
				newsIndexMessageService.deleteNewsIndexMessage(Integer.parseInt(idsStr[i]));
			}
		}
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}
}
