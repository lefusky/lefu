package com.syonenet.system.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.demoMapper;
import com.syonenet.entity.demo;
import com.syonenet.system.demo.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService{
	@Autowired 
	demoMapper demoDao;

	@Override
	public List<demo> selectAll() {
		// TODO Auto-generated method stub
		return demoDao.selectAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return demoDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(demo record) {
		// TODO Auto-generated method stub
		return demoDao.insert(record);
	}

	@Override
	public int insertSelective(demo record) {
		// TODO Auto-generated method stub
		return demoDao.insertSelective(record);
	}

	@Override
	public demo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return demoDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(demo record) {
		// TODO Auto-generated method stub
		return demoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(demo record) {
		// TODO Auto-generated method stub
		return demoDao.updateByPrimaryKey(record);
	}
	
	
}
