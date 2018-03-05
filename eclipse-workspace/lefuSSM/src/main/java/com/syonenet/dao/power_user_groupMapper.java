package com.syonenet.dao;

import com.syonenet.entity.power_user_group;

public interface power_user_groupMapper {
    int insert(power_user_group record);

    int insertSelective(power_user_group record);
}