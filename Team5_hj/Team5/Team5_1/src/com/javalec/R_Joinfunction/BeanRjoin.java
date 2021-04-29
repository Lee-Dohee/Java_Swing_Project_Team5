package com.javalec.R_Joinfunction;

public class BeanRjoin {
	
	//field
	 String name;
     String id;
     String pw;
     String telno;
     String Enrollnumber;
     
     
     //constructor
	public BeanRjoin(String name, String id, String pw, String telno, String enrollnumber) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.telno = telno;
		Enrollnumber = enrollnumber;
	}


	//method
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getTelno() {
		return telno;
	}


	public void setTelno(String telno) {
		this.telno = telno;
	}


	public String getEnrollnumber() {
		return Enrollnumber;
	}


	public void setEnrollnumber(String enrollnumber) {
		Enrollnumber = enrollnumber;
	}

	



     
}//===============================
