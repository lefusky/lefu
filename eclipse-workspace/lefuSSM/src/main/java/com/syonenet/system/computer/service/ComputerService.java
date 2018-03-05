package com.syonenet.system.computer.service;

import java.util.List;
import java.util.Map;

import com.syonenet.entity.Computer;
import com.syonenet.entity.OneLevel;
import com.syonenet.entity.TwoLevel;

public interface ComputerService {
	public List<Computer> findComputerList(Map<String, Object> map);
	
	public List<Computer> findComputerListhtml(Map<String, Object> map);
	
	public int findComputerCount(Map<String, Object> map);
	
	public int findComputerCounthtml(Map<String, Object> map);
	
	public Computer findComputersByCondition(Map<String, Object> map);
	
	public List<Computer> findComputersByConditionToindex_1(Map<String, Object> map);
	
	public int addComputer(Computer computer);
	
	public int updateComputer(Computer computer);
	
	public int deleteComputer(Integer computer_id);
	
	public List<OneLevel> findOneLevelList();
	
	public List<TwoLevel> findTwoLevelList();
	
	public OneLevel findOneLevelById(Integer one_level_id);
	
	public TwoLevel findTwoLevelById(Integer two_level_id);
	
	public List<Computer> findComputerByComputerId(Map<String, Object> map);
	
	public String findPicture1ByComputerName(String computer_name);
	
	//��Ʒ������ɸѡ�����¼����ڡ��۸�
	public List<Computer> sortingComputerByAll(Map<String, Object> map);
	public List<Computer> sortingComputerByprice(Map<String, Object> map);
	public List<Computer> sortingComputerBytime(Map<String, Object> map);
	//��Ʒ������ɸѡ���
	
	//��ҳ����������������Ʒ 
	public List<Computer> computerToSearch(Map<String, Object> map);
	//��ҳ����������������Ʒ ���
}
