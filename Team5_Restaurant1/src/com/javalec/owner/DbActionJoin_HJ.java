package com.javalec.owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;

public class DbActionJoin_HJ {

	//field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;
	
	String name;
    String id;
    String pw;
    String pw2;
    String telno;
    String email;

     
    //constructor
    
    //-------------2021.04.30 이도희-------------
    // id 중복 확인
    public DbActionJoin_HJ(String id) {
    	super();
    	this.id = id;
    }
    //-------------2021.04.30 이도희-------------
    
    public DbActionJoin_HJ(String id, String pw, String name, String telno, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.telno = telno;
		this.email = email;
    }
//    public DbActionJoin(String name, String id, String pw,String telno, String email) {
//    	super();
//    	this.name = name;
//    	this.id = id;
//    	this.pw = pw;
//    	this.telno = telno;
//    	this.email = email;
//    }
 

	//method
     
 	//가입하기
 	public boolean joinAction() {

 		PreparedStatement ps = null;
 		
 		try{
 			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "insert into owner(id, pw, name, telno, email)";
			String B = " values (?, ?, ?, ?, ?)";

			ps = conn_mysql.prepareStatement(A + B);
           	ps.setString(1, id);
           	ps.setString(2, pw);
           	ps.setString(3, name);
           	ps.setString(4, telno);
           	ps.setString(5, email);
           
           	ps.executeUpdate();
       
           	conn_mysql.close();
           	
           	//-------------2021.05.03 이도희-------------
           	return true;
           	//-------------2021.05.03 이도희-------------
 		}catch (Exception e){
 			e.printStackTrace();
// 	        JOptionPane.showMessageDialog(null, "회원가입 완료!");
// 	        return true;
 			//-------------2021.05.03 이도희-------------
 			return false;
 			//-------------2021.05.03 이도희-------------
 	    }
// 		return false;
 	}
 	
 	//아이디 중복확인 - 임현진
//	public boolean idAction(String idcorrect) {
//
//		boolean idcorrect2 = false;
//
//		int dataCount = 0;
//		  
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//	          
//	        String Query = "select id from owner where id = '";
//	        String Query1 = idcorrect +"'";
//	          
//	        ResultSet rs = stmt_mysql.executeQuery(Query+Query1);
//	          
//	        while(rs.next()) {
//	        	dataCount++;
//	        }
//	        conn_mysql.close();
//	        
//	        if(dataCount>0) {
//	        	idcorrect2 = false;
//	        }else {
//	        	idcorrect2 = true;
//	        }
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return idcorrect2;
// 	}   
	
	
	//-------------2021.04.30 이도희-------------
 	// id 중복 확인
	public int idChk() {
		
		String query = "select EXISTS (select id from owner where id = '" + id + "') as success";
		int num = 0;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				if (rs.getInt(1) == 0) {
					num = 0;
				}else {
					num = 1;
				}
			}
			conn_mysql.isClosed();
			
		}catch(Exception e) {
			e.printStackTrace();
			num = 2;
		}
		return num;
	}
	//-------------2021.04.30 이도희-------------
	//-------------2021.05.03 이도희-------------
	// 내정보 불러오기
	public BeanRestaurant myInfo() {
		
		BeanRestaurant beanRestrant = null;
		
		String query = "select name, email, telno from owner where id='" + id + "'";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkName = rs.getString(1);
				String wkEmail = rs.getString(2);
				String wkTelno = rs.getString(3);
				
				beanRestrant = new BeanRestaurant(wkName, wkEmail, wkTelno);
			}
			conn_mysql.isClosed();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return beanRestrant;
	}
	// 내정보 수정
	public boolean modifyAction() {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "update owner set pw=?, name=?, telno=?, email=? where id='" + id + "'";
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, pw);
			ps.setString(2, name);
			ps.setString(3, telno);
			ps.setString(4, email);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//-------------2021.05.03 이도희-------------
}
