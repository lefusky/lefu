package com.syonenet.index.news.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.NewsIndexMessage;
import com.syonenet.entity.PageBean;
import com.syonenet.system.news.service.NewsIndexMessageService;
@Controller
public class IndexNewsIndexMessageController {
	@Autowired
	private NewsIndexMessageService indexNewsMessageService;
	
	@RequestMapping(value = "/NewsIndexMessageList.html")
	public String NewsIndexMessageList(
		Integer id,
		String name,
		String message_tile,
		String sortingadd_time,//商品排序查询;排序条件
		String conditionsByAll,//搜索栏模糊查询条件
		Integer page, HttpServletRequest request) {
		//---------------------------------------查询条件开始
		Map<String, Object> map = new HashMap<String, Object>();
		if(id!=null) {map.put("id", id);}//是否是根据id查询，是则返回到详细商品信息页面
		if(name!=null) {
			try {name = new String (name.getBytes("iso8859-1"),"UTF-8");
				 map.put("name", name);//搜索栏模糊查询条件
			} catch (UnsupportedEncodingException e) {}//解决乱码
		}else{name=null;}
		if(message_tile!=null) {
			try {message_tile = new String (message_tile.getBytes("iso8859-1"),"UTF-8");
				 map.put("message_tile", message_tile);//搜索栏模糊查询条件
			} catch (UnsupportedEncodingException e) {}//解决乱码
		}else{message_tile=null;}
		//各页面主搜索框搜索商品
		if(conditionsByAll!=null) {
			try {
				conditionsByAll = new String (conditionsByAll.getBytes("iso8859-1"),"UTF-8");
				map.put("conditionsall", conditionsByAll);//排序条件
			} catch (UnsupportedEncodingException e) {}//解决乱码
		}else{conditionsByAll=null;}
		//商品排序查询;排序条件
		if(sortingadd_time!=null) {
			if(sortingadd_time!=null && sortingadd_time.equals("diminishing")) {map.put("sortingadd_time","diminishing");}
		}else {map.put("sortingid","diminishing");}
		//---------------------------------------查询条件结束
		//---------------------------------------分页开始
		int num=10;//每页显示条数
		int count = indexNewsMessageService.findNewsIndexMessageCount(map);// 查询记录数
		int maxPage = PageBean.maxPage(count, num);// 获取总页数
		if (page == null || page < 1) {page = 1;}// 验证page
		if (page > maxPage) {page = maxPage;}// 验证page
		PageBean pageBean = new PageBean(page, num);// 封装分页
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//---------------------------------------分页结束
		List<NewsIndexMessage> NewsIndexMessageList= indexNewsMessageService.findNewsIndexMessageList(map);
		
		//---------------------------------------返回数据开始
		request.setAttribute("NewsIndexMessagepage", page);
		request.setAttribute("NewsIndexMessagetotal", count);
		request.setAttribute("NewsIndexMessagemaxPage", maxPage);
		request.setAttribute("NewsIndexMessageList", NewsIndexMessageList);
		request.setAttribute("conditionsByAll", conditionsByAll);
		request.setAttribute("sortingadd_time", sortingadd_time);
		//---------------------------------------返回数据结束
		//返回页面
		if(id!=null) {
			if(NewsIndexMessageList.size()==1) {request.setAttribute("newsIndexMessage", NewsIndexMessageList.get(0));
			return "NewsIndexMessageindex_2";}
			}
		return "NewsIndexMessageindex_1";
	}
}
