package com.javalec.restaurant_owner;

public class BeanRestaurant_Owner {
	
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
	int code;
	String r_code;
	
	
	// Construct
	// 식당 table 불러오기
	public BeanRestaurant_Owner(int num, String name, String star, String location) {
		super();
		this.num = num;
		this.name = name;
		this.star = star;
		this.location = location;
	}
	// restaurant 기본 정보 불러오기
	public BeanRestaurant_Owner(String name, String location, String telno) {
		super();
		this.name = name;
		this.location = location;
		this.telno = telno;
	}
	// 메뉴 테이블 불러오기
	public BeanRestaurant_Owner(int code, String name, String price, String content, String allergy) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.content = content;
		this.allergy = allergy;
	}
	// 리뷰 테이블 불러오기
	public BeanRestaurant_Owner(String date, String u_id, String star, String menu, String content) {
		super();
		this.date = date;
		this.u_id = u_id;
		this.star = star;
		this.menu = menu;
		this.content = content;
	}
	// 리뷰 r_code 업데이트
	// 식당 등록 시 꼭 리뷰 하나씩 업데이트
	public BeanRestaurant_Owner(String r_code) {
		super();
		this.r_code = r_code;
	}
	
	
	// Mehtod
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getR_code() {
		return r_code;
	}
	public void setR_code(String r_code) {
		this.r_code = r_code;
	}
	
}
