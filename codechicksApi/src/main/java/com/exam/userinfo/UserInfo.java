package com.exam.userinfo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable


public class UserInfo {
	@Column(name = "CRE_USER", length = 50)
    private String creUser;  // Created by

    @Column(name = "CRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creDate;    // Created at

    @Column(name = "MOD_USER", length = 50)
    private String modUser;  // Modified by

    @Column(name = "MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;   

}
