package com.javalec.review;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;

public class DbActionReview {

	// Field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;
	
	String u_id;
	String r_code;
	String menu;
	String content;
	FileInputStream file;
	
	// Construct
	public DbActionReview() {
		// TODO Auto-generated constructor stub
	}
	
	public DbActionReview(String u_id, String r_code, String menu, String content, FileInputStream file) {
		super();
		this.u_id = u_id;
		this.r_code = r_code;
		this.menu = menu;
		this.content = content;
		this.file = file;
	}

	// Method
	// 리뷰 등록
	public boolean registerAction(String star) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into review(u_id, r_code, star, menu, content, file)";
			String query1 = " values (?, ?, ?, ?, ?, ?)";
			String allergyChk = "";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, u_id);			// 해당 유저로 설정
			ps.setString(2, r_code);
			ps.setString(3, star);
			ps.setString(4, menu);
			ps.setString(5, content);
			ps.setBinaryStream(6, file);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 리뷰 삭제
	public boolean deleteAction(String wkDate, String wkId) {
		
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from review where date=? and u_id=?";
			
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, wkDate);
			ps.setString(2, wkId);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 영수증 보여주기
	public BeanReview TableClick(String wkId, String wkDate) {
		
		BeanReview bean = null;
		String WhereDefault = "select u_id, file from review ";
		String WhereDefault2 = "where u_id='" + wkId + "' and date='" + wkDate + "'";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	
	        ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
	        if(rs.next()){
	        	
	        	String wkName = rs.getString(1);
	        	
	        	// File
	        	ShareVariable.filename = ShareVariable.filename + 1;
	        	File file = new File(Integer.toString(ShareVariable.filename));
	        	FileOutputStream output = new FileOutputStream(file);
	        	InputStream input = rs.getBinaryStream(2);
	            byte[] buffer = new byte[1024];
	            while (input.read(buffer) > 0) {
	                output.write(buffer);
	            }
	        	
	            bean = new BeanReview(wkName);
	        }
	        
	        conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
		return bean;
	}
	
}
