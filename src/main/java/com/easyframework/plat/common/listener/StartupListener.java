package com.easyframework.plat.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * @Title: StartupListener.java
 * @Description: TODO
 * @author 邹凯明
 * @date 2013-11-25 下午11:01:33
 * @最后修改人：邹凯明
 * @最后修改时间：2013-11-25 下午11:01:33
 * @version V1.0
 * @copyright: 
 */
public class StartupListener implements ServletContextListener {
	
	/**
	 * 在这个方法里配置容器启动时需要做的操作
	 */
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		//UserService userService = wc.getBean(UserService.class);
		//TODO 
		
	}
	
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
