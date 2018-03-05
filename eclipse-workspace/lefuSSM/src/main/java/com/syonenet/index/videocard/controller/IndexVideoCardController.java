package com.syonenet.index.videocard.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.PageBean;
import com.syonenet.entity.VideoCard;
import com.syonenet.system.videocard.service.VideoCardService;

@Controller
public class IndexVideoCardController {
	@Autowired
	private VideoCardService videocardService;
	
	@RequestMapping(value = "/videoCardList.html")
	public String videoCardList(Integer page, HttpServletRequest request,
		Integer id,
		String conditionsByAll,//搜索栏模糊查询条件
		String video_core,//筛选条件1
		String video_memory_size,//筛选条件2
		String agency_price,//筛选条件3
		String sortingall,String sortingagency_price,String sortingadd_time,//商品排序查询;排序条件
		Integer one_level_id,
		Integer two_level_id) {
		/** 查询条件start */
		Map<String, Object> map = new HashMap<String, Object>();
		if(id!=null) {map.put("id", id);}//去往商品详细页面，商品id条件
		if(conditionsByAll!=null) {//各页面主搜索框，商品搜索条件
			try {conditionsByAll = new String (conditionsByAll.getBytes("iso8859-1"),"UTF-8");
				 map.put("conditionsall", conditionsByAll);//搜索栏模糊查询条件
			} catch (UnsupportedEncodingException e) {}//解决乱码
		}else{conditionsByAll=null;}
		if(video_core!=null) {map.put("video_core", video_core);}//筛选条件1
		if(video_memory_size!=null) {map.put("video_memory_size", video_memory_size);}//筛选条件2
		if(agency_price!=null) {//筛选条件3
			if(agency_price.equals("0-999") ) {
				map.put("price1", 0);
				map.put("price2", 999);}
			if(agency_price.equals("1000-1999") ) {
				map.put("price1", 1000);
				map.put("price2", 1999);}
			if(agency_price.equals("2000-2999") ) {
				map.put("price1", 2000);
				map.put("price2", 2999);}
			if(agency_price.equals("3000-3999") ) {
				map.put("price1", 3000);
				map.put("price2", 3999);}
			if(agency_price.equals("4000-4999") ) {
				map.put("price1", 4000);
				map.put("price2", 4999);}
			if(agency_price.equals("5000-5999") ) {
				map.put("price1", 5000);
				map.put("price2", 5999);}
			if(agency_price.equals("6000-6999") ) {
				map.put("price1", 6000);
				map.put("price2", 6999);}
			if(agency_price.equals("7000-7999") ) {
				map.put("price1", 7000);
				map.put("price2", 7999);}
			if(agency_price.equals("8000-8999") ) {
				map.put("price1", 8000);
				map.put("price2", 8999);}
			if(agency_price.equals("9000-9999") ) {
				map.put("price1", 9000);
				map.put("price2", 9999);}
			if(agency_price.equals("10000") ) {
				map.put("price1", 10000);
				map.put("price2", 100000000);}
		}
		if(sortingall!=null && sortingall.equals("diminishing")) {map.put("sortingall", "diminishing");}//商品排序条件
		else if(sortingagency_price!=null && sortingagency_price.equals("increasing")) {map.put("sortingagency_price","increasing");}
		else if(sortingagency_price!=null && sortingagency_price.equals("diminishing")) {map.put("sortingagency_price","diminishing");}
		else if(sortingadd_time!=null && sortingadd_time.equals("diminishing")) {map.put("sortingadd_time","diminishing");}
		else {map.put("sortingid","diminishing");}
		//商品其他条件
		map.put("state", 1);//查找上架商品
		if(one_level_id!=null) {map.put("one_level_id", one_level_id);}
		if(two_level_id!=null) {map.put("two_level_id", two_level_id);}
		/** 查询条件end */
		/** 分页start */
		int num=10;//每页显示条数
		int count = videocardService.findVideoCardCount(map);// 查询记录数
		int maxPage = PageBean.maxPage(count, num);// 获取总页数
		if (page == null || page < 1) {page = 1;}// 验证page
		if (page > maxPage) {page = maxPage;}// 验证page
		PageBean pageBean = new PageBean(page, num);// 封装分页
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		/** 分页end */
		List<VideoCard> videocardList= videocardService.findVideoCardList(map);
		/** 返回数据start */
		request.setAttribute("conditionsByAll", conditionsByAll);
		request.setAttribute("video_core", video_core);//筛选条件1
		request.setAttribute("video_memory_size", video_memory_size);//筛选条件2
		request.setAttribute("agency_price", agency_price);//筛选条件3
		request.setAttribute("sortingall", sortingall);
		request.setAttribute("sortingagency_price", sortingagency_price);
		request.setAttribute("sortingadd_time", sortingadd_time);
		request.setAttribute("videocardpage", page);
		request.setAttribute("videocardtotal", count);
		request.setAttribute("videocardmaxPage", maxPage);
		request.setAttribute("videocardList", videocardList);
		/** 返回数据end */
		/** 返回页面start */
		if(id!=null) {
			if(videocardList.size()==1) {request.setAttribute("videocard", videocardList.get(0));}
			return "videocardindex_2";
		}
		return "videocardindex_1";
		/** 返回页面end */
	}
}
