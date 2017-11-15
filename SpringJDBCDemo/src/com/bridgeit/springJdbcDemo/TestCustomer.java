package com.bridgeit.springJdbcDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomer {

	public static void main(String[] args) {
	System.out.println("1111");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-customer.xml");
		System.out.println("2222");
		CustomerDaoImpl connect = (CustomerDaoImpl) ctx.getBean("customerDao");
		System.out.println("3333");
		Customer customer = null;
		
	    connect.addCustomer(customer);
	   // customer = new Customer(102, "modugu", 28);
	   // connect.addCustomer(customer);
	    
	    customer = connect.getCustomerByID(101);
	    if(customer != null){
	    System.out.println(customer);
	    }
	    else
	    {
	    	System.out.println("the data is not found");
	    }
	}

}
