package com.exam.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.userEntity.UserRegistrationEntity;
import com.exam.userEntity.UserRegistrationEntityDao;
import com.exam.userServices.UserRegistrationService;

@Service
public class UserRegistrationServiceimp implements UserRegistrationService {
	@Autowired
	UserRegistrationEntityDao userRegistrationEntityDao;

	@Override
	public Iterable<UserRegistrationEntity> getAllUsers() {
		return userRegistrationEntityDao.findAll();

	}

}
