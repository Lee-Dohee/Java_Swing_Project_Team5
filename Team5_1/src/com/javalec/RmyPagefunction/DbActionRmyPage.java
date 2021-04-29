package com.javalec.RmyPagefunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.R_Joinfunction.RjoinShareV;



public class DbActionRmyPage {
	
	//field
	
	// RjoinShareV 와 연결
	private final String url_mysql = RjoinShareV.url_mysql;
	private final String id_mysql = RjoinShareV.id_mysql;
	private final String pw_mysql = RjoinShareV.pw_mysql;
	
	//변수 선언
	 String name;
     String id;
     String pw;
     String pw2;
     String telno;
     String Enrollnumber;
     
    //constructor
     
    //Source Using field
     public DbActionRmyPage(String name, String id, String pw3, String pw22, String telno, String enrollnumber) {
     		super();
     		this.name = name;
     		this.id = id;
     		this.pw = pw3;
     		this.pw2 = pw22;
     		this.telno = telno;
     		this.Enrollnumber = enrollnumber;
     				}
     
     		
   //=====================
   //method
   //=====================

     	//DbActionRmyPage
     	public DbActionRmyPage(String name2, String telno2, String id2, String pw3, String enrollnumber2) {
     		
			}

     	//tfId 정의
			public DbActionRmyPage(JTextField tfId) {
			// TODO Auto-generated constructor stub
		}




		//정보 수정
			public boolean UpdateAction() {
					PreparedStatement ps = null;
				try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
							@SuppressWarnings("unused")
							Statement stmt_mysql = conn_mysql.createStatement();

							String A = "update restrant set  name = ?, pw = ?, telno = ?, enrollnumber = ?";
							String B = " where id = ? ";
		           
							ps = conn_mysql.prepareStatement(A+B);
							
							ps.setString(1, name.trim());
							ps.setString(2, pw.trim());
							ps.setString(3, telno.trim());
							ps.setString(4, Enrollnumber.trim()); 
							ps.setString(5, id.trim());
		       
							ps.executeUpdate();

							conn_mysql.close();
							return true; 
		       
					} catch (Exception e){
							e.printStackTrace();
						return false; 
		   				}
			}
			
			
			//정보 확인
		
			public BeanRmyPage correct() {
				
				return null;
			}
	
			//창을 열면 뜨는 나의 정보
				public BeanRmyPage startAction() {
					BeanRmyPage bean = null;
				
				 String WhereDefault = "select id, name, pw, telno, enrollnumber from restrant "; 
				 String WhereDefault2 = "where id = " ;
				 	try{
				 		Class.forName("com.mysql.cj.jdbc.Driver");
				 		Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				 		Statement stmt_mysql = conn_mysql.createStatement();

				 		ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);

				 	while(rs.next()){
				 		String wkId = rs.getString(1);
				 		String wkName = rs.getString(2);
				 		String wkPw = rs.getString(3);
				 		String wkPw2 = rs.getString(4);
				 		String wkTelno = rs.getString(5);
				 		String wkEnrollnumber = rs.getString(6);
		           	
				 		bean = new BeanRmyPage(wkId, wkName, wkPw, wkPw2, wkTelno,wkEnrollnumber);
		           }
		           conn_mysql.close();
		       }
		       catch (Exception e){
		           e.printStackTrace();
		       }
					return bean;
			}
	

}//----------------------------------
