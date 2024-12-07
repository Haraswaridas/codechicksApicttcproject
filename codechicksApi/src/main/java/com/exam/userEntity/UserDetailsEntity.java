package com.exam.userEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserDetailsEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long addressId; // ADDRESS_ID

	    private Long userId;    // USER_ID
	    private String address1; // ADDRESS1
	    private String address2; // ADDRESS2
	    private String state;   // STATE
	    private String dist;    // DIST
	    private String pin;     // PIN
	    private String aadhar;  // AADHAR
	    private String pan;  

}
