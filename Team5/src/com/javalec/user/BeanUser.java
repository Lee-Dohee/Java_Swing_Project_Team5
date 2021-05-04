package com.javalec.user;

public class BeanUser {

	// Field
	String code;
	String name;
	String email;
	String telno;
	int num;
	
	
	// Construct
	// 알러지 코드 리스트
	public BeanUser(String code) {
		super();
		this.code = code;
	}
	// mypage 내정보 불러오기
	public BeanUser(String name, String email, String telno) {
		super();
		this.name = name;
		this.email = email;
		this.telno = telno;
	}
	// mypage 알러지 항목 불러오기
	public BeanUser(int num) {
		super();
		this.num = num;
	}
	
	//Method
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
