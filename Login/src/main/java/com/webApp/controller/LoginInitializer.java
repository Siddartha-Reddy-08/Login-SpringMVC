package com.webApp.controller;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LoginInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Servlet Config");
		Class<?> arr[] = { LoginConfig.class };
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Servlet Mapping");
		String arr[] = { "/" };
		return arr;
	}

}
