package com.mbank.assess.service;

import javax.servlet.http.HttpServletRequest;

public interface IApiLoggingService {

	void logRequest(HttpServletRequest request);

	void logRequestBody(Object requestBody);

	void logResponseBody(Object responseBody);

}
