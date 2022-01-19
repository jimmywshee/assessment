package com.mbank.assess.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mbank.assess.constant.Constants;

public class ApiClientRestBaseService {

	private final Logger LOG = LoggerFactory.getLogger(ApiClientRestBaseService.class);

	@Autowired
	private RestTemplate restTemplate;

	private MultiValueMap<String, String> createHeaders() {
		MultiValueMap<String, String> requestHeader = new LinkedMultiValueMap<>();
		requestHeader.add(Constants.ApiConstants.CONTENT_TYPE, Constants.ApiConstants.CONTENT_TYPE_APPLICATION_JSON);
		return requestHeader;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> ResponseEntity<T> getApi(String url, Class<T> responseType, Object... uriVariables) {
		try {
			HttpEntity httpEntity = new HttpEntity(createHeaders());
			ResponseEntity<T> responseEntity = this.apiCall(url, HttpMethod.GET, httpEntity, responseType,
					uriVariables);
			validateHttpResponse(responseEntity.getStatusCode());
			return responseEntity;
		} catch (HttpClientErrorException e) {
			LOG.error("HttpClientErrorException", e);
			return null;
		}
	}

	private void validateHttpResponse(final HttpStatus httpStatus) {
		if (!HttpStatus.OK.equals(httpStatus)) {
			throw new HttpClientErrorException(httpStatus, "Invalid http response");
		}
	}

	private <T> ResponseEntity<T> apiCall(String url, HttpMethod method, HttpEntity<?> requestEntity,
			Class<T> responseType, Object... uriVariables) {
		return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
	}

}
