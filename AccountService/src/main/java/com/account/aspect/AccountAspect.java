package com.account.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Configuration
public class AccountAspect {

	@AfterReturning(pointcut="execution(* com.account.controller.AccountRegistration.createAccount(..))", returning="result")
	public void logAfterSuccessfulAccountCreation(JoinPoint joinpoint, Object result) {
		
		log.info("logAfterSuccessfulAccountCreation is running");
		log.info( joinpoint.getSignature().getName());
		log.info("returned value"+result);
	}
	
	@AfterReturning(pointcut="execution(* com.account.controller.AccountRegistration.findByAccountId(..))", returning="result")
	public void logAfterFindAccount(JoinPoint joinpoint, Object result) {
		log.info("logAfterFindAccount is running");
		log.info("Finding account by account no");
		log.info(joinpoint.getSignature().getName());
		log.info("returned value"+result);
	}
	
	
}
