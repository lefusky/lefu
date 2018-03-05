package com.syonenet.system.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.themeMapper;
import com.syonenet.entity.theme;
import com.syonenet.system.user.service.ThemeService;
@Service("themeService")
public class ThemeServiceImpl implements ThemeService{
	@Autowired
	private themeMapper themeDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(theme record) {
		// TODO Auto-generated method stub
		return themeDao.insert(record);
	}

	@Override
	public int insertSelective(theme record) {
		// TODO Auto-generated method stub
		return themeDao.insertSelective(record);
	}

	@Override
	public theme selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(theme record) {
		// TODO Auto-generated method stub
		return themeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(theme record) {
		// TODO Auto-generated method stub
		return themeDao.updateByPrimaryKey(record);
	}

}
