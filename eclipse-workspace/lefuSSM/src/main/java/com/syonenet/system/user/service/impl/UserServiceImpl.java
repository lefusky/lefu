package com.syonenet.system.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.UserDao;
import com.syonenet.entity.Department;
import com.syonenet.entity.Permission;
import com.syonenet.entity.User;
import com.syonenet.system.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findUserList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.findUserList(map);
	}

	@Override
	public int findUserCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.findUserCount(map);
	}

	@Override
	public User findUserByUserLogId(String logId) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserLogId(logId);
	}

	@Override
	public User findUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserId(userId);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int total = userDao.addUser(user);
		if(total > 0 && user.getDepartmentIds() != null && user.getDepartmentIds().size() > 0){
			userDao.addUserDepartment(user);
		}
		return total;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		int total = userDao.updateUser(user);
		if(total > 0){
			userDao.deleteUserDepartment(user.getUserId());
			if(user.getDepartmentIds() != null && user.getDepartmentIds().size() > 0){
				userDao.addUserDepartment(user);
			}
		}
		return total;
	}

	@Override
	public int updateUserError(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserError(user);
	}
	
	@Override
	public int updateUserPassWord(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserPassWord(user);
	}
	
	@Override
	public int updateUserPermission(User user) {
		// TODO Auto-generated method stub
		int total = userDao.deleteUserPermission(user.getUserId());
		if(user.getPermissionIds() != null && user.getPermissionIds().size() > 0){
			total += userDao.addUserPermission(user);
		}
		return total > 0 ? total : 1;
	}

	@Override
	public int modifyUserMessage(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.modifyUserMessage(userId);
	}

	@Override
	public int deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

	@Override
	public List<Department> findDepartmentList() {
		// TODO Auto-generated method stub
		return userDao.findDepartmentList();
	}

	@Override
	public List<Permission> findPermissionList() {
		// TODO Auto-generated method stub
		return userDao.findPermissionList();
	}
	
	@Override
	public List<Permission> findPermissionListByPid(Integer pid) {
		// TODO Auto-generated method stub
		return userDao.findPermissionListByPid(pid);
	}

}
