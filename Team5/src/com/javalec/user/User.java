package com.javalec.user;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.login_JP.Log_in_User;
import com.javalec.restaurant_user.BeanRestaurant_User;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class User {

	public JFrame frame;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JTextField tfName;
	private JTextField tfTelno;
	private JTextField tfEmail;
	private JButton btnOK;
	private JCheckBox chkEggs;
	private JCheckBox chkMilk;
	private JCheckBox chkBuckwheat;
	private JCheckBox chkPeanut;
	private JCheckBox chkMackerel;
	private JCheckBox chkPork;
	private JCheckBox chkSo2;
	private JCheckBox chkBeef;
	private JCheckBox chkSoybean;
	private JCheckBox chkWheat;
	private JCheckBox chkShrimp;
	private JCheckBox chkTomato;
	private JCheckBox chkChicken;
	private JCheckBox chkShellfish;
	private JCheckBox chkCrab;
	private JCheckBox chkPeach;
	private JCheckBox chkWalnut;
	private JCheckBox chkSquid;
	private JPasswordField tfPwChk;
	private JLabel lblNewLabel;
	private JButton btnIdChk;
	private JLabel lblPwChk;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JButton btnCancel;
	private JLabel lblNewLabel_1_1_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
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
	public User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 366, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfPw());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getChkEggs());
		frame.getContentPane().add(getChkMilk());
		frame.getContentPane().add(getChkBuckwheat());
		frame.getContentPane().add(getChkPeanut());
		frame.getContentPane().add(getChkMackerel());
		frame.getContentPane().add(getChkPork());
		frame.getContentPane().add(getChkSo2());
		frame.getContentPane().add(getChkBeef());
		frame.getContentPane().add(getChkSoybean());
		frame.getContentPane().add(getChkWheat());
		frame.getContentPane().add(getChkShrimp());
		frame.getContentPane().add(getChkTomato());
		frame.getContentPane().add(getChkChicken());
		frame.getContentPane().add(getChkShellfish());
		frame.getContentPane().add(getChkCrab());
		frame.getContentPane().add(getChkPeach());
		frame.getContentPane().add(getChkWalnut());
		frame.getContentPane().add(getChkSquid());
		frame.getContentPane().add(getTfPwChk());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnIdChk());
		frame.getContentPane().add(getLblPwChk());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1_1());
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(80, 63, 150, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(80, 101, 150, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JPasswordField getTfPw() {
		if (tfPw == null) {
			tfPw = new JPasswordField();
			tfPw.setBounds(110, 139, 229, 26);
			tfPw.setColumns(10);
		}
		return tfPw;
	}
	private JPasswordField getTfPwChk() {
		if (tfPwChk == null) {
			tfPwChk = new JPasswordField();
			tfPwChk.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					pwChk();
					
				}
			});
			tfPwChk.setColumns(10);
			tfPwChk.setBounds(110, 177, 229, 26);
		}
		return tfPwChk;
	}
	private JLabel getLblPwChk() {
		if (lblPwChk == null) {
			lblPwChk = new JLabel("");
			lblPwChk.setBounds(110, 201, 218, 16);
		}
		return lblPwChk;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(80, 253, 259, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(80, 215, 259, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JCheckBox getChkEggs() {
		if (chkEggs == null) {
			chkEggs = new JCheckBox("eggs");
			chkEggs.setBounds(24, 326, 67, 23);
		}
		return chkEggs;
	}
	private JCheckBox getChkMilk() {
		if (chkMilk == null) {
			chkMilk = new JCheckBox("milk");
			chkMilk.setBounds(134, 326, 67, 23);
		}
		return chkMilk;
	}
	private JCheckBox getChkBuckwheat() {
		if (chkBuckwheat == null) {
			chkBuckwheat = new JCheckBox("buckwheat");
			chkBuckwheat.setBounds(232, 326, 107, 23);
		}
		return chkBuckwheat;
	}
	private JCheckBox getChkPeanut() {
		if (chkPeanut == null) {
			chkPeanut = new JCheckBox("peanut");
			chkPeanut.setBounds(24, 359, 80, 23);
		}
		return chkPeanut;
	}
	private JCheckBox getChkMackerel() {
		if (chkMackerel == null) {
			chkMackerel = new JCheckBox("mackerel");
			chkMackerel.setBounds(24, 394, 98, 23);
		}
		return chkMackerel;
	}
	private JCheckBox getChkPork() {
		if (chkPork == null) {
			chkPork = new JCheckBox("pork");
			chkPork.setBounds(24, 429, 80, 23);
		}
		return chkPork;
	}
	private JCheckBox getChkSo2() {
		if (chkSo2 == null) {
			chkSo2 = new JCheckBox("so2");
			chkSo2.setBounds(24, 464, 80, 23);
		}
		return chkSo2;
	}
	private JCheckBox getChkBeef() {
		if (chkBeef == null) {
			chkBeef = new JCheckBox("beef");
			chkBeef.setBounds(24, 499, 80, 23);
		}
		return chkBeef;
	}
	private JCheckBox getChkSoybean() {
		if (chkSoybean == null) {
			chkSoybean = new JCheckBox("soybean");
			chkSoybean.setBounds(134, 359, 86, 23);
		}
		return chkSoybean;
	}
	private JCheckBox getChkWheat() {
		if (chkWheat == null) {
			chkWheat = new JCheckBox("wheat");
			chkWheat.setBounds(232, 359, 107, 23);
		}
		return chkWheat;
	}
	private JCheckBox getChkShrimp() {
		if (chkShrimp == null) {
			chkShrimp = new JCheckBox("shrimp");
			chkShrimp.setBounds(232, 394, 107, 23);
		}
		return chkShrimp;
	}
	private JCheckBox getChkTomato() {
		if (chkTomato == null) {
			chkTomato = new JCheckBox("tomato");
			chkTomato.setBounds(232, 429, 107, 23);
		}
		return chkTomato;
	}
	private JCheckBox getChkChicken() {
		if (chkChicken == null) {
			chkChicken = new JCheckBox("chicken");
			chkChicken.setBounds(232, 464, 107, 23);
		}
		return chkChicken;
	}
	private JCheckBox getChkShellfish() {
		if (chkShellfish == null) {
			chkShellfish = new JCheckBox("shellfish");
			chkShellfish.setBounds(232, 499, 107, 23);
		}
		return chkShellfish;
	}
	private JCheckBox getChkCrab() {
		if (chkCrab == null) {
			chkCrab = new JCheckBox("crab");
			chkCrab.setBounds(134, 394, 67, 23);
		}
		return chkCrab;
	}
	private JCheckBox getChkPeach() {
		if (chkPeach == null) {
			chkPeach = new JCheckBox("peach");
			chkPeach.setBounds(134, 429, 86, 23);
		}
		return chkPeach;
	}
	private JCheckBox getChkWalnut() {
		if (chkWalnut == null) {
			chkWalnut = new JCheckBox("walnut");
			chkWalnut.setBounds(134, 464, 78, 23);
		}
		return chkWalnut;
	}
	private JCheckBox getChkSquid() {
		if (chkSquid == null) {
			chkSquid = new JCheckBox("squid");
			chkSquid.setBounds(134, 499, 67, 23);
		}
		return chkSquid;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(132, 19, 98, 26);
		}
		return lblNewLabel;
	}
	private JButton getBtnIdChk() {
		if (btnIdChk == null) {
			btnIdChk = new JButton("아이디 중복체크");
			btnIdChk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertIdCheck();
					if(i_chk == 0){
						idChk();
					}else {
						JOptionPane.showMessageDialog(frame, "Id를 입력하세요!",
								"ID 입력", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnIdChk.setBounds(232, 101, 107, 29);
		}
		return btnIdChk;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						// pw
						char[] str1 = tfPw.getPassword();
						String pw = new String(str1);
						
						// pwChk
						char[] str2 = tfPwChk.getPassword();
						String pwChk = new String(str2);
						
						if(pw.equals(pwChk)) {
							join();
							frame.setVisible(false);
							Log_in_User log_in_User = new Log_in_User();
							log_in_User.frame.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(frame, "비밀번호를 다시 확인해주세요.");
						}
					}else {
						JOptionPane.showMessageDialog(frame, "사용자 정보를 모두 입력하세요!",
								"사용자 정보 입력", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnOK.setBounds(222, 534, 117, 29);
		}
		return btnOK;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setBounds(24, 68, 37, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("아이디 :");
			lblNewLabel_1_1.setBounds(24, 106, 50, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호 :");
			lblNewLabel_2.setBounds(24, 144, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 확인 :");
			lblNewLabel_3.setBounds(24, 182, 80, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("이메일 :");
			lblNewLabel_1_1_1.setBounds(24, 220, 50, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("전화번호 :");
			lblNewLabel_1_1_1_1.setBounds(24, 258, 67, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Log_in_User log_in_User = new Log_in_User();
					log_in_User.frame.setVisible(true);
				}
			});
			btnCancel.setBounds(93, 534, 117, 29);
		}
		return btnCancel;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("알러지 :");
			lblNewLabel_1_1_1_1_1.setBounds(24, 298, 67, 16);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	
	
	
	
	
	
	// 회원가입
	private void join() {
		
		String id = tfId.getText().trim();
		char[] str1 = tfPw.getPassword();
		String pw = new String(str1);
		String name = tfName.getText().trim();
		String telno = tfTelno.getText().trim();
		String email = tfEmail.getText().trim();
		
		DbActionUser dbActionUser = new DbActionUser(id, pw, name, telno, email, chkEggs, chkMilk, chkBuckwheat, chkPeanut, chkSoybean, chkWheat, chkMackerel, chkCrab, chkShrimp, chkPork, chkPeach, chkTomato, chkSo2, chkWalnut, chkChicken, chkBeef, chkSquid, chkShellfish);
		boolean msg = dbActionUser.joinUser();
		
		if(msg == true) {
			JOptionPane.showMessageDialog(frame, tfName.getText() + "님 회원가입이 완료되었습니다!",
	                "등록 완료!", 
	                JOptionPane.INFORMATION_MESSAGE);   
		}else {
			JOptionPane.showMessageDialog(frame, tfName.getText() + "님의 회원가입에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
	                "Critical Error!", 
	                JOptionPane.ERROR_MESSAGE);
		}

	}
	
	// 값을 다 썼나 체크
	private int insertFieldCheck(){
		// pw
		char[] str1 = tfPw.getPassword();
		String pw = new String(str1);
		
		// pwChk
		char[] str2 = tfPwChk.getPassword();
		String pwChk = new String(str2);
		
		int i = 0;
		if(pw.length() == 0){
			i++;
			tfPw.requestFocus();
		}
		if(pwChk.length() == 0){
			i++;
			tfPwChk.requestFocus();
		}
		if(tfName.getText().length() == 0){
			i++;
			tfName.requestFocus();
		}
		if(tfTelno.getText().length() == 0){
			i++;
			tfTelno.requestFocus();
		}
		if(tfEmail.getText().length() == 0){
			i++;
			tfEmail.requestFocus();
		}
		return i;
	}
	
	// id 값 넣었나 확인
	private int insertIdCheck(){
		int i = 0;
		if(tfId.getText().length() == 0){
			i++;
			tfId.requestFocus();
		}
		return i;
	}
	
	// 아이디 중복 체크
	private void idChk() {
		
		String id = tfId.getText().trim();
		
		DbActionUser dbActionUser = new DbActionUser(id);			
		int msg = dbActionUser.idChk();
		
		if(msg == 0) {
			JOptionPane.showMessageDialog(frame, tfId.getText() + "는 사용 가능한 아이디입니다",
					"아이디 중복 확인", 
					JOptionPane.INFORMATION_MESSAGE);
		}else if(msg == 1) {
			JOptionPane.showMessageDialog(frame, tfId.getText() + "는 이미 사용된 아이디입니다",
					"아이디 중복 확인", 
					JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(frame, "아이디 중복 체크에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
					"Critical Error!", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// 비밀번호 체크
	private void pwChk() {
		// pw
		char[] str1 = tfPw.getPassword();
		String pw = new String(str1);
		
		// pwChk
		char[] str2 = tfPwChk.getPassword();
		String pwChk = new String(str2);
		
		if(pw.equals(pwChk)) {
			lblPwChk.setText("비밀번호가 확인되었습니다.");
			lblPwChk.setForeground(Color.black);
		}else {
			lblPwChk.setText("비밀번호가 일치하지않습니다.");
			lblPwChk.setForeground(Color.red);
		}
	}
	
}
