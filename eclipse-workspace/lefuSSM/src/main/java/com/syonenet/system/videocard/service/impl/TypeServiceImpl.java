package com.syonenet.system.videocard.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.TypeDao;
import com.syonenet.entity.NewsType;
import com.syonenet.system.videocard.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao typeDao;

	@Override
	public List<NewsType> findNewsTypeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return typeDao.findNewsTypeList(map);
	}
	
	@Override
	public int findNewsTypeCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return typeDao.findNewsTypeCount(map);
	}

	@Override
	public NewsType findNewsTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		return typeDao.findNewsTypeById(typeId);
	}
	
	@Override
	public List<NewsType> findNewsTypeListByPid(Integer typePid) {
		// TODO Auto-generated method stub
		return typeDao.findNewsTypeListByPid(typePid);
	}
	
	@Override
	public int addNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		return typeDao.addNewsType(newsType);
	}

	@Override
	public int updateNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		return typeDao.updateNewsType(newsType);
	}

	@Override
	public int deleteNewsType(Integer typeId) {
		// TODO Auto-generated method stub
		return typeDao.deleteNewsType(typeId);
	}

	@Override
	public int findNewsCountByTypeId(Integer typeId) {
		// TODO Auto-generated method stub
		return typeDao.findNewsCountByTypeId(typeId);
	}

}
