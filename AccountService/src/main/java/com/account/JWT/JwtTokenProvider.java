package com.account.JWT;

import java.nio.file.attribute.UserPrincipal;
import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

public class JwtTokenProvider {

	
	public String generateToken(Authentication authentication) {
		
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiryDate = now.plusHours(SecurityConstants.JWTEXPIRATIONINMS);
		
		return Jwts.builder().setSubject(Long.)
		
		
	}
}
