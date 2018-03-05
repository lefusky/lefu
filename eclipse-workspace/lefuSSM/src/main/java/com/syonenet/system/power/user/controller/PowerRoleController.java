package com.syonenet.system.power.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.power_role;
import com.syonenet.system.power.user.service.PowerRoleService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller("powerRoleController")
@RequestMapping("/system")
public class PowerRoleController {
	@Autowired
	private PowerRoleService powerRoleService;
	
	@RequestMapping(value="/powerRoleList.do")
	public String PowerRoleList(HttpServletResponse response) throws Exception {
		
		Map<String,Object> map= new HashMap<>();
		
		List<power_role> powerRoleList= powerRoleService.powerRoleList(map);
		
		JSONObject object=new JSONObject();
			JsonConfig jsonConfig=new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd"));
			JSONArray jsonArray= JSONArray.fromObject(powerRoleList,jsonConfig);
		object.put("rows", jsonArray);
		
		ResponseUtil.write(response, object);
		System.out.println(object);
		
		return null;
	}
}
