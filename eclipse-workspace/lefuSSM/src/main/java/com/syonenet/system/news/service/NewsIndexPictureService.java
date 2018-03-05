package com.syonenet.system.news.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.NewsIndexPicture;

public interface NewsIndexPictureService {
	public List<NewsIndexPicture> findNewsIndexPictureList(Map<String, Object> map);
	public int findNewsIndexPictureCount(Map<String, Object> map);
	public int addNewsIndexPicture(NewsIndexPicture newsIndexPicture);
	public int updateNewsIndexPicture(NewsIndexPicture newsIndexPicture);
	public int deleteNewsIndexPicture(Integer id);
}
