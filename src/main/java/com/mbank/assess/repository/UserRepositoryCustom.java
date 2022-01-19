package com.mbank.assess.repository;

import com.mbank.assess.entity.User;

public interface UserRepositoryCustom {

	void persistUser(User user);

	void updateNameAndEmail(User user);

}
