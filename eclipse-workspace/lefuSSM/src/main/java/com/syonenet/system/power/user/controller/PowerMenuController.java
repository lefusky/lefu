package com.syonenet.system.power.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.power_menu;
import com.syonenet.system.power.user.service.PowerMenuService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller("powerMenuController")
@RequestMapping("/system")
public class PowerMenuController {
	@Autowired
	private PowerMenuService powerMenuService;
	
	@RequestMapping(value="/powerMenuList.do")
	public String PowerMenuList(HttpServletResponse response) throws Exception {
		
		Map<String,Object> map= new HashMap<>();
		
		List<power_menu> powerMenuList= powerMenuService.powerMenuList(map);
		
		JSONObject object=new JSONObject();
			JsonConfig jsonConfig=new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd"));
			JSONArray jsonArray= JSONArray.fromObject(powerMenuList,jsonConfig);
		object.put("rows", jsonArray);
		
		ResponseUtil.write(response, object);
		System.out.println(object);
		
		return null;
	}
}
