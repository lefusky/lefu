package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_page;

public interface power_pageMapper {
    int insert(power_page record);

    int insertSelective(power_page record);
    
    List<power_page> powerPageList(Map<String, Object> map);
}