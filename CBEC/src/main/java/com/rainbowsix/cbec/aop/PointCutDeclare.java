package com.rainbowsix.cbec.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PointCutDeclare {
	@Pointcut("execution(* com.rainbowsix.cbec.controller.*.*(..))")
	public void allController() {}
}
