package com.mbank.assess.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mbank.assess.service.IApiLoggingService;

@Component
public class ApiLogInterceptor implements HandlerInterceptor {

	@Autowired
	IApiLoggingService loggingService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())) {
			loggingService.logRequest(request); 
		}

		return true;
	}

}