package com.syonenet.system.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.Permission;
import com.syonenet.entity.TreeNode;
import com.syonenet.entity.User;
import com.syonenet.util.ResponseUtil;
import com.syonenet.util.TreeBuilder;

@Controller
@RequestMapping(value = "/system")
public class PermissionController {

	/**
	 * 获取所有权限
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/permissionList.do")
	public String permissionList(HttpServletRequest request,HttpServletResponse response) throws Exception {

		User user = (User) request.getSession().getAttribute("USER");
		ServletContext application = request.getServletContext();

		List<Permission> permissionList = null;
		List<TreeNode> treeNodes = new ArrayList<>();

		JSONArray array = null;

		if (user.getRoleId() == 1) {
			// 获取所有权限
			permissionList = (List<Permission>) application.getAttribute("permissionTypes");
			for (Permission permission : permissionList) {
				TreeNode treeNode = new TreeNode(permission.getPermissionId(),
						permission.getPermissionName(),
						permission.getPermissionPid(),
						permission.getPermissionEnd(),
						permission.getPermissionUrl(),
						permission.getPermissionDesc());
				treeNodes.add(treeNode);
			}
			array = JSONArray.fromObject(TreeBuilder.bulid(treeNodes));
		} else {
			// 获取自己的权限
			permissionList = user.getPermissionList();
			if (permissionList != null && permissionList.size() > 0) {
				for (Permission permission : permissionList) {
					TreeNode treeNode = new TreeNode(
							permission.getPermissionId(),
							permission.getPermissionName(),
							permission.getPermissionPid(),
							permission.getPermissionEnd(),
							permission.getPermissionUrl(),
							permission.getPermissionDesc());
					treeNodes.add(treeNode);
				}
				array = JSONArray.fromObject(TreeBuilder.bulid(treeNodes));
			}
		}
		ResponseUtil.write(response, array);
		return null;
	}

}
