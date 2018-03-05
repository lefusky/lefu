package com.syonenet.system.power.user.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.power_file;

public interface PowerFileService {
	int insert(power_file record);

    int insertSelective(power_file record);

    List<power_file> powerFileList(Map<String, Object> map);
}
