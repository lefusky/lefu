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
		String conditionsByAll,//������ģ����ѯ����
		String video_core,//ɸѡ����1
		String video_memory_size,//ɸѡ����2
		String agency_price,//ɸѡ����3
		String sortingall,String sortingagency_price,String sortingadd_time,//��Ʒ�����ѯ;��������
		Integer one_level_id,
		Integer two_level_id) {
		/** ��ѯ����start */
		Map<String, Object> map = new HashMap<String, Object>();
		if(id!=null) {map.put("id", id);}//ȥ����Ʒ��ϸҳ�棬��Ʒid����
		if(conditionsByAll!=null) {//��ҳ������������Ʒ��������
			try {conditionsByAll = new String (conditionsByAll.getBytes("iso8859-1"),"UTF-8");
				 map.put("conditionsall", conditionsByAll);//������ģ����ѯ����
			} catch (UnsupportedEncodingException e) {}//�������
		}else{conditionsByAll=null;}
		if(video_core!=null) {map.put("video_core", video_core);}//ɸѡ����1
		if(video_memory_size!=null) {map.put("video_memory_size", video_memory_size);}//ɸѡ����2
		if(agency_price!=null) {//ɸѡ����3
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
		if(sortingall!=null && sortingall.equals("diminishing")) {map.put("sortingall", "diminishing");}//��Ʒ��������
		else if(sortingagency_price!=null && sortingagency_price.equals("increasing")) {map.put("sortingagency_price","increasing");}
		else if(sortingagency_price!=null && sortingagency_price.equals("diminishing")) {map.put("sortingagency_price","diminishing");}
		else if(sortingadd_time!=null && sortingadd_time.equals("diminishing")) {map.put("sortingadd_time","diminishing");}
		else {map.put("sortingid","diminishing");}
		//��Ʒ��������
		map.put("state", 1);//�����ϼ���Ʒ
		if(one_level_id!=null) {map.put("one_level_id", one_level_id);}
		if(two_level_id!=null) {map.put("two_level_id", two_level_id);}
		/** ��ѯ����end */
		/** ��ҳstart */
		int num=10;//ÿҳ��ʾ����
		int count = videocardService.findVideoCardCount(map);// ��ѯ��¼��
		int maxPage = PageBean.maxPage(count, num);// ��ȡ��ҳ��
		if (page == null || page < 1) {page = 1;}// ��֤page
		if (page > maxPage) {page = maxPage;}// ��֤page
		PageBean pageBean = new PageBean(page, num);// ��װ��ҳ
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		/** ��ҳend */
		List<VideoCard> videocardList= videocardService.findVideoCardList(map);
		/** ��������start */
		request.setAttribute("conditionsByAll", conditionsByAll);
		request.setAttribute("video_core", video_core);//ɸѡ����1
		request.setAttribute("video_memory_size", video_memory_size);//ɸѡ����2
		request.setAttribute("agency_price", agency_price);//ɸѡ����3
		request.setAttribute("sortingall", sortingall);
		request.setAttribute("sortingagency_price", sortingagency_price);
		request.setAttribute("sortingadd_time", sortingadd_time);
		request.setAttribute("videocardpage", page);
		request.setAttribute("videocardtotal", count);
		request.setAttribute("videocardmaxPage", maxPage);
		request.setAttribute("videocardList", videocardList);
		/** ��������end */
		/** ����ҳ��start */
		if(id!=null) {
			if(videocardList.size()==1) {request.setAttribute("videocard", videocardList.get(0));}
			return "videocardindex_2";
		}
		return "videocardindex_1";
		/** ����ҳ��end */
	}
}
