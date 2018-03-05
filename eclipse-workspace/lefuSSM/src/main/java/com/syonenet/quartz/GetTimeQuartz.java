package com.syonenet.quartz;

import javax.servlet.ServletContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.syonenet.entity.Count;
import com.syonenet.service.CountService;

@Component
public class GetTimeQuartz {

	public GetTimeQuartz() {
		System.out.println("定时任务启动成功！");
	}

	/**
	 * ���µ�ǰʱ��
	 */
	//@Scheduled(cron = "0/10 * * * * ? ")
	@Scheduled(cron = "0 0 5 * * ? ")
	public void updateTime() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("nowTime", System.currentTimeMillis());
		// ��ȡservice
		CountService countService = (CountService) webApplicationContext.getBean("countService");
		// ��ȡͳ������
		Count count = (Count) servletContext.getAttribute("count");
		// ��յ��������
		count.setCountDay(0 + "");
		// ����
		countService.updateCount(count);
	}

}
