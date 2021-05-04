package com.javalec.owner;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.restaurant_owner.SearchRestaurant_Owner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyPage_Restaurant {

	public JFrame frame;
	private JPasswordField tfPw;
	private JTextField tfName;
	private JTextField tfTelno;
	private JTextField tfEmail;
	private JButton btnModify;
	private JPasswordField tfPwChk;
	private JLabel lblNewLabel;
	private JLabel lblPwChk;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JButton btnBack;
	private JButton btnCancelModify;
	private JButton btnOK;

	String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage_Restaurant window = new MyPage_Restaurant();
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
	public MyPage_Restaurant() {
		initialize();
	}
	public MyPage_Restaurant(String id) {
		this.id = id;
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
				myInfo();
			}
		} );
		frame.setTitle("MyPage");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 366, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfPw());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getBtnModify());
		frame.getContentPane().add(getTfPwChk());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblPwChk());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getBtnBack());
		frame.getContentPane().add(getBtnCancelModify());
		frame.getContentPane().add(getBtnOK());
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(80, 63, 150, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JPasswordField getTfPw() {
		if (tfPw == null) {
			tfPw = new JPasswordField();
			tfPw.setBounds(110, 101, 229, 26);
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
			tfPwChk.setBounds(110, 139, 229, 26);
		}
		return tfPwChk;
	}
	private JLabel getLblPwChk() {
		if (lblPwChk == null) {
			lblPwChk = new JLabel("");
			lblPwChk.setBounds(110, 163, 218, 16);
		}
		return lblPwChk;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(80, 215, 259, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(80, 177, 259, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("내 정보");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(5, 19, 355, 26);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setBounds(24, 68, 37, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호 :");
			lblNewLabel_2.setBounds(24, 106, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 확인 :");
			lblNewLabel_3.setBounds(24, 144, 80, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("이메일 :");
			lblNewLabel_1_1_1.setBounds(24, 182, 50, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("전화번호 :");
			lblNewLabel_1_1_1_1.setBounds(24, 220, 67, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					SearchRestaurant_Owner searchRestaurant_Owner = new SearchRestaurant_Owner(id);
					searchRestaurant_Owner.frame.setVisible(true);
				}
			});
			btnBack.setBounds(6, 6, 61, 29);
		}
		return btnBack;
	}
	private JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modifyInfo();
				}
			});
			btnModify.setBounds(222, 253, 117, 29);
		}
		return btnModify;
	}
	private JButton getBtnCancelModify() {
		if (btnCancelModify == null) {
			btnCancelModify = new JButton("취소");
			btnCancelModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myInfo();
				}
			});
			btnCancelModify.setBounds(93, 253, 117, 29);
		}
		return btnCancelModify;
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
							modifyInfoAction();
							myInfo();
							
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
			btnOK.setBounds(222, 253, 117, 29);
		}
		return btnOK;
	}
	
	
	
	
	// 회원 정보 보여주기
	private void myInfo() {
		
		tfPw.setText("");
		tfPwChk.setText("");
		lblPwChk.setText("");
		
		btnOK.setVisible(false);
		btnCancelModify.setVisible(false);
		btnModify.setVisible(true);
		btnBack.setVisible(true);
		
		tfName.setEditable(false);
		tfPw.setEditable(false);
		tfPwChk.setEditable(false);
		tfEmail.setEditable(false);
		tfTelno.setEditable(false);
		
		DbActionJoin_HJ actionJoin_HJ = new DbActionJoin_HJ(id);
		
		// restaurant 기본 정보 불러오기
		BeanRestaurant beanRestrant = actionJoin_HJ.myInfo();
		
		tfName.setText(beanRestrant.getName());
		tfEmail.setText(beanRestrant.getEmail());
		tfTelno.setText(beanRestrant.getTelno());
		
	}
	
	// 정보 수정
	private void modifyInfo() {
		
		btnOK.setVisible(true);
		btnCancelModify.setVisible(true);
		btnModify.setVisible(false);
		btnBack.setVisible(false);
		
		tfName.setEditable(true);
		tfPw.setEditable(true);
		tfPwChk.setEditable(true);
		tfEmail.setEditable(true);
		tfTelno.setEditable(true);
	}
	
	// db에 정보 수정 업데이트
	private void modifyInfoAction() {
		
		char[] str1 = tfPw.getPassword();
		String pw = new String(str1);
		String name = tfName.getText().trim();
		String telno = tfTelno.getText().trim();
		String email = tfEmail.getText().trim();
		
		DbActionJoin_HJ dbActionJoin_HJ = new DbActionJoin_HJ(id, pw, name, telno, email);
		
		boolean msg = dbActionJoin_HJ.modifyAction();
		
		if (msg == true) {
			JOptionPane.showMessageDialog(frame, "정보 수정이 완료되었습니다!",
                  "입력 완료!", 
                  JOptionPane.INFORMATION_MESSAGE);  
		}else {
			JOptionPane.showMessageDialog(frame, "정보 수정에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
                  "Critical Error!", 
                  JOptionPane.ERROR_MESSAGE);    
		}
	}
	
	// 값을 다 썼나 체크
	private int insertFieldCheck(){
		
		char[] str1 = tfPw.getPassword();
		String pw = new String(str1);
		
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
