package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_role;

public interface power_roleMapper {
    int insert(power_role record);

    int insertSelective(power_role record);
    
    List<power_role> powerRoleList(Map<String, Object> map);
}