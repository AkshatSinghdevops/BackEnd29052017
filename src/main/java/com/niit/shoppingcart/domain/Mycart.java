package com.niit.shoppingcart.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Mycart")
@Component
public class Mycart implements Serializable {
	
	private static  final int serialVersionUID = 1;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_2")
	@SequenceGenerator(name="seq_2", sequenceName="seq_2", allocationSize=1)
	@Column(name="id")
	private int id;
	
	
	private String product_name;
	
	private String user_id;
	
	private int price;
	
	private char status;
	
	private int quantity;
	
	private Date date_added;

	/*@Override
	public String toString() {
		return "MyCart [id=" + id + ", user_id=" + user_id + ", price=" + price + ", product_name=" + product_name
				+ ", status=" + status + ", quantity=" + quantity + ", date_added=" + date_added + "]";
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public static int getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
