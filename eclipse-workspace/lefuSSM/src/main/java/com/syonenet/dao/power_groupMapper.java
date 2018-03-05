package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_group;

public interface power_groupMapper {
    int insert(power_group record);

    int insertSelective(power_group record);
    
    List<power_group> powerGroupList(Map<String, Object> map);
}