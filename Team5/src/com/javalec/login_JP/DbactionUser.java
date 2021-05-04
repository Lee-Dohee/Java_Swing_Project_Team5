package com.javalec.login_JP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;


public class DbactionUser {
	
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql; 
  	////////// User 로그인 /////////////
	  
    public int Userlogin(String userID, String userPassword) {  // 로그인시 확인작업

	    //mypageTest_User mypagetest = new mypageTest_User();    //로그인 성공시 마이페이지로 전환
	    //mypagetest.mypagetest(userID);
	    //
	    //Log_in_User loginuser = new Log_in_User();   // 로그인 성공시 로그인 페이지 닫기
	
	    String query1 = "select pw from user where id =?"; 
	
	    try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		    Statement stmt_mysql = conn_mysql.createStatement();	// 선언문
		    PreparedStatement pstmt = conn_mysql.prepareStatement(query1);
		
		    pstmt.setString(1, userID);			  // 아이디값 넣어주기
		    ResultSet rs = pstmt.executeQuery(); 
		
		    if (rs.next()) {
			    if(rs.getString(1).contentEquals(userPassword)) {
				    //loginuser.frame.setVisible(false); // 로그인 성공시 로그인 페이지 닫기
				    //mypagetest.tfmp_id.setText(userID);  // 로그인시 마이페이지에 아이디 정보 보내기 = 현진씨 tf이름 = tfid
				    //mypagetest.frame.setVisible(true);   //로그인 성공시 마이페이지로 전환  
			    	return 1; 
			    }else { 
//			    	JOptionPane.showMessageDialog(null,  "아이디와 비밀번호를 확인해주세요");
			    	return 0;
			    }	
		    }
//		    JOptionPane.showMessageDialog(null,  "등록되지 않은 아이디입니다");
		    return -1;
	    }catch(Exception e) {
	    	e.printStackTrace(); 
	    }
	    return -2;  
    }
    /////////////////////////////////////////////////////////////////////////
               

    
    ////////// User 계정 아이디 찾기/////////////
	public int searchuserid(String name, String phone, String email) {  // 아이디 계정찾기
	
		String query1 = "select name, telno, email, id, pw from user where telno = ? "; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();	// 선언문
			
			PreparedStatement pstmt = conn_mysql.prepareStatement(query1);
			pstmt.setString(1, phone);   // ?에 telno를 넣는다
			
			ResultSet rs = pstmt.executeQuery();  // 이름 결과값 넣어주기
			
			if (rs.next()) {
				if(rs.getString(1).contentEquals(name)&&rs.getString(2).contentEquals(phone)&&rs.getString(3).contentEquals(email)) {    //결과값 telno과 입력한 값이 값냐를 반환받아 맞으면 리턴값을1 틀리면 0 에러가 나면 -2
					JOptionPane.showMessageDialog(null,  "고객님의 아이디는" + rs.getString(4)+"입니다");
					return 1;
				}
			}else { 
//				JOptionPane.showMessageDialog(null,  "사용자 정보를 다시 확인해주세요");
				return 0;
			}
//			JOptionPane.showMessageDialog(null,  "사용자 정보를 다시 확인해주세요");
			return -1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;  
	}



	/////////////////////////////////////////////////////////////////////////


	////////// User 계정 비밀번호/////////////
	public int searchpw(String id, String name, String phone, String email) {  // 비밀번호 계정찾기
	
		String query1 = "select name, telno, email, id, pw from user where id = ? "; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();	// 선언문
			
			PreparedStatement pstmt = conn_mysql.prepareStatement(query1);
			pstmt.setString(1, id);   // ?에 id을 넣는다
			
			ResultSet rs = pstmt.executeQuery();  // id 결과값 넣어주기
			
			if (rs.next()) {
				if(rs.getString(1).contentEquals(name)&&rs.getString(2).contentEquals(phone)&&rs.getString(3).contentEquals(email)&&rs.getString(4).contentEquals(id)) {    //결과값 id과 입력한 값이 값냐를 반환받아 맞으면 리턴값을1 틀리면 0 에러가 나면 -2
					JOptionPane.showMessageDialog(null,  "고객님의 비밀번호는" + rs.getString(5)+"입니다");
					return 1;
				}
			}else {
//				JOptionPane.showMessageDialog(null,  "사용자 정보를 다시 확인해주세요");
				return 0;
			}
//			JOptionPane.showMessageDialog(null,  "사용자 정보를 다시 확인해주세요");
			return -1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;  
	}
}

