package com.javalec.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;


public class DbActionMenu {

	// Field
	private final String url_mysql = ShareVariable.url_mysql;
	private final String id_mysql = ShareVariable.id_mysql;
	private final String pw_mysql = ShareVariable.pw_mysql;	
	
	String code;
	String name;
	String price;
	String content;
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
	public DbActionMenu() {
		// TODO Auto-generated constructor stub
	}
	// 메뉴 등록
	public DbActionMenu(String name, String price, String content, JCheckBox chkEggs, JCheckBox chkMilk,
			JCheckBox chkBuckwheat, JCheckBox chkPeanut, JCheckBox chkMackerel, JCheckBox chkPork, JCheckBox chkSo2,
			JCheckBox chkBeef, JCheckBox chkSoybean, JCheckBox chkWheat, JCheckBox chkShrimp, JCheckBox chkTomato,
			JCheckBox chkChicken, JCheckBox chkShellfish, JCheckBox chkCrab, JCheckBox chkPeach, JCheckBox chkWalnut,
			JCheckBox chkSquid) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
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

	// Method
	
	// 메뉴 등록
	public boolean registerMenu(String wkNum) {
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into menu(r_code, name, price, content, allergy)";
			String query1 = " values (?, ?, ?, ?, ?)";
			String allergyChk = "";
			
			if(chkEggs.isSelected() == true || chkMilk.isSelected() == true || chkBuckwheat.isSelected() == true || chkPeanut.isSelected() == true || chkSoybean.isSelected() == true || chkWheat.isSelected() == true || chkMackerel.isSelected() == true || chkCrab.isSelected() == true || chkShrimp.isSelected() == true || chkPork.isSelected() == true || chkPeach.isSelected() == true || chkTomato.isSelected() == true || chkSo2.isSelected() == true || chkWalnut.isSelected() == true || chkChicken.isSelected() == true || chkBeef.isSelected() == true || chkSquid.isSelected() == true || chkShellfish.isSelected() == true) {
				allergyChk = "t";
				// 알러지 있는 회원만 알러지 탭에 저장
				allergyUpdate(wkNum);
			}else {
				allergyChk = "f";
			}
			
			ps = conn_mysql.prepareStatement(query + query1);
			
			ps.setString(1, wkNum);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, content);
			ps.setString(5, allergyChk);
			ps.executeUpdate();
			
			// m_code 업데이트
			mcodeUpdate();
			
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	// 알레르기 체크하면 menuchk에 값 업데이트
	private void allergyUpdate(String wkNum) {
		
		PreparedStatement ps = null;
		
		// 알러지 코드 불러오기
		DbActionMenu dbAction = new DbActionMenu();
		
		ArrayList<BeanMenu> beanList = dbAction.allergyCodeList();
		
		JCheckBox[] chk = {chkEggs, chkMilk, chkBuckwheat, chkPeanut, chkSoybean, chkWheat, chkMackerel, chkCrab, chkShrimp, chkPork, chkPeach, chkTomato, chkSo2, chkWalnut, chkChicken, chkBeef, chkSquid, chkShellfish};
		
		for(int i=0; i<chk.length; i++) {
			if(chk[i].isSelected() == true) {
				// menuchk 업데이트
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					
					String query = "insert into menuchk(r_code, m_name, a_code)";
					String query1 = " values (?, ?, ?)";
					
					ps = conn_mysql.prepareStatement(query + query1);
					
					ps.setString(1, wkNum);
					ps.setString(2, name);
					ps.setString(3, beanList.get(i).getCode());
					ps.executeUpdate();
					// 알레르기 테스트
//					JOptionPane.showMessageDialog(null, "알레르기 성공!");
				}catch(Exception e) {
					e.printStackTrace();
					// 알레르기 테스트
//					JOptionPane.showMessageDialog(null, "알레르기 실패!");
				}
			}
		}
	}
	
	// 알러지 코드 리스트 불러오기
	public ArrayList<BeanMenu> allergyCodeList() {
		
		ArrayList<BeanMenu> beanList = new ArrayList<BeanMenu>();
		
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
	        	BeanMenu bean = new BeanMenu(wkACode);
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
	
	// m_code 업데이트
	private void mcodeUpdate() {
		
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "update menuchk as mc, menu as m set mc.m_code = m.code where mc.m_name = m.name and mc.r_code = m.r_code";
			ps = conn_mysql.prepareStatement(query);
			ps.executeUpdate();
			// 알레르기 테스트
//			JOptionPane.showMessageDialog(null, "m_code 성공!");
		}catch(Exception e) {
			e.printStackTrace();
			// 알레르기 테스트
//			JOptionPane.showMessageDialog(null, "m_code 실패!");
		}
	}
	
	// 메뉴 삭제
	public boolean deleteMenuAction(String wkNum) {
		
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from menu where code=?";
			
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, wkNum);
			ps.executeUpdate();
			
			deleteMenuChkAction(wkNum);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 메뉴Chk 삭제
	private void deleteMenuChkAction(String wkNum) {
		
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "delete from menuchk where m_code=?";
			
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, wkNum);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
