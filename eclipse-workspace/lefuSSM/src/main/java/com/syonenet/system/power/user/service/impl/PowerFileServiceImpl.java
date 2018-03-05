package com.syonenet.system.power.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.power_fileMapper;
import com.syonenet.entity.power_file;
import com.syonenet.system.power.user.service.PowerFileService;

@Service("powerFileService")
public class PowerFileServiceImpl implements PowerFileService{
	
	@Autowired
	private power_fileMapper powerFileMapper;

	@Override
	public int insert(power_file record) {
		// TODO Auto-generated method stub
		return powerFileMapper.insert(record);
	}

	@Override
	public int insertSelective(power_file record) {
		// TODO Auto-generated method stub
		return powerFileMapper.insertSelective(record);
	}

	@Override
	public List<power_file> powerFileList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return powerFileMapper.powerFileList(map);
	}


}
