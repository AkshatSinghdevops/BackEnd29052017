package com.niit.shoppingcart.dao.impl;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.MycartDAO;
import com.niit.shoppingcart.domain.Mycart;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository("mycartDAO")
public class MycartDAOImpl implements MycartDAO {

	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public MycartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {

		return (Session) sessionFactory.getCurrentSession();

	}
	
	public List<Mycart> list() {
		
		return	sessionFactory.getCurrentSession().createQuery("from Mycart").list();
	}

	@Transactional
	public List<Mycart> list(String userId) {
		//log.debug("Starting of the method list");
		String hql = "from Mycart where user_id=" + "'" + userId + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//log.debug("Ending of the method list");
		return query.list();

	}

	@Transactional
	public boolean save(Mycart myCart) {
		//log.debug("Starting of the method save");

		myCart.setId(getMaxId());
		
		try {
			sessionFactory.getCurrentSession().save(myCart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Mycart get(String id) {
		
		return (Mycart) sessionFactory.getCurrentSession().createQuery("from Mycart where id='"+id+"'").uniqueResult();
	}

	@Transactional
	public boolean delete(Mycart myCart) {
		
		myCart.setStatus('X');
		
		return update(myCart);
	}

	@Transactional
	public boolean update(Mycart myCart) {
		
		
		try {
			sessionFactory.getCurrentSession().update(myCart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Long getTotalAmount(String userId) {
		
	//	log.debug("Starting of the method getTotalAmount");
		
		String hql = "select sum(price*quantity) from Mycart where user_id=" + "'" + userId + "' " + "  and status = " + "'N'";
		//log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//log.debug("Ending of the method getTotalAmount");
		return (Long) query.uniqueResult();

	}

	@Transactional
	private Long getMaxId() {
		//log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from Mycart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			//log.debug("hql" + hql);
			maxID = (Long) query.uniqueResult();
		} catch (HibernateException e) {
			//log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100L;
			e.printStackTrace();
		}
		//log.debug("Max id :" + maxID);
		return maxID + 1;

	}

	public boolean delete(Long id) {
		try {
			sessionFactory.getCurrentSession().delete(getMycartByID(id));
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Mycart getMycartByID(Long id) {
		return (Mycart) sessionFactory.getCurrentSession().get(Mycart.class , id);
	}
	
	
	
	
	/*@Autowired
	private SessionFactory sessionFactory;
	
	
	

	public MycartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {

		return (Session) sessionFactory.getCurrentSession();

	}
	
	@Transactional
	public List<Mycart> list(String userId) {
	
		String hql = "from Mycart where user_id=" + "'" + userId + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();

	}
	
	public List<Mycart> list(String user_id) {
		
		return	sessionFactory.getCurrentSession().createQuery("from Mycart where user_id=" + "'" + user_id + "'  and status = " + "'N'").list();
	}

	public boolean save(Mycart mycart) {
		
		mycart.setId(getMaxId());
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

public Mycart get(String id) {
		
		return (Mycart) sessionFactory.getCurrentSession().createQuery("from Mycart where id='"+id+"'").uniqueResult();
	}

	@Transactional
	public boolean delete(Mycart mycart) {
		
	
		try {
			mycart.setStatus('X');
			sessionFactory.getCurrentSession().delete(mycart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Mycart mycart) {
		
		
		try {
			sessionFactory.getCurrentSession().update(mycart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Long getTotalAmount(String userId) {
		
		
		
		String hql = "select sum(price*quantity) from Mycart where user_id=" + "'" + userId + "' " + "  and status = " + "'N'";
		

		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		
		return (Long) query.uniqueResult();

	}

	@Transactional
	private Long getMaxId() {
		

		Long maxID = 100L;
		try {
			String hql = "select max(id) from Mycart";
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
			
			maxID = (Long)  query.uniqueResult();
		} catch (HibernateException e) {
			
			maxID = 100L;
			e.printStackTrace();
		}
		
		return maxID + 1;

	}

	
	
	
	
	public boolean delete(long id) {
		try {
			sessionFactory.getCurrentSession().delete(getMycartByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Mycart getMycartByID(String product_name) {
		//select * from Category where id ='mobile'
	//  return	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
	  
		return (Mycart) sessionFactory.getCurrentSession().get(Mycart.class, product_name);		
	}

	public List<Mycart> list() {
		
		return	sessionFactory.getCurrentSession().createQuery("from Mycart").list();

	}

	
	@Transactional
	public boolean update(Mycart mycart) {
		
		try {
			sessionFactory.getCurrentSession().update(mycart);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



	public Object getproduct(int productid, int userid) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean delete(long id) {
		try {
			sessionFactory.getCurrentSession().delete(getMycartByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	}


	
}

	public boolean delete(Mycart mycart) {
		// TODO Auto-generated method stub
		return false;
	}

	public Mycart getMycartByID(long id) {
		return (Mycart)	sessionFactory.getCurrentSession().get(Mycart.class, id);
	}

	public Mycart getSupplier(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	*/
	
	
	
}
