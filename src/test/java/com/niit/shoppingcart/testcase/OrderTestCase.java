package com.niit.shoppingcart.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.domain.Orders;

import junit.framework.Assert;

public class OrderTestCase {
	
	@Autowired
	private static Orders orders;

	@Autowired
	private static OrdersDAO ordersDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		orders = (Orders) context.getBean("orders");

		ordersDAO = (OrdersDAO) context.getBean("ordersDAO");

	}
	
	
	
	@Test
	public void createUserTestCase() {
		orders.setAddress("hbfdhbs");

		boolean flag = ordersDAO.save(orders);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createUserTestCase", true, flag);

	}
	
	
	

}
