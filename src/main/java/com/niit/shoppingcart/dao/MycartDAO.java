package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Mycart;

public interface MycartDAO {

	
	
	public List<Mycart>list();
	
    public 	boolean save(Mycart mycart);
    
    public boolean delete(Mycart mycart);
}
