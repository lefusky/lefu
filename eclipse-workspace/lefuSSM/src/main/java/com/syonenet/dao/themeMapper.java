package com.syonenet.dao;

import com.syonenet.entity.theme;

public interface themeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(theme record);

    int insertSelective(theme record);

    theme selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(theme record);

    int updateByPrimaryKey(theme record);
}