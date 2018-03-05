package com.syonenet.system.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.syonenet.entity.theme;
import com.syonenet.system.user.service.ThemeService;

@Controller
@RequestMapping("/system")
public class ThemeController {
	@Autowired
	private ThemeService themeService;
	
	@RequestMapping(value = "/theme.do")
	public String userList(int theme_id,HttpServletRequest request) throws Exception {
		theme theme = themeService.selectByPrimaryKey(theme_id);
		request.setAttribute("theme", theme.getName());
		return "system/index";
	}
}
