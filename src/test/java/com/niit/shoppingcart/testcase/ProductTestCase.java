package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	@Test
	public void createProductTestCase() {
		
		
		
	}
}
