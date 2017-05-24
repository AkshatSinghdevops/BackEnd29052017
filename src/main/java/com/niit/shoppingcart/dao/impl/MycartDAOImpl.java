package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.domain.Mycart;



@Transactional
@Repository("mycartDAO")
public class MycartDAOImpl implements MycartDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Mycart> list() {
		
		return	sessionFactory.getCurrentSession().createQuery("from Mycart").list();
	}

	public boolean save(Mycart mycart) {
		
		
		try
		{
		sessionFactory.getCurrentSession().save(mycart);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	public boolean delete(Mycart mycart) {
		// TODO Auto-generated method stub
		return false;
	}

}
