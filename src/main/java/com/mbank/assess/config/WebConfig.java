package com.mbank.assess.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.mbank.assess.interceptor.ApiLogInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	ApiLogInterceptor apiLogInterceptor;

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLogInterceptor).addPathPatterns("/public/v1/**");;
    }
	
}
