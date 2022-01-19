package com.mbank.assess.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.mbank.assess.constant.Constants;
import com.mbank.assess.interceptor.ApiClientLoggingInterceptor;

@Configuration
public class IntegrationConfig {
	
	@Value("${bored.activity.read.timeout}")
	private Integer boredActivityReadTimeout;

	@Value("${bored.activity.connect.timeout}")
	private Integer boredActivityConnectTimeout;

    @Bean(name = Constants.BeanNameConstants.API_CLIENT_HTTP_REQUEST_FACTORY)
    public ClientHttpRequestFactory boredApiClientHttpRequestFactory() {
      SimpleClientHttpRequestFactory simpleFactory = new SimpleClientHttpRequestFactory();
      simpleFactory.setReadTimeout(boredActivityReadTimeout);
      simpleFactory.setConnectTimeout(boredActivityConnectTimeout);

      return new BufferingClientHttpRequestFactory(simpleFactory);
    }

    @Bean(name = Constants.BeanNameConstants.API_CLIENT_REST_TEMPLATE)
    @DependsOn(value = {Constants.BeanNameConstants.API_CLIENT_HTTP_REQUEST_FACTORY})
    public RestTemplate boredApiClientRestTemplate() {
      RestTemplate restTemplate = new RestTemplate(boredApiClientHttpRequestFactory());
      ClientHttpRequestInterceptor clientHttpRequestinterceptor = new ApiClientLoggingInterceptor();
      restTemplate.setInterceptors(Collections.singletonList(clientHttpRequestinterceptor));
      return restTemplate;
    }
}
