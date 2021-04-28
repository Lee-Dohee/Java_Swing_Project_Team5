package com.javalec.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.ShareVariable;
import com.javalec.menu.BeanMenu;

public class DbActionRestrant {
	
	// Field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;
	
	String name;
	
	// Construct
	public DbActionRestrant() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// Method
	
	// restaurant 기본 정보 불러오기
	public BeanRestrant restaurantInfo() {
		
		BeanRestrant beanRestrant = null;
		
		String query = "select name, location, telno from restaurant where code ='1'";	// 레스토랑 코드로
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkName = rs.getString(1);
				String wkLocation = rs.getString(2);
				String wkTelno = rs.getString(3);
				
				beanRestrant = new BeanRestrant(wkName, wkLocation, wkTelno);
			}
			conn_mysql.isClosed();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return beanRestrant;
	}
	
	// restaurant 평균 별점 불러오기
	public String restaurantStar(){
		
		String wkStar = "";
		String query = "select sum(length(star)/3)/count(star) from review where r_code='1'";
		
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
	public ArrayList<BeanRestrant> allergyMenuTable() {
		
		ArrayList<BeanRestrant> beanList = new ArrayList<BeanRestrant>();
		
		String allergy = "";		
		String query = "select name, price, content, allergy from menu";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			
			while(rs.next()) {
				
				if(rs.getString(4).equals("t")) {
					allergy = "알러지 유발 재료 있음";
				}else{
					allergy = "알러지 유발 재료 없음";
				}
				
				String wkName = rs.getString(1);
	        	String wkPrice = rs.getString(2);
	        	String wkContent = rs.getString(3);
				
				BeanRestrant beanRestrant = new BeanRestrant(wkName, wkPrice, wkContent, allergy);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return beanList;
	}
	
	// 회원 알러지와 메뉴 알러지 교집합 리스트
	public ArrayList<BeanRestrant> AllergyList(String wkName) {
		
		ArrayList<BeanRestrant> beanList = new ArrayList<BeanRestrant>();
		
		String query = "select allergy.name from allergy "
				+ "inner join menuchk on menuchk.m_name = '" + wkName
				+ "' and menuchk.a_code = allergy.code "
				+ "inner join userchk on userchk.u_id = 'Merry' and userchk.a_code = allergy.code";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query);

	        while(rs.next()){
	        	// wk에 rs값 저장
	        	String wkAllergy = rs.getString(1);
	        	// Bean = 한줄, BenaList = 값 전체
	        	// 가져온 값 Bean에 저장
	        	BeanRestrant bean = new BeanRestrant(wkAllergy);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(bean);
	        }
	        conn_mysql.close();
	    }
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    
	    return beanList;
	}
	
	// Review Table값 불러오기
	public ArrayList<BeanRestrant> reviewTable() {
		
		ArrayList<BeanRestrant> beanList = new ArrayList<BeanRestrant>();
		
		String query = "select date, u_id, star, menu, content from review";
		
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
				
				BeanRestrant beanRestrant = new BeanRestrant(wkDate, wkU_id, wkStar, wkMenu, wkContent);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}

}
