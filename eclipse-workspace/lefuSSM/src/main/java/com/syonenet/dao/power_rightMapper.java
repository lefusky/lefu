package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_right;

public interface power_rightMapper {
    int insert(power_right record);

    int insertSelective(power_right record);
    
    List<power_right> powerRightList(Map<String, Object> map);
}