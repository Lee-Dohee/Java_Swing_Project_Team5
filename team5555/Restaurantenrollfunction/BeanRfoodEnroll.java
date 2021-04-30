package com.javalec.Restaurantenrollfunction;

public class BeanRfoodEnroll {
	
			//field
	
		String number; //사업자등록번호
		String name; //식당이름
		String location; //식당주소
		String telno; //전화번호
		String neighborhood; //동네
		String people; //몇 인분인지 선택하는 것의 변수
		String category; //음식 선택
		String id; //아이디
		
		
		//constructor
		public BeanRfoodEnroll(String number, String name, String location, String telno, String neighborhood,
				String people, String category, String id) {
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


		//method
		
		//getter and setter로 sql과 메인 사이에 값을 받아오고 받기
		
		public String getNumber() {
			return number;
		}


		public void setNumber(String number) {
			this.number = number;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public String getTelno() {
			return telno;
		}


		public void setTelno(String telno) {
			this.telno = telno;
		}


		public String getNeighborhood() {
			return neighborhood;
		}


		public void setNeighborhood(String neighborhood) {
			this.neighborhood = neighborhood;
		}


		public String getPeople() {
			return people;
		}


		public void setPeople(String people) {
			this.people = people;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public boolean EnrollQuery() {
			// TODO Auto-generated method stub
			return false;
		}



			
		
	

	
	
	
	
	
	

}//----
