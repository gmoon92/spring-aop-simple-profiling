package com.learning.aop.business;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aop.aspect.AspectJAutoProxyConfig;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BusinessTest {
	private AnnotationConfigApplicationContext ctx;
	
	private Business business;
	
	@Before
	public void init(){
		/**
		 * ctx.register(AspectJAutoProxyConfig.class);
		 * ctx.refresh();
		 */
		ctx = new AnnotationConfigApplicationContext(AspectJAutoProxyConfig.class);
		business = ctx.getBean(Business.class);
		//JDK Dynamic Proxy 생성 여부
		System.out.println(business.getClass());
	}
	
	@Test
	public void monitoringTest() throws Exception {
		for(int i=0; i<3; i++){
			business.doAction();
		}
		
		business.doRuntimeException();
	}
}
