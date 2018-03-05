package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_role;

public interface PowerRoleService {
	int insert(power_role record);

    int insertSelective(power_role record);
    
    List<power_role> powerRoleList(Map<String, Object> map);
}
