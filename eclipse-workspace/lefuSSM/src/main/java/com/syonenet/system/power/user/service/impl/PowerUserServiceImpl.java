package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_userMapper;
import com.syonenet.entity.power_user;
import com.syonenet.system.power.user.service.PowerUserService;

@Service("powerUserService")
public class PowerUserServiceImpl implements PowerUserService{
	
	@Autowired
	private power_userMapper powerUserMapper;

	@Override
	public int insert(power_user record) {
		// TODO Auto-generated method stub
		return powerUserMapper.insert(record);
	}

	@Override
	public int insertSelective(power_user record) {
		// TODO Auto-generated method stub
		return powerUserMapper.insertSelective(record);
	}

	@Override
	public List<power_user> powerUserList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerUserMapper.powerUserList(map);
	}

}
