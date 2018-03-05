package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_groupMapper;
import com.syonenet.entity.power_group;
import com.syonenet.system.power.user.service.PowerGroupService;

@Service("powerGroupService")
public class PowerGroupServiceImpl implements PowerGroupService{
	
	@Autowired
	private power_groupMapper powerGroupMapper;

	@Override
	public int insert(power_group record) {
		// TODO Auto-generated method stub
		return powerGroupMapper.insert(record);
	}

	@Override
	public int insertSelective(power_group record) {
		// TODO Auto-generated method stub
		return powerGroupMapper.insertSelective(record);
	}

	@Override
	public List<power_group> powerGroupList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerGroupMapper.powerGroupList(map);
	}


}
