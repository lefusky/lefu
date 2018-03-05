package com.syonenet.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.syonenet.entity.Computer;
import com.syonenet.entity.Count;
import com.syonenet.entity.Department;
import com.syonenet.entity.News;
import com.syonenet.entity.NewsType;
import com.syonenet.entity.OneLevel;
import com.syonenet.entity.PageBean;
import com.syonenet.entity.Permission;
import com.syonenet.entity.TwoLevel;
import com.syonenet.entity.demo;
import com.syonenet.service.CountService;
import com.syonenet.system.computer.service.ComputerService;
import com.syonenet.system.demo.service.DemoService;
import com.syonenet.system.news.service.NewsIndexPictureService;
import com.syonenet.system.news.service.NewsService;
import com.syonenet.system.user.service.UserService;
import com.syonenet.system.videocard.service.TypeService;
import com.syonenet.system.videocard.service.VideoCardService;

/**
* Copyright (C), 2018-2030, ShenYang info. Co., Ltd.
* FileName: HomeInitComponent.java
* 前台初始化数据
*
* @author  lefu
* @Date    2018-02-12
* @version 1.00
*/
@Component("homeInitComponent")
public class HomeInitComponent implements ApplicationContextAware, ServletContextListener {

	/** 定义application */
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 获取applicationContext容器
		this.applicationContext = applicationContext;
	}

	/**
	 * 初始化数据
	 * 
	 * @param application
	 * @return null
	 * @throws null
	 */
	public void initData(ServletContext application) {

		ComputerService computerService = (ComputerService) applicationContext.getBean("computerService");
		VideoCardService videoCardService=(VideoCardService) applicationContext.getBean("videoCardService");
		NewsService newsService = (NewsService) applicationContext.getBean("newsService");
		UserService userService = (UserService) applicationContext.getBean("userService");
		CountService countService = (CountService) applicationContext.getBean("countService");
		TypeService typeService = (TypeService) applicationContext.getBean("typeService");
		DemoService demoService = (DemoService) applicationContext.getBean("demoService");
		NewsIndexPictureService newsIndexPictureService = (NewsIndexPictureService) applicationContext.getBean("newsIndexPictureService");
		
		// ��ȡdemo��Ϣ
		List<demo> demoList = demoService.selectAll();
		application.setAttribute("demoList", demoList);

		// 获取新闻分类信息
		List<NewsType> typeTypes = typeService.findNewsTypeList(null);
		application.setAttribute("typeTypes", typeTypes);
				
		// 获取所有部门信息
		List<Department> departmentTypes = userService.findDepartmentList();
		application.setAttribute("departmentTypes", departmentTypes);
		
		// 获取所有用户权限
		List<Permission> permissionList = userService.findPermissionList();
		application.setAttribute("permissionTypes", permissionList);
		
		// 获取一级分类
		List<OneLevel> oneLevelList = computerService.findOneLevelList();
		application.setAttribute("oneLevelList", oneLevelList);
		
		// 获取二级分类
		List<TwoLevel> twoLevelList = computerService.findTwoLevelList();
		application.setAttribute("twoLevelList", twoLevelList);
		
		Map<String, Object> map = new HashMap<>();
		
		// 已审核，置顶，从0开始
		map.put("statusId", 1); 
		map.put("topId", 1);
		map.put("start", 0);
		
		// 首页图片新闻
		map.put("size", 5);
		map.put("typeId", 2);
		List<News> newsList = newsService.findNewsList(map );
		application.setAttribute("picList", newsList);
		
		
		// 首页商品
		map.put("size", 10); 
		map.put("typeId", 2);
		List<Computer> computerList = computerService.findComputerListhtml(map );
		int count1 = computerService.findComputerCounthtml(map);
		int maxPage = PageBean.maxPage(count1, 10);
		application.setAttribute("page", 1);
		application.setAttribute("total", count1);
		application.setAttribute("maxPage", maxPage);
		application.setAttribute("computerList", computerList);
		
		// 首页华硕显卡
		map.put("size", 10);//每页十条数据
		map.put("sortingid","diminishing");//默认根据id排序
		application.setAttribute("videocardpage", 1);
		application.setAttribute("videocardtotal", videoCardService.findVideoCardCount(map));
		application.setAttribute("videocardmaxPage", PageBean.maxPage(videoCardService.findVideoCardCount(map), 10));
		application.setAttribute("videocardList", videoCardService.findVideoCardList(map));
				
			
		// 首页AOC一体机
		map.put("size", 10);//每页十条数据
		map.put("sortingid","diminishing");//默认根据id排序
		application.setAttribute("newsindexpicturepage", 1);
		application.setAttribute("newsindexpicturetotal", newsIndexPictureService.findNewsIndexPictureCount(map));
		application.setAttribute("newsindexpicturemaxPage", PageBean.maxPage(newsIndexPictureService.findNewsIndexPictureCount(map), 10));
		application.setAttribute("newsindexpictureList", newsIndexPictureService.findNewsIndexPictureList(map));


		// 首页通知
		map.put("size", 15);
		map.put("typeId", 3);
		newsList = newsService.findNewsList(map );
		application.setAttribute("noticList", newsList);
		
		// 首页公告
		map.put("size", 10);
		map.put("typeId", 4);
		newsList = newsService.findNewsList(map );
		application.setAttribute("afficheList", newsList);
		
		// 首页教学管理与研究
		map.put("size", 15);
		map.put("typeId", 5);
		newsList = newsService.findNewsList(map );
		application.setAttribute("researchList", newsList);
		
		// 首页素质教育
		map.put("size", 10);
		map.put("typeId", 6);
		newsList = newsService.findNewsList(map );
		application.setAttribute("qualityList", newsList);
		
		// 首页学生服务
		map.put("size", 15);
		map.put("typeId", 8);
		newsList = newsService.findNewsList(map );
		application.setAttribute("studentList", newsList);
		
		// 首页教师服务
		map.put("size", 10);
		map.put("typeId", 9);
		newsList = newsService.findNewsList(map );
		application.setAttribute("teacherList", newsList);
		
		// 获取统计信息
		Count count = countService.findCountById();
		application.setAttribute("count", count);
		
		application.setAttribute("theme", "default");
		
		//admin
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// 获取application作用域
		ServletContext application = sce.getServletContext();
		initData(application);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
