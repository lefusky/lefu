package com.syonenet.system.news.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.NewsIndexPictureDao;
import com.syonenet.entity.NewsIndexPicture;
import com.syonenet.system.news.service.NewsIndexPictureService;

@Service("newsIndexPictureService")
public class NewsIndexPictureServiceImpl implements NewsIndexPictureService{
	@Autowired
	private NewsIndexPictureDao newsIndexPicturedao;

	@Override
	public List<NewsIndexPicture> findNewsIndexPictureList(Map<String, Object> map){return newsIndexPicturedao.findNewsIndexPictureList(map);}
	@Override
	public int findNewsIndexPictureCount(Map<String, Object> map){return newsIndexPicturedao.findNewsIndexPictureCount(map);}
	@Override
	public int addNewsIndexPicture(NewsIndexPicture NewsIndexPicture){return newsIndexPicturedao.addNewsIndexPicture(NewsIndexPicture);}
	@Override
	public int updateNewsIndexPicture(NewsIndexPicture NewsIndexPicture){return newsIndexPicturedao.updateNewsIndexPicture(NewsIndexPicture);}
	@Override
	public int deleteNewsIndexPicture(Integer id){return newsIndexPicturedao.deleteNewsIndexPicture(id);}
}
