package com.javalec.owner;

public class BeanRestaurant {
	
	String name;
	String email;
	String telno;
	
	public BeanRestaurant(String name, String email, String telno) {
		super();
		this.name = name;
		this.email = email;
		this.telno = telno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}
}
