package com.syonenet.system.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.Department;
import com.syonenet.entity.Permission;
import com.syonenet.entity.User;

public interface UserService {
	
	public List<User> findUserList(Map<String, Object> map);
	
	public int findUserCount(Map<String, Object> map);
	
	public User findUserByUserLogId(String logId);
	
	public User findUserByUserId(Integer userId);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int updateUserError(User user);
	
	public int updateUserPassWord(User user);
	
	public int updateUserPermission(User user);
	
	public int modifyUserMessage(Integer userId);

	public int deleteUser(Integer userId);
	
	public List<Department> findDepartmentList();
	
	public List<Permission> findPermissionList();
	
	public List<Permission> findPermissionListByPid(Integer pid);

}
