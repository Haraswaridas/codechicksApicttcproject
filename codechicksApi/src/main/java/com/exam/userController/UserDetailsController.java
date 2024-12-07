package com.exam.userController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.userEntity.UserDetailsEntity;
import com.exam.userServices.UserDetailsService;

@RestController
@RequestMapping("/userdetails")
public class UserDetailsController {
	@Autowired
    private UserDetailsService userDetailsService;
	 @PostMapping("/save")
	    public ResponseEntity<UserDetailsEntity> createUserDetails(@RequestBody UserDetailsEntity userDetails) {
	        UserDetailsEntity createdDetails = userDetailsService.saveUserDetails(userDetails);
	        return ResponseEntity.ok(createdDetails);
	    }
	  @GetMapping("/show/{id}")
	    public ResponseEntity<UserDetailsEntity> getUserDetailsById(@PathVariable Long id) {
	        Optional<UserDetailsEntity> userDetails = userDetailsService.getUserDetailsById(id);
	        return userDetails.map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	  @PutMapping("/update/{id}")
	    public ResponseEntity<UserDetailsEntity> updateUserDetails(@PathVariable Long id, @RequestBody UserDetailsEntity userDetails) {
	        try {
	            UserDetailsEntity updatedDetails = userDetailsService.updateUserDetails(id, userDetails);
	            return ResponseEntity.ok(updatedDetails);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteUserDetails(@PathVariable Long id) {
	        try {
	            userDetailsService.deleteUserDetailsById(id);
	            return ResponseEntity.noContent().build();
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
