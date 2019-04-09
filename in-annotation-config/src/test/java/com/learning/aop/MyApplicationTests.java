package com.learning.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.aop.business.Business;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTests {
	//@Autowired Business business;
	
	
	//@Test public void contextLoads() throws Exception{ System.out.println(business.getClass()); }

}
