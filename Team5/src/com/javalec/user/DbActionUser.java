package com.javalec.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.javalec.base.ShareVariable;
import com.javalec.menu.BeanMenu;
import com.javalec.menu.DbActionMenu;

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
		DbActionMenu dbAction = new DbActionMenu();
		ArrayList<BeanMenu> beanList = dbAction.allergyCodeList();
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
}
