package com.exam.userServices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.exam.userEntity.UserDetailsEntity;
@Service
public interface UserDetailsService {

	UserDetailsEntity saveUserDetails(UserDetailsEntity userDetails);

	Optional<UserDetailsEntity> getUserDetailsById(Long addressId);

	UserDetailsEntity updateUserDetails(Long addressId, UserDetailsEntity userDetails);

	void deleteUserDetailsById(Long addressId);

}
