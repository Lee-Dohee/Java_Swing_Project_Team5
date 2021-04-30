package com.javalec.Restaurantenrollfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbActionRfoodEnroll {
	
		//field
	
		private final String url_mysql = RfoodEnrollShareV.url_mysql;
		private final String id_mysql = RfoodEnrollShareV.id_mysql;
		private final String pw_mysql = RfoodEnrollShareV.pw_mysql;
		
			//변수 저장

			String number; //사업자등록번호
			String name; //식당이름
			String location; //식당주소
			String telno; //전화번호
			String neighborhood; //동네
			String people; //몇 인분인지 선택하는 것의 변수
			String category; //음식 선택
			String id; //아이디
	
		


		
	
			//source
			
			public DbActionRfoodEnroll(String number, String name, String location, String telno, String neighborhood,
					String people, String category) {
				super();
				this.number = number;
				this.name = name;
				this.location = location;
				this.telno = telno;
				this.neighborhood = neighborhood;
				this.people = people;
				this.category = category;
				this.id = id;
			}
			



		//construction


			

		//--------------------------------
		//method
		//--------------------------------

			public void DbActionRfoodEnroll1(String number2, String name2, String telno2, String location2, String category2,
					String neighborhood2, String people2) {
				// TODO Auto-generated constructor stub
			}




			//등록 확인
			public boolean EnrollQuery() {
				PreparedStatement ps = null;
		        try{
		        	
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		            @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		            
		            String A = "insert into restaurant(people,neighborhood,category,name,location,telno,number";
		            String B = " )values (?,?,?,?,?,?,?)";
		            
		            ps = conn_mysql.prepareStatement(A+B);
		         
		           // ps.setString(1,"sdf");
		            ps.setString(1, people);
		            ps.setString(2, neighborhood);
		            ps.setString(3, category);
					ps.setString(4, name);
					ps.setString(5, location);
					ps.setString(6, telno);
					ps.setString(7,number);
					ps.executeUpdate();

		            conn_mysql.close();
		            
		        } catch (Exception e){
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "등록 완료!");
		            return true;    
		        }
		        return false; 	
		}


}//-----
