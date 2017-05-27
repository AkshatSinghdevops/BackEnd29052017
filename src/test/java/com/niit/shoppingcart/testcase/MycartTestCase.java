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
	public void deleteByCartTestCase() {

		mycart.setId(48L);

		boolean flag = mycartDAO.delete(mycart);
		assertEquals("deleteByCartTestCase", true, flag);

	}

}
