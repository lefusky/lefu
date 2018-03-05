package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_function;

public interface PowerFunctionService {
	int insert(power_function record);

    int insertSelective(power_function record);
    
    List<power_function> powerFunctionList(Map<String, Object> map);
}
