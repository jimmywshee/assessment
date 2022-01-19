package com.mbank.assess.service.impl;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbank.assess.service.IApiLoggingService;

@Service
public class ApiLoggingService implements IApiLoggingService {

	private static final Logger LOG = LoggerFactory.getLogger(ApiLoggingService.class);

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void logRequest(HttpServletRequest request) {
		LOG.info("Request URI [{}], Request Method [{}]", request.getRequestURI(), request.getMethod());
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			LOG.info("Parameter Name [{}], Value [{}]", paramName, request.getParameter(paramName));
		}
	}

	@Override
	public void logRequestBody(Object requestBody) {
		try {
			LOG.info("Request Body [{}]", objectMapper.writeValueAsString(requestBody));
		} catch (IOException e) {
			LOG.error("IOException on request body logging", e);
		}

	}
	
	@Override
	public void logResponseBody(Object responseBody) {
		try {
			LOG.info("Response Body [{}]", objectMapper.writeValueAsString(responseBody));
		} catch (IOException e) {
			LOG.error("IOException on response body logging", e);
		}

	}


}
