package com.learning.business;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BusinessTest {

	private ClassPathXmlApplicationContext ctx;
	private Business business;

	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("classpath:/spring-aop-test.xml");
		business = ctx.getBean(Business.class);
	}
	
	@Test
	public void isJDKDynamicProxy() throws Exception {
		//JDK Dynamic Proxy 생성 여부
		System.out.println(business.getClass());
		Assert.assertTrue(java.lang.reflect.Proxy.isProxyClass(business.getClass()));
		
		for(int i=0; i<3; i++){
			business.doAction();
		}
		
		business.doRuntimeException();
	}

	@After
	public void destory(){
		ctx.close();
	}
}
