package com.koushik.movieflix;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WebConfig.class, JPAConfig.class,JWTFilter.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/api/*"};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new JWTFilter()};
	}
	
}
