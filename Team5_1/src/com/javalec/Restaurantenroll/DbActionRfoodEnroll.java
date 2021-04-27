package com.javalec.Restaurantenroll;

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

		String name;
		String address;
		String telno;
		int enrollnumber;
		String neighborhood;
		String people;
		String categories;

		
		
		

			public DbActionRfoodEnroll(String name, String address, String telno,int enrollnumber, String neighborhood,String people,String categories) {
			super();
			this.name = name;
			this.address = address;
			this.telno = telno;
			this.enrollnumber = enrollnumber;
			this.neighborhood = neighborhood;
			this.people = people;
			this.categories = categories;
		}





			//construction

			public DbActionRfoodEnroll(int enrollnumber) {
				super();
				this.enrollnumber = enrollnumber;
			}
			public DbActionRfoodEnroll(int enrollnumber2, String name2, String telno, String address2, String neighborhood2, String people2, String categories2) {
				
			}
			
			//--------------------------------
			//method
			//--------------------------------
		
	




		//등록 확인
		public boolean EnrollQuery() {
		       PreparedStatement ps = null;
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		            @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();

		            String A = "insert into restrigister(enrollNumber,name,address,telno,neighborhood,people,categories";
		            String B = " )values (?,?,?,?,?,?,?)";

		            ps = conn_mysql.prepareStatement(A+B);
		            
		            ps.setLong(1,enrollnumber);
					ps.setString(2, name);
					ps.setString(3, address);
					ps.setString(4, telno);
					ps.setString(5, neighborhood);
					ps.setString(6, people);
					ps.setString(7, categories);

		            ps.executeUpdate();

		            conn_mysql.close();
		            JOptionPane.showMessageDialog(null, B);
		            return true;           
		        } catch (Exception e){
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, e);
		            return false;            
		        }
				
	}















	


}//-----
