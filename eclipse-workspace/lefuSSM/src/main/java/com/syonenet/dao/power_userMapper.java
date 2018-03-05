package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_user;

public interface power_userMapper {
    int insert(power_user record);

    int insertSelective(power_user record);
    
    List<power_user> powerUserList(Map<String, Object> map);
}