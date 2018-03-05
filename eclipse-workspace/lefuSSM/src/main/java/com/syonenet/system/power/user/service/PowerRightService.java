package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_right;

public interface PowerRightService {
	int insert(power_right record);

    int insertSelective(power_right record);
    
    List<power_right> powerRightList(Map<String, Object> map);
}
