package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_roleMapper;
import com.syonenet.entity.power_role;
import com.syonenet.system.power.user.service.PowerRoleService;

@Service("powerRoleService")
public class PowerRoleServiceImpl implements PowerRoleService{
	
	@Autowired
	private power_roleMapper powerRoleMapper;

	@Override
	public int insert(power_role record) {
		// TODO Auto-generated method stub
		return powerRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(power_role record) {
		// TODO Auto-generated method stub
		return powerRoleMapper.insertSelective(record);
	}

	@Override
	public List<power_role> powerRoleList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerRoleMapper.powerRoleList(map);
	}

	
}
