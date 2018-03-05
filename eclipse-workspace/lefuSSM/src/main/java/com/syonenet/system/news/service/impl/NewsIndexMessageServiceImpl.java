package com.syonenet.system.news.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.NewsIndexMessageDao;
import com.syonenet.entity.NewsIndexMessage;
import com.syonenet.system.news.service.NewsIndexMessageService;

@Service("newsIndexMessageService")
public class NewsIndexMessageServiceImpl implements NewsIndexMessageService {
	@Autowired
	private NewsIndexMessageDao newsIndexMessagedao;

	@Override
	public List<NewsIndexMessage> findNewsIndexMessageList(Map<String, Object> map){return newsIndexMessagedao.findNewsIndexMessageList(map);}
	@Override
	public int findNewsIndexMessageCount(Map<String, Object> map){return newsIndexMessagedao.findNewsIndexMessageCount(map);}
	@Override
	public int addNewsIndexMessage(NewsIndexMessage NewsIndexMessage){return newsIndexMessagedao.addNewsIndexMessage(NewsIndexMessage);}
	@Override
	public int updateNewsIndexMessage(NewsIndexMessage NewsIndexMessage){return newsIndexMessagedao.updateNewsIndexMessage(NewsIndexMessage);}
	@Override
	public int deleteNewsIndexMessage(Integer id){return newsIndexMessagedao.deleteNewsIndexMessage(id);}
}
