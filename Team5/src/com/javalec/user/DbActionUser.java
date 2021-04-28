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
	
	// Construct
	public DbActionUser() {
		// TODO Auto-generated constructor stub
	}
	// 유저 등록
	public DbActionUser(String id, String pw, String name, String telno, String email, JCheckBox chkEggs,
			JCheckBox chkMilk, JCheckBox chkBuckwheat, JCheckBox chkPeanut) {
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
			
			if(chkEggs.isSelected() == true || chkMilk.isSelected() == true || chkBuckwheat.isSelected() == true || chkPeanut.isSelected() == true) {
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
		JCheckBox[] chk = {chkEggs, chkMilk, chkBuckwheat, chkPeanut};
		
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
					JOptionPane.showMessageDialog(null, "알레르기 성공!");
					
				}catch(Exception e) {
					e.printStackTrace();
					
					// 알레르기 테스트
					JOptionPane.showMessageDialog(null, "알레르기 실패!");
				}
			}
		}
	}
}
