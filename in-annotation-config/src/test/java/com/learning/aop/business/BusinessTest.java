package com.learning.aop.business;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aop.MyApplication;
import com.learning.aop.aspect.AspectJAutoProxyConfig;

public class BusinessTest {
	private AnnotationConfigApplicationContext ctx;
	private Business business;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext();
	}
	
	@Test @Ignore
	public void isJDKDynamicProxy() throws Exception{
		ctx.register(AspectJAutoProxyConfig.class);
		ctx.refresh();
		business = ctx.getBean(Business.class);
		
		//JDK Dynamic Proxy 생성 여부
		System.out.println(business.getClass());
		Assert.assertTrue(java.lang.reflect.Proxy.isProxyClass(business.getClass()));
	}
	
	@Test
	public void isJDKDynamicProxyWithSpringRunner() throws Exception{
		ctx = (AnnotationConfigApplicationContext) SpringApplication.run(MyApplication.class, new String[]{""});
		business = ctx.getBean(Business.class);
		
		//JDK Dynamic Proxy 생성 여부
		System.out.println(business.getClass());
		Assert.assertTrue(java.lang.reflect.Proxy.isProxyClass(business.getClass()));
	}
	
	@Test @Ignore
	public void isCGLIB() throws Exception{
		ctx = (AnnotationConfigApplicationContext) SpringApplication.run(MyApplication.class, new String[]{""});
		business = ctx.getBean(Business.class);
		
		//CGLIB 생성 여부
		System.out.println(business.getClass());
		Assert.assertTrue(org.springframework.cglib.proxy.Enhancer.isEnhanced(business.getClass()));
	}
	
	@After
	public void destory() throws Exception{
		for(int i=0; i<3; i++){
			business.doAction();
		}
		business.doRuntimeException();
		
		ctx.close();
	}
}
