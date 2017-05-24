package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.domain.Mycart;

import junit.framework.Assert;

public class MycartTestCase {

	@Autowired
	private static Mycart mycart;
	
	@Autowired
	private static MycartDAO mycartDAO;
	
	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		mycart = (Mycart) context.getBean("mycart");
		
		mycartDAO = (MycartDAO) context.getBean("mycartDAO");
	}
	
	
	@Test
	public void createMycartTestCase() {
		mycart.setId(1);
		mycart.setProduct_name("mobile");
		mycart.setPrice("1000");
		mycart.setQuantity("1");
		mycart.setUser_id("akshat");
		
		boolean f = mycartDAO.save(mycart);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createMycartTestCase", true, f);
		
	}

}
