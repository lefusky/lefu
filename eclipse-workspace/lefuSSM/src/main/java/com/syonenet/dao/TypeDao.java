package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.NewsType;

public interface TypeDao {

	public List<NewsType> findNewsTypeList(Map<String, Object> map);
	
	public int findNewsTypeCount(Map<String, Object> map);
	
	public NewsType findNewsTypeById(Integer typeId);

	public List<NewsType> findNewsTypeListByPid(Integer typePid);

	public int addNewsType(NewsType newsType);

	public int updateNewsType(NewsType newsType);

	public int deleteNewsType(Integer typeId);
	
	public int findNewsCountByTypeId(Integer typeId);

}
