package com.javalec.restaurant;

public class BeanRestrant {
	
	// Field
	String name;
	String price;
	String content;
	String allergy;
	String date;
	String u_id;
	String star;
	String menu;
	String location;
	String telno;


	// Construct
	public BeanRestrant() {
		// TODO Auto-generated constructor stub
	}
	public BeanRestrant(String name) {
		super();
		this.name = name;
	}	
	public BeanRestrant(String name, String price, String content, String allergy) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
		this.allergy = allergy;
	}	
	public BeanRestrant(String date, String u_id, String star, String menu, String content) {
		super();
		this.content = content;
		this.date = date;
		this.u_id = u_id;
		this.star = star;
		this.menu = menu;
	}
	// 레스토랑 info 보여주기
	public BeanRestrant(String name, String location, String telno) {
		super();
		this.name = name;
		this.location = location;
		this.telno = telno;
	}
	
	
	
	
	// Method
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}

}
