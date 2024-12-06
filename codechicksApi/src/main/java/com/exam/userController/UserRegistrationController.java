package com.exam.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.userEntity.UserRegistrationEntity;
import com.exam.userEntity.UserRegistrationEntityDao;
import com.exam.userServices.UserRegistrationService;

@RestController
public class UserRegistrationController {
	 @Autowired
	    private UserRegistrationService userRegistrationService;
	 @GetMapping
	    public ResponseEntity<Iterable<UserRegistrationEntity>> getAllUsers() {
	        return ResponseEntity.ok(userRegistrationService.getAllUsers());
	    }
	 

	

}
