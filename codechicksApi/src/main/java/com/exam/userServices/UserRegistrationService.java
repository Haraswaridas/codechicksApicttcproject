 package com.exam.userServices;

import org.springframework.stereotype.Service;

import com.exam.userEntity.UserRegistrationEntity;
import com.exam.userEntity.UserRegistrationEntityDao;

@Service
public interface UserRegistrationService {
	 Iterable<UserRegistrationEntity> getAllUsers();

}
