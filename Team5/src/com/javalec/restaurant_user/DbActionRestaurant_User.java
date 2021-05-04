package com.javalec.restaurant_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.ShareVariable;

public class DbActionRestaurant_User {
	
	// Field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;
	
	String name;
	String neighborhood;
	String people;
	String category;
	String star;
	
	// Construct
	public DbActionRestaurant_User() {
		// TODO Auto-generated constructor stub
	}
	// tf 이름 검색
	public DbActionRestaurant_User(String name) {
		super();
		this.name = name;
	}
	// cb 조건 검색
	public DbActionRestaurant_User(String neighborhood, String people, String category, String star) {
		super();
		this.neighborhood = neighborhood;
		this.people = people;
		this.category = category;
		this.star = star;
	}
	
	// Method
	
	// 식당 table 불러오기
	public ArrayList<BeanRestaurant_User> restaurantTable(){
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		String query = "select rt.code, rt.name, sum(length(rw.star)/3)/count(rw.star) s, rt.location from restaurant as rt, review as rw where rt.code = rw.r_code group by rw.r_code order by s desc";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				int wkNum = Integer.parseInt(rs.getString(1));
				String wkName = rs.getString(2);
				String wkStar = String.format("%.2f", rs.getDouble(3));
	        	String wkLocation = rs.getString(4);
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkNum, wkName, wkStar, wkLocation);
				
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	// 조건검색 동네
	public ArrayList<BeanRestaurant_User> searchNeighborhoodAction() {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		people = "";
		category = "";
		star = "";
		
		String query1 = "select rt.code, rt.name, sum(length(rw.star)/3)/count(rw.star) s, rt.location from restaurant as rt, review as rw ";
        String query2 = "where rt.code = rw.r_code " + neighborhood + "group by rw.r_code order by s desc";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

            while(rs.next()){
            	
            	int wkNum = Integer.parseInt(rs.getString(1));
				String wkName = rs.getString(2);
				String wkStar = String.format("%.2f", rs.getDouble(3));
	        	String wkLocation = rs.getString(4);
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkNum, wkName, wkStar, wkLocation);
				
	        	beanList.add(beanRestrant);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return beanList;
	}
	
	// 조건검색 사람
	public ArrayList<BeanRestaurant_User> searchPeopleAction() {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		neighborhood = "";
		category = "";
		star = "";
		
		String query1 = "select rt.code, rt.name, sum(length(rw.star)/3)/count(rw.star) s, rt.location from restaurant as rt, review as rw ";
        String query2 = "where rt.code = rw.r_code " + people + "group by rw.r_code order by s desc";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

            while(rs.next()){
            	
            	int wkNum = Integer.parseInt(rs.getString(1));
				String wkName = rs.getString(2);
				String wkStar = String.format("%.2f", rs.getDouble(3));
	        	String wkLocation = rs.getString(4);
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkNum, wkName, wkStar, wkLocation);
				
	        	beanList.add(beanRestrant);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return beanList;
	}
	
	// 조건검색 음식 카테고리
	public ArrayList<BeanRestaurant_User> searchCategoryAction() {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		neighborhood = "";
		people = "";
		star = "";
		
		String query1 = "select rt.code, rt.name, sum(length(rw.star)/3)/count(rw.star) s, rt.location from restaurant as rt, review as rw ";
        String query2 = "where rt.code = rw.r_code " + category + "group by rw.r_code order by s desc";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

            while(rs.next()){
            	
            	int wkNum = Integer.parseInt(rs.getString(1));
				String wkName = rs.getString(2);
				String wkStar = String.format("%.2f", rs.getDouble(3));
	        	String wkLocation = rs.getString(4);
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkNum, wkName, wkStar, wkLocation);
				
	        	beanList.add(beanRestrant);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return beanList;
	}
	
	// tf 이름 검색
	public ArrayList<BeanRestaurant_User> searchAction() {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		String query1 = "select rt.code, rt.name, sum(length(rw.star)/3)/count(rw.star), rt.location from restaurant as rt, review as rw ";
        String query2 = "where rt.code = rw.r_code and rt.name like '%" + name + "%' group by rw.r_code";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

            while(rs.next()){
            	
            	int wkNum = Integer.parseInt(rs.getString(1));
				String wkName = rs.getString(2);
				String wkStar = String.format("%.2f", rs.getDouble(3));
	        	String wkLocation = rs.getString(4);
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkNum, wkName, wkStar, wkLocation);
				
	        	beanList.add(beanRestrant);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return beanList;
	}
		
	// restaurant 기본 정보 불러오기
	public BeanRestaurant_User restaurantInfo(String wkNum) {
		
		BeanRestaurant_User beanRestrant = null;
		
		String query = "select name, location, telno from restaurant where code ='" + wkNum + "'";	// 레스토랑 코드로
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkName = rs.getString(1);
				String wkLocation = rs.getString(2);
				String wkTelno = rs.getString(3);
				
				beanRestrant = new BeanRestaurant_User(wkName, wkLocation, wkTelno);
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
				// 값이 null일 때 해결
//				if(rs.getString(1) == null) {
//					wkStar = "0";
//				}else {
//				}
				wkStar = String.format("%.2f", rs.getDouble(1));
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return wkStar;
	}
	
	// 회원이 알러지가 있나 없나 판단
	public int allergyChk(String id) {
		
		String query = "select EXISTS (select * from userchk where u_id = '" + id + "') as success;";
		
		int num = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				// 알레르기 있는 사람은 알레르기 보여줌, 알레르기 없는 사람은 알레르기 안보여줌
				if (rs.getInt(1) == 1) {
					num = 1;
				}else {
					num = 0;
				}
			}
			conn_mysql.isClosed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	// 알러지 회원 Menu Table값 불러오기
	public ArrayList<BeanRestaurant_User> allergyMenuTable(String wkNum) {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		String allergy = "";		
		String query = "select name, price, content, allergy from menu where r_code='" + wkNum + "'";
		
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
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkName, wkPrice, wkContent, allergy);
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
	public ArrayList<BeanRestaurant_User> AllergyList(String wkName, String id) {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		String query = "select allergy.name from allergy "
				+ "inner join menuchk on menuchk.m_name = '" + wkName
				+ "' and menuchk.a_code = allergy.code "
				+ "inner join userchk on userchk.u_id = '" + id + "' and userchk.a_code = allergy.code";	// 현재 회원의 아이디로 변경
		
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
	        	BeanRestaurant_User bean = new BeanRestaurant_User(wkAllergy);
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
	
	// 알러지 없는 회원 Menu Table값 불러오기
	public ArrayList<BeanRestaurant_User> menuTable(String wkNum) {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
		String allergy = "";		
		String query = "select name, price, content, allergy from menu where r_code='" + wkNum + "'";
		
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
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkName, wkPrice, wkContent, allergy);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(beanRestrant);
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	// Review Table값 불러오기
	public ArrayList<BeanRestaurant_User> reviewTable(String wkNum) {
		
		ArrayList<BeanRestaurant_User> beanList = new ArrayList<BeanRestaurant_User>();
		
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
				
				BeanRestaurant_User beanRestrant = new BeanRestaurant_User(wkDate, wkU_id, wkStar, wkMenu, wkContent);
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
