package com.syonenet.system.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syonenet.entity.Department;
import com.syonenet.entity.PageBean;
import com.syonenet.entity.User;
import com.syonenet.system.user.service.UserService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.Encryption;
import com.syonenet.util.ResponseUtil;

/**
 * �û�����
 * 
 * @author yzls
 * 
 */
@Controller
@RequestMapping("/system")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/UserList.do")
	public String userList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		User user = (User) session.getAttribute("USER");

		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {
			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
				map.put("roleId", 3);
			} else {
				map.put("roleId", "-1");
			}
		} else {
			map.put("roleId", -1);
		}

		int total = userService.findUserCount(map);
		List<User> userList = userService.findUserList(map);

		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(userList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUserSave.do")
	public String doUserSave(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int total = 0;

		String userPassword = request.getParameter("newPassword");

		if (userPassword != null && !"".equals(userPassword)) {
			user.setUserPassword(Encryption.MD5(userPassword));
		}

		// ���⸳ֵ
		user.setAddTime(new Date());

		if (user.getUserId() == null) {
			// ���
			total = userService.addUser(user);
		} else {
			// �޸�
			total = userService.updateUser(user);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUserDelete.do")
	public String doUserDelete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			if (Integer.parseInt(idsStr[i]) != 1) {
				userService.deleteUser(Integer.parseInt(idsStr[i]));
			}
		}
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param userId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findUserById.do")
	public String findUserById(@RequestParam(value = "userId", required = true) String userId,
			HttpServletResponse response) throws Exception {
		User user = userService.findUserByUserId(Integer.parseInt(userId));
		JSONObject jsonObject = JSONObject.fromObject(user);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ��ȡ���ż���
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/departmentList.do")
	public String departmentList(HttpSession session, HttpServletResponse response) throws Exception {
		User user = (User) session.getAttribute("USER");
		List<Department> departmentList = null;
		if (user.getRoleId() == 1) {
			departmentList = userService.findDepartmentList();
		} else if (user.getRoleId() == 2) {
			departmentList = user.getDepartmentList();
		}
		JSONObject object = new JSONObject();
		JSONArray array = JSONArray.fromObject(departmentList);
		object.put("rows", array);
		object.put("total", departmentList.size());
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����Ȩ��
	 * 
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUserPermissionSave.do")
	public String doUserPermissionSave(User user, HttpServletResponse response) throws Exception {
		int total = userService.updateUserPermission(user);
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �û��޸�����
	 * 
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUserPwdModify.do")
	public String doUserPwdModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("USER");

		user.setUserPassword(Encryption.MD5(request.getParameter("newPassword1")));
		int resultTotal = userService.updateUserPassWord(user);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * �û��˳�
	 * 
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/doUserExit.do")
	public String doUserExit(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		return "redirect:/system/login.jsp";
	}

}
