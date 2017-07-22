package com.aibibang.app.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author King
 *
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		
		applicationContext = arg0;
	}

	/**
	 * 获取ApplicationContext
	 * 
	 * @return
	 */
	public static ApplicationContext getContext() {
		
		return applicationContext;
	}
	
	/**
	 * 根据类名获取spring注入的类
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		
		return applicationContext.getBean(beanName);
	}

}
