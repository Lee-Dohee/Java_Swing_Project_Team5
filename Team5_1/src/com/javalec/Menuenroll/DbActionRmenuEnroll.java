package com.javalec.menuenroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DbActionRmenuEnroll {
	//field
	private final String url_mysql = RmenuEnrollShareV.url_mysql;
	private final String id_mysql =  RmenuEnrollShareV.id_mysql;
	private final String pw_mysql =  RmenuEnrollShareV.pw_mysql;
	
	int m_code;
	String m_name;
	String m_allergy;
	String m_price;
	String m_content;
	
	//construction
	public DbActionRmenuEnroll(int m_code, String m_name, String m_allergy, String m_price, String m_content) {
		super();
		this.m_code = m_code;
		this.m_name = m_name;
		this.m_allergy = m_allergy;
		this.m_price = m_price;
		this.m_content = m_content;
	}
	
	//--------------------------------
	//method
	//--------------------------------

	public ArrayList<BeanRmenuEnroll> selectList() {
			
			ArrayList<BeanRmenuEnroll> beanList = new ArrayList<BeanRmenuEnroll>();
			
			  String WhereDefault = "select m_code,m_name,m_content,m_allergy ,m_price from menu";
	       try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();

	           ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

	           while(rs.next()){
	        	   int wkm_code = rs.getInt(1);
	        	   String wkm_Name = rs.getString(2);
	        	   String wkm_allergy = rs.getString(3);
	        	   String wkm_price = rs.getString(4);
	        	   String wkm_content = rs.getString(5);
	        	   
	        	   BeanRmenuEnroll bean = new BeanRmenuEnroll(wkm_code, wkm_Name, wkm_allergy, wkm_price, wkm_content);
	        	   beanList.add(bean);
	        	   
	            }
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
		return beanList;
	
	}
	
	
	
}//===============
