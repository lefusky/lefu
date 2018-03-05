package com.syonenet.system.videocard.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.VideoCard;

public interface VideoCardService {
	public List<VideoCard> findVideoCardList(Map<String, Object> map);
	public int findVideoCardCount(Map<String, Object> map);
	public int addVideoCard(VideoCard videocard);
	public int updateVideoCard(VideoCard videocard);
	public int deleteVideoCard(Integer id);
}
