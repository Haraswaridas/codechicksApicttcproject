 package com.exam.userServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.exam.userEntity.UserRegistrationEntity;
import com.exam.userEntity.UserRegistrationEntityDao;

@Service
public interface UserRegistrationService {

	UserRegistrationEntity createUser(UserRegistrationEntity user);

	Optional<UserRegistrationEntity> getUserById(Long id);

	List<UserRegistrationEntity> getAllUsers();

	Optional<UserRegistrationEntity> updateUser(Long id, UserRegistrationEntity updatedUserDetails);

	boolean deleteUser(Long id);
	 

}
