package com.syonenet.system.videocard.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.VideoCardDao;
import com.syonenet.entity.VideoCard;
import com.syonenet.system.videocard.service.VideoCardService;

@Service("videoCardService")
public class VideoCardServiceImpl implements VideoCardService{
	@Autowired
	private VideoCardDao videocarddao;
	@Override
	public List<VideoCard> findVideoCardList(Map<String, Object> map){return videocarddao.findVideoCardList(map);}
	@Override
	public int findVideoCardCount(Map<String, Object> map){return videocarddao.findVideoCardCount(map);}
	@Override
	public int addVideoCard(VideoCard videocard){return videocarddao.addVideoCard(videocard);}
	@Override
	public int updateVideoCard(VideoCard videocard){return videocarddao.updateVideoCard(videocard);}
	@Override
	public int deleteVideoCard(Integer id){return videocarddao.deleteVideoCard(id);}
}
