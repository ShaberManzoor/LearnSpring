package com.in28mins.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Pointcut - When?
	// execution(* PACKAGE.*.*(..))
	@Before("execution(* com.in28mins.learn_spring_aop.aopexample.*.*.*(..))")
	public void logMethodCallBeforeExec(JoinPoint joinPoint) {
		logger.info("Before Aspect - {} is called with Arguments {}", joinPoint, joinPoint.getArgs());
	}
	
	@After("execution(* com.in28mins.learn_spring_aop.aopexample.*.*.*(..))")
	public void logMethodCallAfterExec(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has called", joinPoint);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.in28mins.learn_spring_aop.aopexample.*.*.*(..))",
			throwing = "exception"
			)
	public void logMethodCallAfterThrowExec(JoinPoint joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thrown an exception - {}", joinPoint, exception);
	}
	
	@AfterReturning(
			pointcut = "execution(* com.in28mins.learn_spring_aop.aopexample.*.*.*(..))",
			returning = "resultVal"
			)
	public void logMethodCallAfterSuccessfullyExec(JoinPoint joinPoint, Object resultVal) {
		logger.info("AfterReturning Aspect - {} has returned - {}", joinPoint, resultVal);
	}
	
}
