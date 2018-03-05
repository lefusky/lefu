package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_menuMapper;
import com.syonenet.entity.power_menu;
import com.syonenet.system.power.user.service.PowerMenuService;

@Service("powerMenuService")
public class PowerMenuServiceImpl implements PowerMenuService{
	
	@Autowired
	private power_menuMapper powerMenuMapper;

	@Override
	public int insert(power_menu record) {
		// TODO Auto-generated method stub
		return powerMenuMapper.insert(record);
	}

	@Override
	public int insertSelective(power_menu record) {
		// TODO Auto-generated method stub
		return powerMenuMapper.insertSelective(record);
	}

	@Override
	public List<power_menu> powerMenuList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerMenuMapper.powerMenuList(map);
	}


}
