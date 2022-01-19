package com.mbank.assess.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbank.assess.bo.BoredActivityBO;
import com.mbank.assess.bo.UserBO;
import com.mbank.assess.constant.LogFormats;
import com.mbank.assess.service.IApiLoggingService;
import com.mbank.assess.service.IBoredApiRestService;
import com.mbank.assess.service.IUserService;

@RestController
public class AssessmentController {

	private static final Logger LOG = LoggerFactory.getLogger(AssessmentController.class);

	@Autowired
	private IApiLoggingService loggingService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IBoredApiRestService boredApiRestService;

	/**
	 * Retrieve Test Users with HTTP GET method
	 * 
	 * @param page - start with 0..1..2
	 * @return
	 * @throws URISyntaxException
	 */
	@GetMapping(ApiRequestMapping.Public.LIST_ASSESSMENT_USER_URI)
	public ResponseEntity<List<UserBO>> getTestUsers(@RequestParam Integer page) throws URISyntaxException {
		final String methodName = "getTestUsers";
		LOG.info(LogFormats.ENTRY, methodName);

		List<UserBO> userBOs = userService.retrieveUsers(page);

		if (!userBOs.isEmpty()) {
			loggingService.logResponseBody(userBOs);
		}
		LOG.info(LogFormats.EXIT, methodName);
		return ResponseEntity.ok(userBOs);
	}

	/**
	 * Perform action of user insertion based on input from user
	 * 
	 * @param userBO
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping(ApiRequestMapping.Public.INSERT_ASSESSMENT_USER_URI)
	public ResponseEntity<UserBO> insertTestUsers(@Valid @RequestBody UserBO userBO) throws URISyntaxException {
		final String methodName = "insertTestUsers";
		LOG.info(LogFormats.ENTRY, methodName);
		loggingService.logRequestBody(userBO);

		UserBO result = null;
		if (Strings.isEmpty(userBO.getId())) {
			throw new ValidationException("id is mandatory field");
		}
		result = userService.insertUser(userBO);

		if (result != null) {
			loggingService.logResponseBody(result);
		}
		LOG.info(LogFormats.EXIT, methodName);
		return ResponseEntity.ok(result);
	}

	/**
	 * Perform action of update based on input from user
	 * 
	 * @param id
	 * @param userBO
	 * @return
	 * @throws URISyntaxException
	 */
	@PatchMapping(ApiRequestMapping.Public.UPDATE_ASSESSMENT_USER_URI)
	public ResponseEntity<UserBO> updateTestUsers(@Valid @PathVariable(value = "id") @NonNull String id,
			@Valid @RequestBody UserBO userBO) throws URISyntaxException {
		final String methodName = "updateTestUsers";
		LOG.info(LogFormats.ENTRY, methodName);

		loggingService.logRequestBody(userBO);

		UserBO result = null;
		userBO.setId(id);
		result = userService.updateUser(userBO);

		if (result != null) {
			loggingService.logResponseBody(result);
		}
		LOG.info(LogFormats.EXIT, methodName);
		return ResponseEntity.ok(result);
	}

	/**
	 * API to trigger Rest API call to www.boredapi.com and return response given
	 * 
	 * @return
	 * @throws URISyntaxException
	 */
	@GetMapping(ApiRequestMapping.Public.LIST_ASSESSMENT_EXT_PARTY_URI)
	public ResponseEntity<BoredActivityBO> getExternalPartyActivity() throws URISyntaxException {
		final String methodName = "getExternalPartyActivity";
		LOG.info(LogFormats.ENTRY, methodName);

		BoredActivityBO boredActivityBO = boredApiRestService.performBoredActivityInquiry();

		if (boredActivityBO != null) {
			loggingService.logResponseBody(boredActivityBO);
		}
		LOG.info(LogFormats.EXIT, methodName);
		return ResponseEntity.ok(boredActivityBO);
	}

}
