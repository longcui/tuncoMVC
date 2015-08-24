package com.tunco.configuration.core;

import com.tunco.configuration.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
    protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class<?>[]{ServletConfiguration.class};
//	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}