package com.account.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="Account")
public class Account implements UserDetails {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String dob;
	private String ssn;
	
	@Column(name="email_id")
	private String emailId;
	
	private String password;
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	
}
