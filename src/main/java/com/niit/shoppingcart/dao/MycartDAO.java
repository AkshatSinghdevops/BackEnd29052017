package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Mycart;

public interface MycartDAO {

/*	
	public List<Mycart>	list(String user_id);
	public List<Mycart>list();
	
    public 	boolean save(Mycart mycart);
    
public Mycart get(String id);
	
	
	
	public boolean delete(Mycart mycart);
	
	public boolean update(Mycart mycart);
	
	public Long getTotalAmount(String userId);
	
	public Mycart getMycartByID(String product_name);
	public boolean delete(String product_name);
    
    public boolean delete(long id);
    
	public Mycart getSupplier(String id);

	public boolean update(Mycart cart);
	
	public Object getTotalAmount(String loggedInUserid);
	public Object getproduct(int productid, int userid);
	public Mycart getMycartByID(long id);
	
*/

public List<Mycart>	list(String userId);
	
	public Mycart get(String id);
	
	public boolean save(Mycart myCart);
	
	public boolean delete(Mycart myCart);
	
	public boolean update(Mycart myCart);
	
	
	public int getTotalAmount(Integer integer);
	
	
	public boolean delete(int id);
	
	public Mycart getMycartByID(int id);

	public Object getTotalAmount(String id);

	}
