package com.mbank.assess.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbank.assess.entity.User;

public interface UserRepository
        extends PagingAndSortingRepository<User, String>, UserRepositoryCustom {


}