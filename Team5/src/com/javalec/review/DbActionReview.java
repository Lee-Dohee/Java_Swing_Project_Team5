package com.javalec.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	// Construct
	public DbActionReview() {
		// TODO Auto-generated constructor stub
	}
	
	public DbActionReview(String u_id, String r_code, String menu, String content) {
		super();
		this.u_id = u_id;
		this.r_code = r_code;
		this.menu = menu;
		this.content = content;
	}

	// Method
	public boolean registerAction(String star) {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into review(u_id, r_code, star, menu, content)";
			String query1 = " values (?, ?, ?, ?, ?)";
			String allergyChk = "";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, u_id);			// 해당 유저로 설정
			ps.setString(2, r_code);
			ps.setString(3, star);
			ps.setString(4, menu);
			ps.setString(5, content);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
