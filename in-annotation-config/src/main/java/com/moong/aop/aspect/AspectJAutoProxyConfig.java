package com.moong.aop.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.moong.aop.business.BusinessImple;

@Configuration
@EnableAspectJAutoProxy
@Import(BusinessImple.class)
public class AspectJAutoProxyConfig {
	
	@Bean
	public SimplePerformanceMonitor aspect() {
		return new SimplePerformanceMonitor();
	}
	
}
