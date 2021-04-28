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
	
	// Construct
	public DbActionMenu() {
		// TODO Auto-generated constructor stub
	}
	// 메뉴 등록
	public DbActionMenu(String name, String price, String content, JCheckBox chkEggs, JCheckBox chkMilk,
			JCheckBox chkBuckwheat, JCheckBox chkPeanut) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
		this.chkEggs = chkEggs;
		this.chkMilk = chkMilk;
		this.chkBuckwheat = chkBuckwheat;
		this.chkPeanut = chkPeanut;
	}

	// Method
	
	// 메뉴 등록
	public boolean registerMenu() {
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			
			String query = "insert into menu(r_code, name, price, content, allergy)";
			String query1 = " values (?, ?, ?, ?, ?)";
			String allergyChk = "";
			
			if(chkEggs.isSelected() == true || chkMilk.isSelected() == true || chkBuckwheat.isSelected() == true || chkPeanut.isSelected() == true) {
				allergyChk = "t";
				// 알러지 있는 회원만 알러지 탭에 저장
				allergyUpdate();
			}else {
				allergyChk = "f";
			}
			
			ps = conn_mysql.prepareStatement(query + query1);
			// id 값 사용자 id로 지정
			ps.setString(1, "1");
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
	private void allergyUpdate() {
		
		PreparedStatement ps = null;
		
		// 알러지 코드 불러오기
		DbActionMenu dbAction = new DbActionMenu();
		
		ArrayList<BeanMenu> beanList = dbAction.allergyCodeList();
		
		JCheckBox[] chk = {chkEggs, chkMilk, chkBuckwheat, chkPeanut};
		
		for(int i=0; i<chk.length; i++) {
			if(chk[i].isSelected() == true) {
				// menuchk 업데이트
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					
					String query = "insert into menuchk(r_code, m_name, a_code)";
					String query1 = " values (?, ?, ?)";
					
					ps = conn_mysql.prepareStatement(query + query1);
					
					ps.setString(1, "1");	// r_code를 해당 식당의 코드로
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
}
