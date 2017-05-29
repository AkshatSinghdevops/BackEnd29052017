package com.niit.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component
public class Orders {
	
	private static  final int serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_1")
	@SequenceGenerator(name="seq_1", sequenceName="seq_1", allocationSize=1)
	private int id;
	
	private String full_name;
	
	private String address;
	
	private String country;
	
	private String city;
	
	private String state;
	
	private String email;
	
	private int zip_code;
	
	private int phone_number;
	
	private String card_type;
	
	private int card_number;
	
	private int card_cvv;
	
	private int ex_month;
	
	private int ex_year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public int getCard_number() {
		return card_number;
	}

	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}

	public int getCard_cvv() {
		return card_cvv;
	}

	public void setCard_cvv(int card_cvv) {
		this.card_cvv = card_cvv;
	}

	public int getEx_month() {
		return ex_month;
	}

	public void setEx_month(int ex_month) {
		this.ex_month = ex_month;
	}

	public int getEx_year() {
		return ex_year;
	}

	public void setEx_year(int ex_year) {
		this.ex_year = ex_year;
	}

	public static int getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	

}
