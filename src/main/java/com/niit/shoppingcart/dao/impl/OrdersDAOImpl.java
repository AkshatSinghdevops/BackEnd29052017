package com.niit.shoppingcart.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.domain.Orders;


@Transactional
@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	//CategoryDAOImpl c = new CategoryDAOImpl
	
	
	public OrdersDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	

	public List<Orders> list() {
		//select * from category  -SQL Query - mention the table name
		//from Category  -> HQL -mention Domain class name not table name
		
		//convert the hibernate query into db specific language
	return	sessionFactory.getCurrentSession().createQuery("from Orders").list();
		
	}

	public boolean save(Orders orders) {
		try
		{
		sessionFactory.getCurrentSession().save(orders);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
	}

	public boolean delete(Orders orders) {
		// TODO Auto-generated method stub
		return false;
	}

}
