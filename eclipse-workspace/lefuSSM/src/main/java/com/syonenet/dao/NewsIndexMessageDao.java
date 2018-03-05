package com.syonenet.dao;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.NewsIndexMessage;

public interface NewsIndexMessageDao {
	public List<NewsIndexMessage> findNewsIndexMessageList(Map<String, Object> map);
	public int findNewsIndexMessageCount(Map<String, Object> map);
	public int addNewsIndexMessage(NewsIndexMessage newsIndexMessage);
	public int updateNewsIndexMessage(NewsIndexMessage newsIndexMessage);
	public int deleteNewsIndexMessage(Integer id);
}
