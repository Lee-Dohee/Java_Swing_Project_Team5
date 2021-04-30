package com.javalec.restaurant_user;

public class BeanRestaurant_User {
	
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
	int num;


	// Construct
	public BeanRestaurant_User() {
		// TODO Auto-generated constructor stub
	}
	public BeanRestaurant_User(String name) {
		super();
		this.name = name;
	}	
	public BeanRestaurant_User(String name, String price, String content, String allergy) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
		this.allergy = allergy;
	}	
	public BeanRestaurant_User(String date, String u_id, String star, String menu, String content) {
		super();
		this.content = content;
		this.date = date;
		this.u_id = u_id;
		this.star = star;
		this.menu = menu;
	}
	// 레스토랑 info 보여주기
	public BeanRestaurant_User(String name, String location, String telno) {
		super();
		this.name = name;
		this.location = location;
		this.telno = telno;
	}
	// 레스토랑 table 불러오기
	public BeanRestaurant_User(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	// 레스토랑 클릭하기
	public BeanRestaurant_User(int num, String name, String star, String location) {
		super();
		this.num = num;
		this.name = name;
		this.star = star;
		this.location = location;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
