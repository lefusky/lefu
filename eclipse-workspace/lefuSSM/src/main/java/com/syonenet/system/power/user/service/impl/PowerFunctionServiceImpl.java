package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_functionMapper;
import com.syonenet.entity.power_function;
import com.syonenet.system.power.user.service.PowerFunctionService;

@Service("powerFunctionService")
public class PowerFunctionServiceImpl implements PowerFunctionService{
	
	@Autowired
	private power_functionMapper powerFunctionMapper;

	@Override
	public int insert(power_function record) {
		// TODO Auto-generated method stub
		return powerFunctionMapper.insert(record);
	}

	@Override
	public int insertSelective(power_function record) {
		// TODO Auto-generated method stub
		return powerFunctionMapper.insertSelective(record);
	}

	@Override
	public List<power_function> powerFunctionList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerFunctionMapper.powerFunctionList(map);
	}

}
