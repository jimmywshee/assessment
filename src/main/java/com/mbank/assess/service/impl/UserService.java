package com.mbank.assess.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbank.assess.bo.UserBO;
import com.mbank.assess.constant.Constants;
import com.mbank.assess.entity.User;
import com.mbank.assess.mapper.UserMapper;
import com.mbank.assess.repository.UserRepository;
import com.mbank.assess.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	private static final Integer SIZE_PER_PAGE = 10;

	@Override
	public List<UserBO> retrieveUsers(Integer page) {
		Pageable pageable = PageRequest.of(page, SIZE_PER_PAGE);
		Page<User> users = userRepository.findAll(pageable);
		List<UserBO> userBOs = users.stream().map(user -> UserMapper.entityToBO(user)).collect(Collectors.toList());
		return userBOs;
	}

	@Override
	public UserBO insertUser(UserBO userBO) {
		User user = UserMapper.boToEntity(userBO);
		user.setCreatedBy(Constants.SYSTEM);
		userRepository.persistUser(user);

		return this.findById(user.getId());
	}

	@Override
	public UserBO updateUser(UserBO userBO) {
		User user = UserMapper.boToEntity(userBO);
		user.setModifiedBy(Constants.SYSTEM);
		userRepository.updateNameAndEmail(user);

		return this.findById(user.getId());
	}

	private UserBO findById(String id) {
		Optional<User> result = userRepository.findById(id);
		UserBO resultBO = UserMapper.entityToBO(result.get());

		return resultBO;
	}

}
