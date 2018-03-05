package com.syonenet.system.news.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.NewsDao;
import com.syonenet.entity.News;
import com.syonenet.entity.NewsType;
import com.syonenet.system.news.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Override
	public List<News> findNewsList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsDao.findNewsList(map);
	}
	
	@Override
	public int findNewsCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsDao.findNewsCount(map);
	}
	
	@Override
	public News findNewsById(Integer newsId) {
		// TODO Auto-generated method stub
		return newsDao.findNewsById(newsId);
	}
	
	@Override
	public News findNewsByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsDao.findNewsByCondition(map);
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news);
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.updateNews(news);
	}
	
	@Override
	public int updateNewsCount(Integer newsId) {
		// TODO Auto-generated method stub
		return newsDao.updateNewsCount(newsId);
	}

	@Override
	public int deleteNews(Integer newsId) {
		// TODO Auto-generated method stub
		return newsDao.deleteNews(newsId);
	}

	@Override
	public List<NewsType> findNewsTypeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsDao.findNewsTypeList(map);
	}
	
	@Override
	public int findNewsTypeCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newsDao.findNewsCount(map);
	}

	@Override
	public NewsType findNewsTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		return newsDao.findNewsTypeById(typeId);
	}
	
	@Override
	public List<NewsType> findNewsTypeListByPid(Integer typePid) {
		// TODO Auto-generated method stub
		return newsDao.findNewsTypeListByPid(typePid);
	}
	
	@Override
	public int addNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		return newsDao.addNewsType(newsType);
	}

	@Override
	public int updateNewsType(NewsType newsType) {
		// TODO Auto-generated method stub
		return newsDao.updateNewsType(newsType);
	}

	@Override
	public int deleteNewsType(Integer typeId) {
		// TODO Auto-generated method stub
		return newsDao.deleteNewsType(typeId);
	}

	@Override
	public int findNewsCountByTypeId(Integer typeId) {
		// TODO Auto-generated method stub
		return newsDao.findNewsCountByTypeId(typeId);
	}

}
