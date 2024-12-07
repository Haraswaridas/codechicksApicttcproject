package com.exam.userController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.userEntity.UserRegistrationEntity;
import com.exam.userEntity.UserRegistrationEntityDao;
import com.exam.userServices.UserRegistrationService;

@RestController
public class UserRegistrationController {
	 @Autowired
	    private UserRegistrationService userRegistrationService;
	 @PostMapping("/save")
	    public ResponseEntity<UserRegistrationEntity> createUser(@RequestBody UserRegistrationEntity user) {
	        UserRegistrationEntity createdUser = userRegistrationService.createUser(user);
	        return ResponseEntity.ok(createdUser);
	    }
	 @GetMapping("show/{id}")
	    public ResponseEntity<Optional<UserRegistrationEntity>> getUserById(@PathVariable Long id) {
	        Optional<UserRegistrationEntity> user = userRegistrationService.getUserById(id);
	        if (user.isPresent()) {
	            return ResponseEntity.ok(user);
	        }
	        return ResponseEntity.notFound().build();
	    }

	 

	 @GetMapping("/show")
	    public ResponseEntity<List<UserRegistrationEntity>> getAllUsers() {
	        List<UserRegistrationEntity> users = userRegistrationService.getAllUsers();
	        return ResponseEntity.ok(users);
	    }
	 @PutMapping("update/{id}")
	    public ResponseEntity<UserRegistrationEntity> updateUser(
	            @PathVariable Long id, 
	            @RequestBody UserRegistrationEntity updatedUserDetails) {
	        Optional<UserRegistrationEntity> updatedUser = userRegistrationService.updateUser(id, updatedUserDetails);
	        if (updatedUser.isPresent()) {
	            return ResponseEntity.ok(updatedUser.get());
	        }
	        return ResponseEntity.notFound().build();
	    }
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        boolean isDeleted = userRegistrationService.deleteUser(id);
	        if (isDeleted) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
	

}
