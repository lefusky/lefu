package com.syonenet.dao;

import com.syonenet.entity.Count;

public interface CountDao {
	
	public Count findCountById();
	
	public int updateCount(Count count);

}
