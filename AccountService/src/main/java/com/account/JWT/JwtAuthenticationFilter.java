package com.account.JWT;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jwt = getJwtFromRequest(request);
		
	}
	
	private String getJwtFromRequest(HttpServletRequest req) {
		String bearerToken = req.getHeader(SecurityConstants.REQUEST_HEADER);
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(SecurityConstants.BEARER_TOKEN)) {
			return bearerToken.substring(SecurityConstants.BEARER_TOKEN.length(), bearerToken.length());
		}
		return null;
	}

}
