package com.example.JWTDemo;

import com.example.JWTDemo.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(JwtDemoApplication.class, args);

	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean  filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/*");
		return filterRegistrationBean;
	}

}
