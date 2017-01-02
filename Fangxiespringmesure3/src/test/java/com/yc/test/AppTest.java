package com.yc.test;
import org.springframework.context.ApplicationContext;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Person;
import com.yc.bean.YcClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	public AppTest(String testName){
		super(testName);
	}
	public static Test suite(){
		return new TestSuite(AppTest.class);
	}
	public void testApp() throws Exception{
		YcClassPathXmlApplicationContext context = new YcClassPathXmlApplicationContext("applicationContext.xml");
		Person p= (Person) context.getBean("p");
		Person p1=(Person) context.getBean("p");
		Person p2= (Person) context.getBean("p2");
		System.out.println(p);
		System.out.println(p1);
		System.out.println(p2);
	}

}
