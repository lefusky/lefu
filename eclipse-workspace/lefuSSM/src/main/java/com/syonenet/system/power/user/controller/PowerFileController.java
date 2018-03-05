package com.syonenet.system.power.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.power_file;
import com.syonenet.system.power.user.service.PowerFileService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller("powerFileController")
@RequestMapping("/system")
public class PowerFileController {
	@Autowired
	private PowerFileService powerFileService;
	
	@RequestMapping(value="/powerFileList.do")
	public String PowerFileList(HttpServletResponse response) throws Exception {
		
		Map<String,Object> map= new HashMap<>();
		
		List<power_file> powerFileList= powerFileService.powerFileList(map);
		
		JSONObject object=new JSONObject();
			JsonConfig jsonConfig=new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd"));
			JSONArray jsonArray= JSONArray.fromObject(powerFileList,jsonConfig);
		object.put("rows", jsonArray);
		
		ResponseUtil.write(response, object);
		System.out.println(object);
		
		return null;
	}
}
