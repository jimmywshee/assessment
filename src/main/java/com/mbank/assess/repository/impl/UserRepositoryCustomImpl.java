package com.mbank.assess.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ValidationException;

import org.springframework.transaction.annotation.Transactional;

import com.mbank.assess.entity.User;
import com.mbank.assess.repository.UserRepositoryCustom;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void persistUser(User user) {
		entityManager.persist(user);
	}

	@Transactional
	public void updateNameAndEmail(User user) {
		User result = entityManager.find(User.class, user.getId());
		if (result == null) {
			throw new ValidationException("Invalid user id");
		}

		result.setName(user.getName());
		result.setEmail(user.getEmail());
		result.setModifiedBy(user.getModifiedBy());

	}

}
