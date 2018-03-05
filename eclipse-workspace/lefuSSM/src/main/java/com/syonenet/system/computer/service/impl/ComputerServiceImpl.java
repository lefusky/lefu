package com.syonenet.system.computer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syonenet.dao.ComputerDao;
import com.syonenet.entity.Computer;
import com.syonenet.entity.OneLevel;
import com.syonenet.entity.TwoLevel;
import com.syonenet.system.computer.service.ComputerService;

@Service("computerService")
public class ComputerServiceImpl implements ComputerService{
	@Autowired
	private ComputerDao computerDao;

	@Override
	public List<Computer> findComputerList(Map<String, Object> map) {return computerDao.findComputerList(map);}
	@Override
	public int findComputerCount(Map<String, Object> map) {return computerDao.findComputerCount(map);}
	@Override
	public int findComputerCounthtml(Map<String, Object> map) {return computerDao.findComputerCounthtml(map);
	}
	@Override
	public int addComputer(Computer computer) {return computerDao.addComputer(computer);}
	@Override
	public int updateComputer(Computer computer) {return computerDao.updateComputer(computer);}
	@Override
	public int deleteComputer(Integer computer_Id) {return computerDao.deleteComputer(computer_Id);}
	@Override
	public List<Computer> findComputerByComputerId(Map<String, Object> map) {return computerDao.findComputerByComputerId(map);}
	@Override
	public List<OneLevel> findOneLevelList() {return computerDao.findOneLevelList();}
	@Override
	public List<TwoLevel> findTwoLevelList() {return computerDao.findTwoLevelList();}
	@Override
	public OneLevel findOneLevelById(Integer one_level_id) {return computerDao.findOneLevelById(one_level_id);}
	@Override
	public TwoLevel findTwoLevelById(Integer two_level_id) {return computerDao.findTwoLevelById(two_level_id);}
	@Override
	public String findPicture1ByComputerName(String computer_name) {return computerDao.findPicture1ByComputerName(computer_name);}
	@Override
	public Computer findComputersByCondition(Map<String, Object> map) {return computerDao.findComputersByCondition(map);}
	@Override
	public List<Computer> findComputersByConditionToindex_1(Map<String, Object> map) {return computerDao.findComputersByConditionToindex_1(map);}
	@Override
	public List<Computer> findComputerListhtml(Map<String, Object> map) {return computerDao.findComputerListhtml(map);}
	//商品升降序筛选：上下架日期、价格
	@Override
	public List<Computer> sortingComputerByAll(Map<String, Object> map) {return computerDao.sortingComputerByAll(map);}
	@Override
	public List<Computer> sortingComputerByprice(Map<String, Object> map) {return computerDao.sortingComputerByprice(map);}
	@Override
	public List<Computer> sortingComputerBytime(Map<String, Object> map) {return computerDao.sortingComputerBytime(map);}
	//商品升降序筛选完毕
	//各页面主搜索框搜索商品 
	@Override
	public List<Computer> computerToSearch(Map<String, Object> map) {return computerDao.computerToSearch(map);}
	//各页面主搜索框搜索商品 完毕
}
