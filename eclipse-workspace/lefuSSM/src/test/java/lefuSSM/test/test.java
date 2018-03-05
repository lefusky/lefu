package lefuSSM.test;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syonenet.entity.demo;
import com.syonenet.system.demo.service.DemoService;

public class test {
	private static final Logger logger = LoggerFactory.getLogger(test.class);  
	@Test
	public void demoTest() {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoService p=ctx.getBean("demoService", DemoService.class);
		List<demo> a=p.selectAll();
		logger.info(a.toString());
	}
}
