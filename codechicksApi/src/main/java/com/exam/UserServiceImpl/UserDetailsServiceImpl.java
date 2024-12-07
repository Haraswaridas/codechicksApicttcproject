package com.exam.UserServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.userEntity.UserDetailsEntity;
import com.exam.userEntity.UserDetailsEntityDao;
import com.exam.userServices.UserDetailsService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserDetailsEntityDao userDetailsEntityDao;
	@Override
	public UserDetailsEntity saveUserDetails(UserDetailsEntity userDetails) {
		return userDetailsEntityDao.save(userDetails);
	}
	@Override
	public Optional<UserDetailsEntity> getUserDetailsById(Long addressId) {
		return userDetailsEntityDao.findById(addressId);
	}
	@Override
	public UserDetailsEntity updateUserDetails(Long addressId, UserDetailsEntity userDetails) {
		return  userDetailsEntityDao.findById(addressId).map(existingDetails -> {
            existingDetails.setUserId(userDetails.getUserId());
            existingDetails.setAddress1(userDetails.getAddress1());
            existingDetails.setAddress2(userDetails.getAddress2());
            existingDetails.setState(userDetails.getState());
            existingDetails.setDist(userDetails.getDist());
            existingDetails.setPin(userDetails.getPin());
            existingDetails.setAadhar(userDetails.getAadhar());
            existingDetails.setPan(userDetails.getPan());
            return userDetailsEntityDao.save(existingDetails);
        }).orElseThrow(() -> new RuntimeException("UserDetails not found with ID: " + addressId));
	}
	@Override
	public void deleteUserDetailsById(Long addressId) {
		 if (userDetailsEntityDao.existsById(addressId)) {
	            userDetailsEntityDao.deleteById(addressId);
	        } else {
	            throw new RuntimeException("UserDetails not found with ID: " + addressId);
	        }		
	}

}
