package com.practiced.rca.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfig {
	
	@Bean
	FilterRegistrationBean<Filter> jwtFilter() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new JwtFilter());
        filter.addUrlPatterns("/api/auth/*");
        return filter;
    }
	
}
