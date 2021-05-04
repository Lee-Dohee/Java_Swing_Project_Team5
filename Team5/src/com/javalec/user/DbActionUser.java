package com.javalec.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;

public class DbActionUser {

	// Field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;	
	
	String id;
	String pw;
	String name;
	String telno;
	String email;
	JCheckBox chkEggs;
	JCheckBox chkMilk;
	JCheckBox chkBuckwheat;
	JCheckBox chkPeanut;
	JCheckBox chkMackerel;
	JCheckBox chkPork;
	JCheckBox chkSo2;
	JCheckBox chkBeef;
	JCheckBox chkSoybean;
	JCheckBox chkWheat;
	JCheckBox chkShrimp;
	JCheckBox chkTomato;
	JCheckBox chkChicken;
	JCheckBox chkShellfish;
	JCheckBox chkCrab;
	JCheckBox chkPeach;
	JCheckBox chkWalnut;
	JCheckBox chkSquid;
	
	// Construct
	public DbActionUser() {
		// TODO Auto-generated constructor stub
	}
	// 유저 등록
	public DbActionUser(String id, String pw, String name, String telno, String email, JCheckBox chkEggs,
			JCheckBox chkMilk, JCheckBox chkBuckwheat, JCheckBox chkPeanut, JCheckBox chkMackerel, JCheckBox chkPork,
			JCheckBox chkSo2, JCheckBox chkBeef, JCheckBox chkSoybean, JCheckBox chkWheat, JCheckBox chkShrimp,
			JCheckBox chkTomato, JCheckBox chkChicken, JCheckBox chkShellfish, JCheckBox chkCrab, JCheckBox chkPeach,
			JCheckBox chkWalnut, JCheckBox chkSquid) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.telno = telno;
		this.email = email;
		this.chkEggs = chkEggs;
		this.chkMilk = chkMilk;
		this.chkBuckwheat = chkBuckwheat;
		this.chkPeanut = chkPeanut;
		this.chkMackerel = chkMackerel;
		this.chkPork = chkPork;
		this.chkSo2 = chkSo2;
		this.chkBeef = chkBeef;
		this.chkSoybean = chkSoybean;
		this.chkWheat = chkWheat;
		this.chkShrimp = chkShrimp;
		this.chkTomato = chkTomato;
		this.chkChicken = chkChicken;
		this.chkShellfish = chkShellfish;
		this.chkCrab = chkCrab;
		this.chkPeach = chkPeach;
		this.chkWalnut = chkWalnut;
		this.chkSquid = chkSquid;
	}
	// id 체크
	public DbActionUser(String id) {
		super();
		this.id = id;
	}
	// 내정보 수정
	public DbActionUser(String id, String pw, String name, String telno, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.telno = telno;
		this.email = email;
	}
	
	
	
	// Method

	// 유저 등록
	public boolean joinUser() {
		
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into user(id, pw, name, telno, email, allergy)";
			String query1 = " values (?, ?, ?, ?, ?, ?)";
			String allergyChk = "";
			
			if(chkEggs.isSelected() == true || chkMilk.isSelected() == true || chkBuckwheat.isSelected() == true || chkPeanut.isSelected() == true || chkSoybean.isSelected() == true || chkWheat.isSelected() == true || chkMackerel.isSelected() == true || chkCrab.isSelected() == true || chkShrimp.isSelected() == true || chkPork.isSelected() == true || chkPeach.isSelected() == true || chkTomato.isSelected() == true || chkSo2.isSelected() == true || chkWalnut.isSelected() == true || chkChicken.isSelected() == true || chkBeef.isSelected() == true || chkSquid.isSelected() == true || chkShellfish.isSelected() == true) {
				allergyChk = "t";
				// 알러지 있는 회원만 알러지 탭에 저장
				allergyUpdate();
			}else {
				allergyChk = "f";
			}
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, telno);
			ps.setString(5, email);
			ps.setString(6, allergyChk);
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 알레르기 체크하면 userchk에 값 업데이트
	private void allergyUpdate() {
		
		PreparedStatement ps = null;
		DbActionUser dbAction = new DbActionUser();
		ArrayList<BeanUser> beanList = dbAction.allergyCodeList();
		JCheckBox[] chk = {chkEggs, chkMilk, chkBuckwheat, chkPeanut, chkSoybean, chkWheat, chkMackerel, chkCrab, chkShrimp, chkPork, chkPeach, chkTomato, chkSo2, chkWalnut, chkChicken, chkBeef, chkSquid, chkShellfish};
		
		for(int i=0; i<chk.length; i++) {
			if(chk[i].isSelected() == true) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					
					String query = "insert into userchk(u_id, a_code)";
					String query1 = " values (?, ?)";

					ps = conn_mysql.prepareStatement(query + query1);
						
					ps.setString(1, id);
					ps.setString(2, beanList.get(i).getCode());
					ps.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 알러지 코드 리스트 불러오기
	public ArrayList<BeanUser> allergyCodeList() {
		
		ArrayList<BeanUser> beanList = new ArrayList<BeanUser>();
		
		String query = "select code from allergy";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query);

	        while(rs.next()){
	        	// wk에 rs값 저장
	        	String wkACode = rs.getString(1);
	        	// Bean = 한줄, BenaList = 값 전체
	        	// 가져온 값 Bean에 저장
	        	BeanUser bean = new BeanUser(wkACode);
	        	// Bean을 Beanlist에 추가
	        	beanList.add(bean);
	        }
	        conn_mysql.close();
	    }
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    
	    return beanList;
	}
	
	// 아이디 중복 체크
	public int idChk() {
		
		String query = "select EXISTS (select id from user where id = '" + id + "') as success";
		int num = 0;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				if (rs.getInt(1) == 0) {
					num = 0;
				}else {
					num = 1;
				}
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			num = 2;
		}
		return num;
	}
	
	// MyPage 내 정보 불러오기
	public BeanUser myInfo(String id) {
		
		BeanUser beanRestrant = null;
		
		String query = "select name, email, telno from user where id='" + id + "'";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkName = rs.getString(1);
				String wkEmail = rs.getString(2);
				String wkTelno = rs.getString(3);
				
				beanRestrant = new BeanUser(wkName, wkEmail, wkTelno);
			}
			conn_mysql.isClosed();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return beanRestrant;
	}
	
	// MyPage 내 알러지 항목 불러오기
	public ArrayList<BeanUser> myAllergy(String id) {
		
		int num = 0;
		
		ArrayList<BeanUser> beanList = new ArrayList<BeanUser>();
		DbActionUser dbAction = new DbActionUser();
		ArrayList<BeanUser> allergyCodeList = dbAction.allergyCodeList();
		
		for(int i=0; i<allergyCodeList.size(); i++) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
					
				String query ="select EXISTS (select * from userchk where a_code = '" + allergyCodeList.get(i).getCode() + "' and u_id='" + id + "') as success";

				ResultSet rs = stmt_mysql.executeQuery(query);
					
				while(rs.next()) {
					if (rs.getInt(1) == 0) {
						num = 0;
					}else {
						num = 1;
					}
				}
				BeanUser bean = new BeanUser(num);
	        	beanList.add(bean);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return beanList;
	}
	
	// 내정보 수정
	public boolean modifyAction() {
		
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "update user set pw=?, name=?, telno=?, email=?, allergy=? where id='" + id + "'";
			String allergyChk = "";
			
			if(chkEggs.isSelected() == true || chkMilk.isSelected() == true || chkBuckwheat.isSelected() == true || chkPeanut.isSelected() == true || chkSoybean.isSelected() == true || chkWheat.isSelected() == true || chkMackerel.isSelected() == true || chkCrab.isSelected() == true || chkShrimp.isSelected() == true || chkPork.isSelected() == true || chkPeach.isSelected() == true || chkTomato.isSelected() == true || chkSo2.isSelected() == true || chkWalnut.isSelected() == true || chkChicken.isSelected() == true || chkBeef.isSelected() == true || chkSquid.isSelected() == true || chkShellfish.isSelected() == true) {
				allergyChk = "t";
				// 알러지 있는 회원만 알러지 탭에 저장
				allergyDelete();
				allergyUpdate();
			}else {
				allergyChk = "f";
				allergyDelete();
			}
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, pw);
			ps.setString(2, name);
			ps.setString(3, telno);
			ps.setString(4, email);
			ps.setString(5, allergyChk);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 새로운 정보 업데이트를 위해 기존 userchk 삭제
	private void allergyDelete() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from userchk where u_id=?";
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
