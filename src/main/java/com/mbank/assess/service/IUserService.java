package com.mbank.assess.service;

import java.util.List;

import com.mbank.assess.bo.UserBO;

public interface IUserService {

	List<UserBO> retrieveUsers(Integer page);

	UserBO insertUser(UserBO userBO);

	UserBO updateUser(UserBO userBO);
	
}
