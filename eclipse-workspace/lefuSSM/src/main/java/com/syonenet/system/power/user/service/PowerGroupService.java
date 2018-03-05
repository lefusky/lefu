package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_group;

public interface PowerGroupService {
	int insert(power_group record);

    int insertSelective(power_group record);
    
    List<power_group> powerGroupList(Map<String, Object> map);
}
