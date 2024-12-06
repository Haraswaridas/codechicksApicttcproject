package com.exam.userEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistrationEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment for Primary Key
    @Column(name = "REG_ID")
    private Long regId;

    @Column(name = "USER_ID", unique = true, nullable = false)
    private String userId;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "MAIL", length = 100, nullable = false)
    private String mail;

    @Column(name = "MOBILE", length = 10, nullable = false)
    private String mobile;

    @Column(name = "ALTERNATE_MOBILE", length = 10)
    private String alternateMobile;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "GENDER", length = 1)
    private char gender;


}
