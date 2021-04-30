package com.javalec.R_joinmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.javalec.R_Joinfunction.DbActionRjoin;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Rjoin {
	
		private JFrame frame;
		private JTextField tfName;
		private JTextField tfEmail;
		private JPasswordField pwtfpw2;
		private JPasswordField pwtfpw;
		private JTextField tfId;
		private JButton btnId;
		private JButton btnNewButton;
		private JLabel lblNewLabel_2_5;
		private JLabel lblNewLabel_2;
		private JLabel lblNewLabel_2_1;
		private JLabel lblNewLabel_2_2;
		private JLabel lblNewLabel_2_2_1;
		private JLabel lblNewLabel_1;
		private JLabel lblNewLabel;
		private JLabel lblpw;
		JPasswordField pwtfPw;
		private JLabel lblNewLabel_2_2_1_1;
		private JTextField tfTelno;
		
	
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Rjoin window = new Rjoin();
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
		public Rjoin() {
			initialize();
		}
	
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setBounds(100, 100, 450, 455);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(getTfName());
			frame.getContentPane().add(getTfEmail());
			frame.getContentPane().add(getPwtfpw2());
			frame.getContentPane().add(getPwtfpw());
			frame.getContentPane().add(getTfId());
			frame.getContentPane().add(getBtnId());
			frame.getContentPane().add(getBtnNewButton());
			frame.getContentPane().add(getLblNewLabel_2_5());
			frame.getContentPane().add(getLblNewLabel_2());
			frame.getContentPane().add(getLblNewLabel_2_1());
			frame.getContentPane().add(getLblNewLabel_2_2());
			frame.getContentPane().add(getLblNewLabel_2_2_1());
			frame.getContentPane().add(getLblNewLabel_1());
			frame.getContentPane().add(getLblNewLabel());
			frame.getContentPane().add(getLblpw());
			frame.getContentPane().add(getLblNewLabel_2_2_1_1());
			frame.getContentPane().add(getTfTelno());
		}
	
		private JTextField getTfName() {
			if (tfName == null) {
				tfName = new JTextField();
				tfName.setColumns(10);
				tfName.setBounds(106, 90, 215, 21);
			}
			return tfName;
		}
		private JTextField getTfEmail() {
			if (tfEmail == null) {
				tfEmail = new JTextField();
				tfEmail.setColumns(10);
				tfEmail.setBounds(106, 304, 215, 21);
			}
			return tfEmail;
		}
		private JPasswordField getPwtfpw2() {
			if (pwtfpw2 == null) {
				pwtfpw2 = new JPasswordField();
				pwtfpw2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {		
						pwAction();		
					}
				});
				pwtfpw2.setBounds(108, 217, 215, 21);
			}
			return pwtfpw2;
		}
		private JPasswordField getPwtfpw() {
			if (pwtfpw == null) {
				pwtfpw = new JPasswordField();
				pwtfpw.setBounds(108, 173, 215, 21);
			}
			return pwtfpw;
		}
		private JTextField getTfId() {
			if (tfId == null) {
				tfId = new JTextField();
				tfId.setColumns(10);
				tfId.setBounds(106, 133, 215, 21);
			}
			return tfId;
		}
		private JButton getBtnId() {
			if (btnId == null) {
				btnId = new JButton("중복확인");
				btnId.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							idAction();
					}
				});
				btnId.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				btnId.setBackground(new Color(102, 204, 255));
				btnId.setBounds(334, 137, 91, 23);
			}
			return btnId;
		}
		private JButton getBtnNewButton() {
			if (btnNewButton == null) {
				btnNewButton = new JButton("가입하기");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int chk = insertFieldCheck();
						if(chk==0) {
						joinAction();
							}
					}
				});
				btnNewButton.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
				btnNewButton.setBackground(new Color(102, 204, 255));
				btnNewButton.setBounds(94, 348, 253, 48);
			}
			return btnNewButton;
			
		}
		private JLabel getLblNewLabel_2_5() {
			if (lblNewLabel_2_5 == null) {
				lblNewLabel_2_5 = new JLabel("이름");
				lblNewLabel_2_5.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				lblNewLabel_2_5.setBounds(17, 90, 50, 15);
			}
			return lblNewLabel_2_5;
		}
		private JLabel getLblNewLabel_2() {
			if (lblNewLabel_2 == null) {
				lblNewLabel_2 = new JLabel("아이디");
				lblNewLabel_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				lblNewLabel_2.setBounds(17, 133, 50, 15);
			}
			return lblNewLabel_2;
		}
		private JLabel getLblNewLabel_2_1() {
			if (lblNewLabel_2_1 == null) {
				lblNewLabel_2_1 = new JLabel("비밀번호");
				lblNewLabel_2_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				lblNewLabel_2_1.setBounds(17, 172, 50, 15);
			}
			return lblNewLabel_2_1;
		}
		private JLabel getLblNewLabel_2_2() {
			if (lblNewLabel_2_2 == null) {
				lblNewLabel_2_2 = new JLabel("비밀번호 확인");
				lblNewLabel_2_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				lblNewLabel_2_2.setBounds(17, 210, 91, 21);
			}
			return lblNewLabel_2_2;
		}
		private JLabel getLblNewLabel_2_2_1() {
			if (lblNewLabel_2_2_1 == null) {
				lblNewLabel_2_2_1 = new JLabel("e-mail");
				lblNewLabel_2_2_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				lblNewLabel_2_2_1.setBounds(17, 309, 91, 15);
			}
			return lblNewLabel_2_2_1;
		}
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("식당 회원가입");
				lblNewLabel_1.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 18));
				lblNewLabel_1.setBounds(166, 53, 125, 27);
			}
			return lblNewLabel_1;
		}
		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("YOGI,YOGO");
				lblNewLabel.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
				lblNewLabel.setBounds(145, 23, 176, 32);
			}
			return lblNewLabel;
		}
		private JLabel getLblpw() {
			if (lblpw == null) {
				lblpw = new JLabel("");
				lblpw.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
				lblpw.setBounds(108, 241, 215, 15);
			}
			return lblpw;
		}
		
		
			//가입하기
			private void joinAction() {
			
				String name = tfName.getText().trim();
				String id = tfId.getText().trim();
				
				//pw1(비밀번호 입력)
				char[] str = pwtfpw.getPassword();
				String pw = new String(str);
				
				//pw2(비밀번호 똑같이 입력할 것)
				char[] str2 = pwtfpw2.getPassword();
				String pw2 = new String(str2);
				
				String email = tfEmail.getText().trim();
				String telno = tfTelno.getText().trim();
			
				//비밀번호 입력을 똑같이 넣었는 지 확인하는 것
				
				if(pw.equals(pw2)) {
					DbActionRjoin dbActionRjoin = new DbActionRjoin(id, pw,name,telno, email);
					boolean msg = dbActionRjoin.joinAction();
				
				if(msg==true) {
					 JOptionPane.showMessageDialog(null, "회원가입 완료!");
							}
					}
				}
		
			//입력 못한 곳을 알려주는 창
			
			private int insertFieldCheck() {
			
				int i = 0;
				String message = " ";
	  		
	  		
	  			if(tfName.getText().trim().length() == 0){
	  				i++;
	  				message= "이름을";
	  				tfName.requestFocus();
	  			}
	  			if(tfId.getText().trim().length() == 0){
	  				i++;
	  				message= "아이디를";
	  				tfId.requestFocus();
	  			}
	  			if(pwtfpw.getPassword().toString().length() == 0){
	  				i++;
	  				message= "비밀번호를";
	  				pwtfpw.requestFocus();
	  			}
	  			if(pwtfpw2.getPassword().toString().length() == 0){
	  				i++;
	  				message= "비밀번호를";
	  				pwtfpw2.requestFocus();
	  			}
	  			if(tfEmail.getText().length() == 0){
	  				i++;
	  				message= "주소를";
	  				tfEmail.requestFocus();
	  			}
	  			if(tfTelno.getText().length() == 0){
	  				i++;
	  				message= "전화번호를";
	  				tfTelno.requestFocus();
	  			}
	  			
	  			
	  			if(i>0) {
	  				JOptionPane.showMessageDialog(null, message +"입력해주세요.");
	  			}
	  			return i;
	  		
		}
		
			//비밀번호 확인
			private void pwAction() {
				//pw1
				char[] str = pwtfpw.getPassword();
		  		String pw = new String(str);
		  		
		          
		         //pw2
		  		char[] str2 = pwtfpw2.getPassword();
		  		String pw2 = new String(str2);
		  		
		  		//비밀번호 확인을 하기 위한 것
		  		if(pw.equals(pw2)) {
		  			lblpw.setText("비밀번호가 동일합니다.");
		  		}else {
		  			lblpw.setText("비밀번호가 일치하지 않습니다.");
		  		}
			}
			
			
			//아이디 중복확인
			private void idAction() {
				String idcorrect3 = tfId.getText().trim();
				
				DbActionRjoin dbActionRjoin = new DbActionRjoin(null, null, null, null,idcorrect3); 
				//DbActionjoin에 정의된 변수들을 null로 처리하지 않으면 값이 안나옴 --> 다른 변수들을 다 null로 처리하고 id만 지정하여 하고 싶었던 아이디만 괄호 안에 넣음
				boolean idAction = dbActionRjoin.idAction(idcorrect3);
				
				//id가 중복되는 지 아닌 지 확인하기 
				
				if(idAction==true) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				}else{
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
					
				}
			}   
		
		
	private JLabel getLblNewLabel_2_2_1_1() {
		if (lblNewLabel_2_2_1_1 == null) {
			lblNewLabel_2_2_1_1 = new JLabel("전화번호");
			lblNewLabel_2_2_1_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2_2_1_1.setBounds(17, 274, 91, 15);
		}
		return lblNewLabel_2_2_1_1;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(106, 266, 215, 21);
		}
		return tfTelno;
	}
	}//------------------------------------
