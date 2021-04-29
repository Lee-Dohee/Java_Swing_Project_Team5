package com.javalec.RmyPagefunction;

public class BeanRmyPage {
	//field
		 String name;
	     String id;
	     String pw;
	     String pw2;
	     String telno;
	     String Enrollnumber;
	     
	     
	     //constructor
		public BeanRmyPage(String name, String id, String pw, String pw2, String telno, String enrollnumber) {
			super();
			this.name = name;
			this.id = id;
			this.pw = pw;
			this.pw2 = pw2;
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


		public String getPw2() {
			return pw2;
		}


		public void setPw2(String pw2) {
			this.pw2 = pw2;
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


	

}//------
