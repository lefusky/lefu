package com.syonenet.system.news.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.News;
import com.syonenet.entity.NewsType;

public interface NewsService {
	
	public List<News> findNewsList(Map<String, Object> map);
	
	public int findNewsCount(Map<String, Object> map);
	
	public News findNewsById(Integer newsId);
	
	public News findNewsByCondition(Map<String, Object> map);

	public int addNews(News news);

	public int updateNews(News news);
	
	public int updateNewsCount(Integer newsId);

	public int deleteNews(Integer newsId);

	public List<NewsType> findNewsTypeList(Map<String, Object> map);
	
	public int findNewsTypeCount(Map<String, Object> map);
	
	public NewsType findNewsTypeById(Integer typeId);
	
	public List<NewsType> findNewsTypeListByPid(Integer typePid);

	public int addNewsType(NewsType newsType);

	public int updateNewsType(NewsType newsType);

	public int deleteNewsType(Integer typeId);
	
	public int findNewsCountByTypeId(Integer typeId);

}
