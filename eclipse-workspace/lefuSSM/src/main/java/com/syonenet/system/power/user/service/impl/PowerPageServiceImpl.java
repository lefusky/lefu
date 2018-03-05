package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_pageMapper;
import com.syonenet.entity.power_page;
import com.syonenet.system.power.user.service.PowerPageService;

@Service("powerPageService")
public class PowerPageServiceImpl implements PowerPageService{
	
	@Autowired
	private power_pageMapper powerPageMapper;

	@Override
	public int insert(power_page record) {
		// TODO Auto-generated method stub
		return powerPageMapper.insert(record);
	}

	@Override
	public int insertSelective(power_page record) {
		// TODO Auto-generated method stub
		return powerPageMapper.insertSelective(record);
	}

	@Override
	public List<power_page> powerPageList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerPageMapper.powerPageList(map);
	}

	

}
