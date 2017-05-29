package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Orders;

public interface OrdersDAO {
	
	
	
    public	List<Orders> list();
    
    
    public boolean save(Orders orders);
    
    public boolean delete(Orders orders);
    
   

}
