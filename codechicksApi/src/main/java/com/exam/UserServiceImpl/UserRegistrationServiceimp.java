package com.exam.UserServiceImpl;

import java.util.List;
import java.util.Optional;

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
	public UserRegistrationEntity createUser(UserRegistrationEntity user) {
		return userRegistrationEntityDao.save(user);
	}

	@Override
	public Optional<UserRegistrationEntity> getUserById(Long id) {
		return userRegistrationEntityDao.findById(id);
	}

	@Override
	public List<UserRegistrationEntity> getAllUsers() {
        return (List<UserRegistrationEntity>) userRegistrationEntityDao.findAll();
	}

	@Override
	public Optional<UserRegistrationEntity> updateUser(Long id, UserRegistrationEntity updatedUserDetails) {
		return userRegistrationEntityDao.findById(id).map(existingUser -> {
            existingUser.setFirstName(updatedUserDetails.getFirstName());
            existingUser.setLastName(updatedUserDetails.getLastName());
            existingUser.setMail(updatedUserDetails.getMail());
            existingUser.setMobile(updatedUserDetails.getMobile());
            existingUser.setAlternateMobile(updatedUserDetails.getAlternateMobile());
            existingUser.setDob(updatedUserDetails.getDob());
            existingUser.setGender(updatedUserDetails.getGender());
            return userRegistrationEntityDao.save(existingUser);
        });
	}

	@Override
	public boolean deleteUser(Long id) {
		 if (userRegistrationEntityDao.existsById(id)) {
	            userRegistrationEntityDao.deleteById(id);
	            return true;
	        }
	        return false;
	}
	
	

}
