package com.syonenet.system.init;

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

import com.syonenet.entity.power_menu;
import com.syonenet.system.power.user.service.PowerMenuService;

/**
* Copyright (C), 2018-2030, ShenYang Lovo info. Co., Ltd.
* FileName: AdminInitComponent.java
* 后台初始化数据
*
* @author  lefu
* @Date    2018-02-12
* @version 1.00
*/
@Component("adminInitComponent")
public class AdminInitComponent implements ApplicationContextAware, ServletContextListener {
	
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
		PowerMenuService powerMenuService = (PowerMenuService) applicationContext.getBean("powerMenuService");
				
		//init power_menu
		Map<String, Object> map = new HashMap<>();
		List<power_menu> powerMenuList = powerMenuService.powerMenuList(map);
		application.setAttribute("powerMenuList", powerMenuList);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// get the appropriate scope
		ServletContext application = sce.getServletContext();
		initData(application);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
