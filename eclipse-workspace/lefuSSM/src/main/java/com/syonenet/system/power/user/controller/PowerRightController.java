package com.syonenet.system.power.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.power_right;
import com.syonenet.system.power.user.service.PowerRightService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller("powerRightController")
@RequestMapping("/system")
public class PowerRightController {
	@Autowired
	private PowerRightService powerRightService;
	
	@RequestMapping(value="/powerRightList.do")
	public String PowerRightList(HttpServletResponse response) throws Exception {
		
		Map<String,Object> map= new HashMap<>();
		
		List<power_right> powerRightList= powerRightService.powerRightList(map);
		
		JSONObject object=new JSONObject();
			JsonConfig jsonConfig=new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd"));
			JSONArray jsonArray= JSONArray.fromObject(powerRightList,jsonConfig);
		object.put("rows", jsonArray);
		
		ResponseUtil.write(response, object);
		System.out.println(object);
		
		return null;
	}
}
