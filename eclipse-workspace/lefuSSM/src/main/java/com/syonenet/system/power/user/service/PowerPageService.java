package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_page;

public interface PowerPageService {
	int insert(power_page record);

    int insertSelective(power_page record);
    
    List<power_page> powerPageList(Map<String, Object> map);
}
