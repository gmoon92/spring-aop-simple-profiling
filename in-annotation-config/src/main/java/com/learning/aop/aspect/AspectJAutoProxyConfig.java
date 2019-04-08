package com.learning.aop.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.learning.aop.business.Business;
import com.learning.aop.business.BusinessImple;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
@Import(BusinessImple.class)
public class AspectJAutoProxyConfig {

	@Bean
	public SimplePerformanceMonitor aspect() {
		return new SimplePerformanceMonitor();
	}

}
