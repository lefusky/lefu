package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_rightMapper;
import com.syonenet.entity.power_right;
import com.syonenet.system.power.user.service.PowerRightService;

@Service("powerRightService")
public class PowerRightServiceImpl implements PowerRightService{
	
	@Autowired
	private power_rightMapper powerRightMapper;

	@Override
	public int insert(power_right record) {
		// TODO Auto-generated method stub
		return powerRightMapper.insert(record);
	}

	@Override
	public int insertSelective(power_right record) {
		// TODO Auto-generated method stub
		return powerRightMapper.insertSelective(record);
	}

	@Override
	public List<power_right> powerRightList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerRightMapper.powerRightList(map);
	}


}
