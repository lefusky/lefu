package com.syonenet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.Computer;
import com.syonenet.entity.Department;
import com.syonenet.entity.Permission;
import com.syonenet.system.computer.service.ComputerService;
import com.syonenet.system.user.service.UserService;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * 信息发布
 * 
 * @author yzls
 *
 */
@Controller
@RequestMapping(value = "/system")
public class RefrehController {

	@Autowired
	private ComputerService computerService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/doRefreshSystem.do")
	public String doRefreshSystem(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ServletContext application = request.getServletContext();
		

		// 获取所有部门信息
		List<Department> departmentTypes = userService.findDepartmentList();
		application.setAttribute("departmentTypes", departmentTypes);
		
		// 获取所有用户权限
		List<Permission> permissionList = userService.findPermissionList();
		application.setAttribute("permissionTypes", permissionList);
		

		Map<String, Object> map = new HashMap<>();

		// 已审核，置顶，从0开始
		map.put("statusId", 1); 
		map.put("topId", 1);
		map.put("start", 0);
		
		
		// 首页商品展示
		map.put("size", 5);
		map.put("typeId", 2);
		List<Computer> computersList = computerService.findComputerList(map );
		application.setAttribute("pictureList", computersList);

		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

}
