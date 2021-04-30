package com.javalec.R_Joinfunction;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.RmyPagefunction.RmyPageShareV;
import com.javalec.RmyPagemain.RmyPage;

public class DbActionRjoin {
	//field
	private final String url_mysql = RmyPageShareV.url_mysql;
	private final String id_mysql = RmyPageShareV.id_mysql;
	private final String pw_mysql = RmyPageShareV.pw_mysql;
	
	 String name;
     String id;
     String pw;
     String pw2;
     String telno;
     String email;

     
     //constructor
     public DbActionRjoin(String name, String id, String pw,String telno, String email) {
    	 super();
    	 this.name = name;
    	 this.id = id;
    	 this.pw = pw;
    	 this.telno = telno;
    	 this.email = email;
    	 
     }
 
	//method
     
 	//가입하기
 	public boolean joinAction() {
 		
 		PreparedStatement ps = null;
 		
 		try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           java.sql.Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
           Statement stmt_mysql = conn_mysql.createStatement();

           String A = "insert into owner(id,pw,name,telno,email)";
           String B = " values (?, ?, ?, ?, ?)";

           ps = conn_mysql.prepareStatement(A+B);
	           ps.setString(1, id);
	           ps.setString(2, pw);
	           ps.setString(3, name);
	           ps.setString(4, telno);
	           ps.setString(5, email);
	           
	           ps.executeUpdate();
           
          conn_mysql.close();
          
 	      } catch (Exception e){
 	          e.printStackTrace();
 	         JOptionPane.showMessageDialog(null, "회원가입 완료!");
 	          return true;
 	      }
 		 return false;
 	}
 	
 	//아이디 중복확인
	public boolean idAction(String idcorrect) {
			boolean idcorrect2 = false;

			  int dataCount = 0;
			  
			  try {
				   	  Class.forName("com.mysql.cj.jdbc.Driver");
			          java.sql.Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			          Statement stmt_mysql = conn_mysql.createStatement();
			          
			          String Query="select id from owner where id= '";
			          String Query1=idcorrect +"'";
			          
			          ResultSet rs = stmt_mysql .executeQuery(Query+Query1);
			          
			          while(rs.next()) {
			        	  dataCount++;
			          }
			          conn_mysql.close();
			          if(dataCount>0) {
			        	 idcorrect2 = false;
			          }else {
			        	  idcorrect2 = true;
			          }
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			  
			  return idcorrect2;
		     
		     }   
 	
 	
 	

     
     

}//------------------------------------------
