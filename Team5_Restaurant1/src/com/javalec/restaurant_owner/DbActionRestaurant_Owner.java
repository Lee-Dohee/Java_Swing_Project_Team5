package com.javalec.restaurant_owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.ShareVariable;

public class DbActionRestaurant_Owner {
	
	// Field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;
	
	String name;
	String location;
	String telno;
	String neighborhood;
	String people;
	String category;
	
	
	// Construct
	public DbActionRestaurant_Owner() {
		// TODO Auto-generated constructor stub
	}
	// 정보 수정
	public DbActionRestaurant_Owner(String name, String location, String telno) {
		super();
		this.name = name;
		this.location = location;
		this.telno = telno;
	}
//	public DbActionRestaurant_Owner(String name, String location, String telno, String neighborhood, String people,
//			String category) {
//		super();
//		this.name = name;
//		this.location = location;
//		this.telno = telno;
//		this.neighborhood = neighborhood;
//		this.people = people;
//		this.category = category;
//	}
	
	
	
	// Method
	// 식당 table 불러오기
	public ArrayList<BeanRestaurant_Owner> restaurantTable(String id){
		
		ArrayList<BeanRestaurant_Owner> beanList = new ArrayList<BeanRestaurant_Owner>();
		
		String query1 = "select rt.code, rt.name, sum(length(rw.star)/3)/count(rw.star) s, rt.location from restaurant as rt, review as rw ";
		String query2 = "where rt.code = rw.r_code and rt.o_id = '" + id + "' group by rw.r_code";	// 해당 유저 id
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			
			while(rs.next()) {
				
				int wkNum = Integer.parseInt(rs.getString(1));
				String wkName = rs.getString(2);
				String wkStar = String.format("%.2f", rs.getDouble(3));
	        	String wkLocation = rs.getString(4);
				
	        	BeanRestaurant_Owner beanRestrant = new BeanRestaurant_Owner(wkNum, wkName, wkStar, wkLocation);
				
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	// restaurant 기본 정보 불러오기
	public BeanRestaurant_Owner restaurantInfo(String wkNum) {
		
		BeanRestaurant_Owner beanRestrant = null;
		
		String query = "select name, location, telno from restaurant where code ='" + wkNum + "'";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkName = rs.getString(1);
				String wkLocation = rs.getString(2);
				String wkTelno = rs.getString(3);
				
				beanRestrant = new BeanRestaurant_Owner(wkName, wkLocation, wkTelno);
			}
			conn_mysql.isClosed();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return beanRestrant;
	}

	// restaurant 평균 별점 불러오기
	public String restaurantStar(String wkNum){
		
		String wkStar = "";
		String query = "select sum(length(star)/3)/count(star) from review where r_code='" + wkNum + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				wkStar = String.format("%.2f", rs.getDouble(1));
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return wkStar;
	}
	
	// Menu Table값 불러오기
	public ArrayList<BeanRestaurant_Owner> menuTable(String wkNum) {
		
		ArrayList<BeanRestaurant_Owner> beanList = new ArrayList<BeanRestaurant_Owner>();
		
		String allergy = "";		
		String query = "select code, name, price, content, allergy from menu where r_code='" + wkNum + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				if(rs.getString(5).equals("t")) {
					allergy = "알러지 유발 재료 있음";
				}else{
					allergy = "알러지 유발 재료 없음";
				}
				
				int wkCode = rs.getInt(1);
				String wkName = rs.getString(2);
	        	String wkPrice = rs.getString(3);
	        	String wkContent = rs.getString(4);
				
				BeanRestaurant_Owner beanRestrant = new BeanRestaurant_Owner(wkCode, wkName, wkPrice, wkContent, allergy);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	// 해당 메뉴의 알러지 항목 가져오기
	// 포기
//	public ArrayList<BeanRestaurant_Owner> allergyList(String wkNum) {
//		
//		ArrayList<BeanRestaurant_Owner> beanList = new ArrayList<BeanRestaurant_Owner>();
//		
//		String allergy = "";
//		String query = "select code, name, price, content, allergy from menu where r_code='" + wkNum + "'";
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//			
//			ResultSet rs = stmt_mysql.executeQuery(query);
//			
//			while(rs.next()) {
//				
//				if(rs.getString(5).equals("t")) {
//					allergy = "알러지 유발 재료 있음";
//				}else{
//					allergy = "알러지 유발 재료 없음";
//				}
//				
//				int wkCode = rs.getInt(1);
//				String wkName = rs.getString(2);
//	        	String wkPrice = rs.getString(3);
//	        	String wkContent = rs.getString(4);
//				
//				BeanRestaurant_Owner beanRestrant = new BeanRestaurant_Owner(wkCode, wkName, wkPrice, wkContent, allergy);
//	        	// Bean을 Beanlist에 추가
//	        	beanList.add(beanRestrant);
//			}
//			conn_mysql.close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return beanList;
//		
//	}
	
	// Review Table값 불러오기
	public ArrayList<BeanRestaurant_Owner> reviewTable(String wkNum) {
		
		ArrayList<BeanRestaurant_Owner> beanList = new ArrayList<BeanRestaurant_Owner>();
		
		String query = "select date, u_id, star, menu, content from review where r_code='" + wkNum + "' and u_id not in('admin')";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkDate = rs.getString(1);
				String wkU_id = rs.getString(2);
	        	String wkStar = rs.getString(3);
	        	String wkMenu = rs.getString(4);
	        	String wkContent = rs.getString(5);
				
				BeanRestaurant_Owner beanRestrant = new BeanRestaurant_Owner(wkDate, wkU_id, wkStar, wkMenu, wkContent);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	// 식당 정보 수정
	public boolean modifyAction(String wkNum, String neighborhood, String people, String category) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "update restaurant set name=?, location=?, telno=?, neighborhood=?, people=?, category=? where code=" + wkNum;
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, location);
			ps.setString(3, telno);
			ps.setString(4, neighborhood);
			ps.setString(5, people);
			ps.setString(6, category);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 식당 삭제
	public boolean deleteRestaurantAction(String wkNum) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from restaurant where code=?";
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, wkNum);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 리뷰삭제
	public void deleteReviewAction(String wkNum) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from review where r_code=?";
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, wkNum);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 메뉴삭제
	public void deleteMenuAction(String wkNum) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from menu where r_code=?";
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, wkNum);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 메뉴 chk 삭제
		public void deleteMenuChkAction(String wkNum) {
			
			PreparedStatement ps = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				
				String query = "delete from menuchk where r_code=?";
				
				ps = conn_mysql.prepareStatement(query);
				ps.setString(1, wkNum);
				ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
	
}
