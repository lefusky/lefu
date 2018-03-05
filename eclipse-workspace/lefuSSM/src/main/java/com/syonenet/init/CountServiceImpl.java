package com.syonenet.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.CountDao;
import com.syonenet.entity.Count;
import com.syonenet.service.CountService;

@Service("countService")
public class CountServiceImpl implements CountService {

	@Autowired
	private CountDao countDao;
	
	@Override
	public Count findCountById() {
		// TODO Auto-generated method stub
		return countDao.findCountById();
	}

	@Override
	public int updateCount(Count count) {
		// TODO Auto-generated method stub
		return countDao.updateCount(count);
	}

}
