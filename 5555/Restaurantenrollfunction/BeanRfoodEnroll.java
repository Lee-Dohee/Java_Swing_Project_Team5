package com.javalec.Restaurantenrollfunction;

public class BeanRfoodEnroll {
	
	//field
	
	String Rname;
	String Raddress;
	String Rtelco;
	int REnrollNumber;
	
	//constructor
	public BeanRfoodEnroll() {
		
	}

	public BeanRfoodEnroll(String rname, String raddress, String rtelco, int rEnrollNumber) {
		super();
		Rname = rname;
		Raddress = raddress;
		Rtelco = rtelco;
		REnrollNumber = rEnrollNumber;
	}

	
	//method
	
	public String getRname() {
		return Rname;
	}
	
	public void setRname(String rname) {
		Rname = rname;
	}
	
	public String getRaddress() {
		return Raddress;
	}
	
	public void setRaddress(String raddress) {
		Raddress = raddress;
	}
	
	public String getRtelco() {
		return Rtelco;
	}
	
	public void setRtelco(String rtelco) {
		Rtelco = rtelco;
	}
	
	public int getREnrollNumber() {
		return REnrollNumber;
	}
	
	public void setREnrollNumber(int rEnrollNumber) {
		REnrollNumber = rEnrollNumber;
	}
	
	
	
	
	
	
	

}//----
