package com.javalec.restaurant;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class TestRestaurant {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private JTable Inner_Table_Menu;
	private JLabel lblCountM;
	private JLabel lblNewLabel_4_1;
	private JScrollPane scrollPane_1;
	private JTable Inner_Table_Review;
	private JLabel lblCountR;
	private JLabel lblName;
	private JLabel lblLocation;
	private JLabel lblTelno;
	private JLabel lblStar;
	private JLabel lblMenu;
	private JButton btnReview;
	
	// Table 환경 정의
	// Table에는 Inner와 Outer가 있다. (지금 쓰는건 Inner)
	private final DefaultTableModel Outer_Table_Menu = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_Review = new DefaultTableModel();
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestRestaurant window = new TestRestaurant();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestRestaurant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				allergyChk();
				reviewTableInit();
				reviewTable();
				restaurantInfo();
			}
		});
		frame.setTitle("맛집정보");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblCountM());
		frame.getContentPane().add(getLblNewLabel_4_1());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getLblCountR());
		frame.getContentPane().add(getLblName());
		frame.getContentPane().add(getLblLocation());
		frame.getContentPane().add(getLblTelno());
		frame.getContentPane().add(getLblStar());
		frame.getContentPane().add(getLblMenu());
		frame.getContentPane().add(getBtnReview());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름 : ");
			lblNewLabel.setBounds(20, 48, 34, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("위치 : ");
			lblNewLabel_1.setBounds(20, 80, 34, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호 :");
			lblNewLabel_2.setBounds(20, 108, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("별점 : ");
			lblNewLabel_3.setBounds(20, 136, 34, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("메뉴 : ");
			lblNewLabel_4.setBounds(20, 164, 34, 16);
		}
		return lblNewLabel_4;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 192, 406, 143);
			scrollPane.setViewportView(getInner_Table_Menu());
		}
		return scrollPane;
	}
	private JTable getInner_Table_Menu() {
		if (Inner_Table_Menu == null) {
			Inner_Table_Menu = new JTable();
			Inner_Table_Menu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_Table_Menu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_Menu.setModel(Outer_Table_Menu);
		}
		return Inner_Table_Menu;
	}
	private JLabel getLblCountM() {
		if (lblCountM == null) {
			lblCountM = new JLabel("");
			lblCountM.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCountM.setBounds(365, 164, 61, 16);
		}
		return lblCountM;
	}

	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("리뷰 : ");
			lblNewLabel_4_1.setBounds(20, 347, 61, 16);
		}
		return lblNewLabel_4_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(20, 375, 406, 143);
			scrollPane_1.setViewportView(getInner_Table_Review());
		}
		return scrollPane_1;
	}
	private JTable getInner_Table_Review() {
		if (Inner_Table_Review == null) {
			Inner_Table_Review = new JTable();
			Inner_Table_Review.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_Review.setModel(Outer_Table_Review);
		}
		return Inner_Table_Review;
	}
	private JLabel getLblCountR() {
		if (lblCountR == null) {
			lblCountR = new JLabel("");
			lblCountR.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCountR.setBounds(365, 347, 61, 16);
		}
		return lblCountR;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setBounds(56, 48, 352, 16);
		}
		return lblName;
	}
	private JLabel getLblLocation() {
		if (lblLocation == null) {
			lblLocation = new JLabel("");
			lblLocation.setBounds(56, 80, 352, 16);
		}
		return lblLocation;
	}
	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("");
			lblTelno.setBounds(82, 108, 326, 16);
		}
		return lblTelno;
	}
	private JLabel getLblStar() {
		if (lblStar == null) {
			lblStar = new JLabel("");
			lblStar.setBounds(56, 136, 352, 16);
		}
		return lblStar;
	}
	private JLabel getLblMenu() {
		if (lblMenu == null) {
			lblMenu = new JLabel("");
			lblMenu.setBounds(56, 164, 352, 16);
		}
		return lblMenu;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("Review");
			btnReview.setBounds(309, 530, 117, 29);
		}
		return btnReview;
	}
	
	
	
	
	// 식당 정보 보여주기
	private void restaurantInfo() {
		
		DbActionRestrant dbActionRestrant = new DbActionRestrant();
		
		// restaurant 기본 정보 불러오기
		BeanRestrant beanRestrantInfo = dbActionRestrant.restaurantInfo();
		lblName.setText(beanRestrantInfo.getName());
		lblLocation.setText(beanRestrantInfo.getLocation());
		lblTelno.setText(beanRestrantInfo.getTelno());
		
		// restaurant 평균 별점 불러오기
		String star = dbActionRestrant.restaurantStar();
		lblStar.setText(star);
	}
	
	// 알러지 있나 없나 체크
	private void allergyChk() {
		
//		String query = "select allergy from user where + 유저아이디";
//		
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();	// 선언문
//			
//			ResultSet rs = stmt_mysql.executeQuery(query);	// selet는 executeQuery(query);
//		
//			// 알레르기 있는 사람은 알레르기 보여줌, 알레르기 없는 사람은 알레르기 안보여줌
//			if (rs.getString(1) == "t") {
				allergyTableInit();
				allergyMenuTable();
//			}else {
//				tableInit();
//				table();
//			}
//			conn_mysql.isClosed();
//			
//		}catch(Exception e) {
//			e.printStackTrace();	// 화면에 에러 코드를 보여줘라
//		}
	}
	
	
	// 화면 Menu Table 초기화
	private void allergyTableInit() {
			
		Outer_Table_Menu.addColumn("이름");
		Outer_Table_Menu.addColumn("가격");
		Outer_Table_Menu.addColumn("설명");
		Outer_Table_Menu.addColumn("알레르기");
		Outer_Table_Menu.setColumnCount(4);
			
		// Table 초기화
		int i = Outer_Table_Menu.getRowCount();	// .getRowCount = 가로 줄의 수 == i는 가로 줄 수
		for(int j=0; j<i; j++) {		// i만큼 for문 돌려라 = 가로 줄 수만큼 For문 돌려라 = 가로줄 다 없어질때까지 지워라 = 초기화
			Outer_Table_Menu.removeRow(0);	// 계속 0번을 지워라 - 계속 지울려면 0으로 설정, j아님, j설정 시 모두 지울 수 없음 = 초기화 안됨, 0으로 설정해야 모두 지울 수 있음 = 초기화 가능
		}
		
		// 크기 조절 불가능
		Inner_Table_Menu.setAutoResizeMode(Inner_Table_Menu.AUTO_RESIZE_OFF);
		
		// Table 상단 바 생성 (Outer_Table)
		int vColIndex = 0;
		TableColumn col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
	}
	
	// Menu Table값 불러오기
	private void allergyMenuTable() {
		
		
		DbActionRestrant dbActionRestrant = new DbActionRestrant();
        // selectList를 어Bean으로 저장
        ArrayList<BeanRestrant> beanList = dbActionRestrant.allergyMenuTable();
        
        for(int i=0; i<beanList.size(); i++) {
        	String[] qTxt = {beanList.get(i).getName(), beanList.get(i).getPrice(), beanList.get(i).getContent(), beanList.get(i).getAllergy()};
        	// 만든 배열을 Outer_Table에 추가
        	Outer_Table_Menu.addRow(qTxt);
        }
        
        lblCountM.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// Menu 테이블 클릭 시 알레르기 항목 보여주기
	private void tableClick() {	
		
		DbActionRestrant dbAction = new DbActionRestrant();
		
		int i = Inner_Table_Menu.getSelectedRow();					// i = 선택한 inner테이블이 몇번째 줄인지
		String wkName = (String) Inner_Table_Menu.getValueAt(i, 0);	// wkName = i번째 inner테이블의 0번째 값 = i번째 메뉴 이름
		
		ArrayList<BeanRestrant> beanList = dbAction.AllergyList(wkName);
		ArrayList<String> allergyName = new ArrayList<String>();
		
		for(int j=0; j<beanList.size(); j++) {
        	allergyName.add(beanList.get(j).getName());
        }
		
		if (allergyName.size() == 0) {
			JOptionPane.showMessageDialog(null, "회원님의 " + wkName + " 알레르기 유발 재료는 없습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "회원님의 " + wkName + " 알레르기 유발 재료는 " + allergyName + "입니다.");			
		}
			
	}
	
	// 화면 Table 초기화
	private void tableInit() {
			
//		Outer_Table.addColumn("이름");
//		Outer_Table.addColumn("가격");
//		Outer_Table.addColumn("설명");
//		Outer_Table.setColumnCount(3);
//			
//		// Table 초기화
//		int i = Outer_Table.getRowCount();	// .getRowCount = 가로 줄의 수 == i는 가로 줄 수
//		for(int j=0; j<i; j++) {		// i만큼 for문 돌려라 = 가로 줄 수만큼 For문 돌려라 = 가로줄 다 없어질때까지 지워라 = 초기화
//			Outer_Table.removeRow(0);	// 계속 0번을 지워라 - 계속 지울려면 0으로 설정, j아님, j설정 시 모두 지울 수 없음 = 초기화 안됨, 0으로 설정해야 모두 지울 수 있음 = 초기화 가능
//		}
//		
//		// 크기 조절 불가능
//		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
//		
//		// Table 상단 바 생성 (Outer_Table)
//		int vColIndex = 0;
//		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
//		int width = 100;
//		col.setPreferredWidth(width);
//		
//		vColIndex = 1;
//		col = Inner_Table.getColumnModel().getColumn(vColIndex);
//		width = 50;
//		col.setPreferredWidth(width);
//		
//		vColIndex = 2;
//		col = Inner_Table.getColumnModel().getColumn(vColIndex);
//		width = 300;
//		col.setPreferredWidth(width);
	}
	
	// Table값 불러오기
	private void table() {
		
		// sql문장과 같음 - 선택(select) 검색키워드(seqno, name, telno, relation) from table이름(userinfo)
//		String query = "select m_name, m_price, m_content from menu";
//		int dataCount = 0;	// 몇명인지 세는 변수 선언
//		
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();	// 선언문
//			
//			ResultSet rs = stmt_mysql.executeQuery(query);
//			
//			while(rs.next()) {				// rs.next() = boolean
//				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3)};	// 4개 불러옴 (번호, 이름, 전화번호, 관계)
//				Outer_Table.addRow(qTxt);	// 테이블에 저장
//				dataCount++;				// while문 몇번 돌았는지 세어저 전체 data가 몇개인지 알 수 있다.
//			}
//			conn_mysql.isClosed();
//			lblCount.setText(Integer.toString(dataCount));	// Count 만큼 tfCount에 보여줘라
//			
//		}catch(Exception e) {
//			e.printStackTrace();	// 화면에 에러 코드를 보여줘라
//		}	
	}
	
	
	
	// -------------------------review---------------------------
	
	// 화면 Menu Table 초기화
	private void reviewTableInit() {
			
		Outer_Table_Review.addColumn("날짜");
		Outer_Table_Review.addColumn("아이디");
		Outer_Table_Review.addColumn("별");
		Outer_Table_Review.addColumn("메뉴");
		Outer_Table_Review.addColumn("내용");
		Outer_Table_Review.setColumnCount(5);
			
		// Table 초기화
		int i = Outer_Table_Review.getRowCount();	// .getRowCount = 가로 줄의 수 == i는 가로 줄 수
		for(int j=0; j<i; j++) {		// i만큼 for문 돌려라 = 가로 줄 수만큼 For문 돌려라 = 가로줄 다 없어질때까지 지워라 = 초기화
			Outer_Table_Review.removeRow(0);	// 계속 0번을 지워라 - 계속 지울려면 0으로 설정, j아님, j설정 시 모두 지울 수 없음 = 초기화 안됨, 0으로 설정해야 모두 지울 수 있음 = 초기화 가능
		}
		
		// 크기 조절 불가능
		Inner_Table_Review.setAutoResizeMode(Inner_Table_Review.AUTO_RESIZE_OFF);
		
		// Table 상단 바 생성 (Outer_Table)
		int vColIndex = 0;
		TableColumn col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 300;
		col.setPreferredWidth(width);
	}
	
	// Review Table값 불러오기
	private void reviewTable() {
		
		DbActionRestrant dbActionRestrant = new DbActionRestrant();
        // selectList를 어Bean으로 저장
        ArrayList<BeanRestrant> beanList = dbActionRestrant.reviewTable();
        
        for(int i=0; i<beanList.size(); i++) {
        	String[] qTxt = {beanList.get(i).getDate(), beanList.get(i).getU_id(), beanList.get(i).getStar(), beanList.get(i).getMenu(), beanList.get(i).getContent()};
        	// 만든 배열을 Outer_Table에 추가
        	Outer_Table_Review.addRow(qTxt);
        }

        lblCountR.setText(Integer.toString(beanList.size()) + "개");
	}
}
