package com.account.JWT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		log.error("Responding with unauthorized header. Message - {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}

}
