package com.syonenet.system.user.service;

import com.syonenet.entity.theme;

public interface ThemeService {
	int deleteByPrimaryKey(Integer id);

    int insert(theme record);

    int insertSelective(theme record);

    theme selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(theme record);

    int updateByPrimaryKey(theme record);
}
