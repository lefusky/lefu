package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_menu;

public interface PowerMenuService {
	int insert(power_menu record);

    int insertSelective(power_menu record);
    
    List<power_menu> powerMenuList(Map<String, Object> map);
}
