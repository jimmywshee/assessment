package com.mbank.assess.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mbank.assess.bo.BoredActivityBO;
import com.mbank.assess.constant.LogFormats;
import com.mbank.assess.service.IBoredApiRestService;

@Service
public class BoredApiRestService extends ApiClientRestBaseService implements IBoredApiRestService {

	private final Logger LOG = LoggerFactory.getLogger(BoredApiRestService.class);

	@Value("${bored.activity.api.url}")
	private String boredActivityApiUrl;

	@Override
	public BoredActivityBO performBoredActivityInquiry() {
		final String methodName = "performBoredActivityInquiry";
		LOG.debug(LogFormats.ENTRY, methodName);

		final ResponseEntity<BoredActivityBO> respEntity = getApi(boredActivityApiUrl, BoredActivityBO.class);

		LOG.debug(LogFormats.EXIT, methodName);
		return respEntity.getBody();
	}
}
