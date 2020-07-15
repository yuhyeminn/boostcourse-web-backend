package org.edwith.webbe.securityexam.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		 return new Class<?>[]{ApplicationConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		 return new Class<?>[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[]{"/"};
	}
	 /*
    	필터를 설정한다.
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }
}
