package com.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Account")
public class Account {

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String dob;
	private String ssn;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="mailing_address")
	private String mailingAddress;
	
	@Column(name="account_type")
	private String accountType;
	
	@Id
	@Column(name="account_No")
	private String accountNo;
	
	@Column(name="min_balance")
	private double minBalance;
	
	

	
}
