package com.syonenet.dao;

import java.util.List;

import com.syonenet.entity.demo;

public interface demoMapper {
	List<demo> selectAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(demo record);

    int insertSelective(demo record);

    demo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(demo record);

    int updateByPrimaryKey(demo record);
}