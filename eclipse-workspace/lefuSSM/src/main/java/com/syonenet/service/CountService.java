package com.syonenet.service;

import com.syonenet.entity.Count;

public interface CountService {
	
	public Count findCountById();
	
	public int updateCount(Count count);

}
