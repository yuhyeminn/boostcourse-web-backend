package org.edwith.webbe.securityexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.edwith.webbe.securityexam.controller"})
public class MvcConfig implements WebMvcConfigurer {

	// default servlet 핸들러를 설정한다.
	// 원래 서블릿은 / (모든 요청)을 처리하는 default servlet을 제공한다. 스프링에서 설정한 path는 스프링이 처리하고, 스프링이 처리하지 못한 경로에 대한 처리는
	// 디폴트 서블릿에게 전달하여 처리하게 된다.
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// Spring MVC에서 jsp view 가 위치하는 경로를 설정한다.
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

    // '/' 로 요청이 오면 '/main'으로 리다이렉트 하도록 합니다.
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/main");
	}

    // /resources 경로에 있는 자료들을 /resources/**로 접근하게 합니다.
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}