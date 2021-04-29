package com.javalec.review;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.restaurant.TestRestaurant;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TestReview {

	public JFrame frame;
	private JComboBox cbStar;
	private JTextArea taContent;
	private JButton btnOK;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfMenu;
	
	String wkNum;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestReview window = new TestReview();
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
	public TestReview() {
		initialize();
	}
	public TestReview(String wkNum) {
		this.wkNum = wkNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbStar());
		frame.getContentPane().add(getTaContent());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfMenu());
	}
	private JComboBox getCbStar() {
		if (cbStar == null) {
			cbStar = new JComboBox();
			cbStar.setModel(new DefaultComboBoxModel(new String[] {"별", "별별", "별별별", "별별별별", "별별별별별"}));
			cbStar.setBounds(30, 20, 139, 27);
		}
		return cbStar;
	}
	private JTextArea getTaContent() {
		if (taContent == null) {
			taContent = new JTextArea();
			taContent.setBounds(30, 124, 397, 120);
		}
		return taContent;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						register();
						frame.setVisible(false);
						TestRestaurant testRestaurant = new TestRestaurant();
						testRestaurant.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "리뷰항목을 모두 입력하세요!",
								"리뷰 입력", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnOK.setBounds(30, 354, 117, 29);
		}
		return btnOK;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("리뷰");
			lblNewLabel.setBounds(30, 98, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("영수증");
			lblNewLabel_1.setBounds(30, 257, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("메뉴 :");
			lblNewLabel_2.setBounds(28, 64, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfMenu() {
		if (tfMenu == null) {
			tfMenu = new JTextField();
			tfMenu.setBounds(68, 60, 356, 26);
			tfMenu.setColumns(10);
		}
		return tfMenu;
	}
	
	// 콤보박스 선택한 것 등록할 정보 판단 후 등록
	private void register() {
		
		PreparedStatement ps = null;
		
		int i = cbStar.getSelectedIndex();	// 콤보를 몇번째를 선택했니?
		String star = "";
		
		switch(i) {
			case 0:
				star = "별";
				break;
			case 1:
				star = "별별";
				break;
			case 2:
				star = "별별별";
				break;
			case 3:
				star = "별별별별";
				break;
			case 4:
				star = "별별별별별";
				break;
			default:
				break;
		}
		registerAction(star);
	}
	
	// 리뷰 등로 액션
	private void registerAction(String star) {
		
		String u_id = "Carry";	// 해당 유저로 설정
		String r_code = wkNum;	// 선택한 식당 코드로 설정
		String menu = tfMenu.getText().trim();
		String content = taContent.getText().trim();
		
		DbActionReview dbActionReview = new DbActionReview(u_id, r_code, menu, content);
		
		boolean msg = dbActionReview.registerAction(star);
		
		if (msg == true) {
			JOptionPane.showMessageDialog(null, "리뷰 등록이 완료되었습니다!",
                  "입력 완료!", 
                  JOptionPane.INFORMATION_MESSAGE);  
		}else {
			JOptionPane.showMessageDialog(null, "리뷰 등록에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
                  "Critical Error!", 
                  JOptionPane.ERROR_MESSAGE);    
		}          
	}
	// 값을 다 썼나 체크
	private int insertFieldCheck(){
		int i = 0;
		if(tfMenu.getText().length() == 0){
			i++;
			tfMenu.requestFocus();
		}
		if(taContent.getText().length() == 0){
			i++;
			taContent.requestFocus();
		}	
		return i;
	}
	
	
}
