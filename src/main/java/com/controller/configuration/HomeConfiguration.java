package com.controller.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.service.UserServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.controller")
public class HomeConfiguration {

	/*
	@Bean
	public UserServiceImpl userService() {
		return new UserServiceImpl();
	}
	public ModelAndView getView() {
		return new ModelAndView("register.jsp");
	}

	*/

}
