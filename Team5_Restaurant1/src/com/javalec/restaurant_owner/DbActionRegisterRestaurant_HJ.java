package com.javalec.restaurant_owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;

public class DbActionRegisterRestaurant_HJ {
	
	//field
//	public static final String url_mysql = "jdbc:mysql://localhost:3306/Test2?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
//  public static final String id_mysql = "root";
//  public static final String pw_mysql = "qwer1234";
	//-------------2021.04.30 이도희-------------
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;
	//-------------2021.04.30 이도희-------------
			
	//변수 저장
	String number; //사업자등록번호
	String name; //식당이름
	String location; //식당주소
	String telno; //전화번호
	String neighborhood; //동네
	String people; //몇 인분인지 선택하는 것의 변수
	String category; //음식 선택
	String id; //아이디
	
	
	//Construct
	public DbActionRegisterRestaurant_HJ() {
		// TODO Auto-generated constructor stub
	}
	//-------------2021.05.01 이도희-------------
	// 식당등록
	public DbActionRegisterRestaurant_HJ(String id, String neighborhood, String people, String category, String name, String location,
			String telno, String number) {
		super();
		this.id = id;
		this.neighborhood = neighborhood;
		this.people = people;
		this.category = category;
		this.name = name;
		this.location = location;
		this.telno = telno;
		this.number = number;
	}
	// 리뷰등록
	public DbActionRegisterRestaurant_HJ(String id, String name, String location, String telno, String number) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.telno = telno;
		this.number = number;
	}
	//-------------2021.05.01 이도희-------------
//	public DbActionFood(String number, String name, String location, String telno, String neighborhood, String people, String category) {
//		super();
//		this.number = number;
//		this.name = name;
//		this.location = location;
//		this.telno = telno;
//		this.neighborhood = neighborhood;
//		this.people = people;
//		this.category = category;
//		this.id = id;
//	}
//	public void DbActionRfoodEnroll1(String number2, String name2, String telno2, String location2, String category2,
//			String neighborhood2, String people2) {
//		// TODO Auto-generated constructor stub
//	}
	
	
	//method
	//등록 확인
//	public boolean EnrollQuery() {
//		PreparedStatement ps = null;
//        try{
//        	
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//            @SuppressWarnings("unused")
//			Statement stmt_mysql = conn_mysql.createStatement();
//            
//            String A = "insert into restaurant(people,neighborhood,category,name,location,telno,number";
//            String B = " )values (?,?,?,?,?,?,?)";
//            
//            ps = conn_mysql.prepareStatement(A+B);
//         
//            // ps.setString(1,"sdf");
//            ps.setString(1, people);
//            ps.setString(2, neighborhood);
//            ps.setString(3, category);
//			ps.setString(4, name);
//			ps.setString(5, location);
//			ps.setString(6, telno);
//			ps.setString(7,number);
//			ps.executeUpdate();
//
//            conn_mysql.close();
//            
//        } catch (Exception e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "등록 완료!");
//            return true;    
//        }
//        return false; 	
//	}
	
	
	
	//-------------2021.05.01 이도희-------------
	// 식당 등록
	public boolean registerRestaurant() {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query1 = "insert into restaurant(o_id, people, neighborhood, category, name, location, telno, number)";
			String query2 = " values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn_mysql.prepareStatement(query1 + query2);
			ps.setString(1, id);
			ps.setString(2, people);
			ps.setString(3, neighborhood);
			ps.setString(4, category);
			ps.setString(5, name);
			ps.setString(6, location);
			ps.setString(7, telno);
			ps.setString(8, number);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// r_code 알아내기
	public ArrayList<BeanRestaurant_Owner> rCode() {
		
		ArrayList<BeanRestaurant_Owner> beanList = new ArrayList<BeanRestaurant_Owner>();
				
		String query = "select code from restaurant where o_id='" + id + "' and name='" + name + "' and location='" + location + "' and telno='" + telno + "' and number='" + number + "'";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				String wkCode = rs.getString(1);
				
				BeanRestaurant_Owner beanFood = new BeanRestaurant_Owner(wkCode);
				beanList.add(beanFood);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return beanList;
	}
	
	// 리뷰 등록
	public void registerReview(String r_code) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query1 = "insert into review(r_code, u_id, menu, content)";
			String query2 = " values (?, ?, ?, ?)";
			
			ps = conn_mysql.prepareStatement(query1 + query2);
			ps.setString(1, r_code);
			ps.setString(2, "admin");
			ps.setString(3, "admin");
			ps.setString(4, "admin");
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//-------------2021.05.01 이도희-------------
}
