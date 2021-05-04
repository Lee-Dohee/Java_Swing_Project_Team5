package com.javalec.login_JP;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.owner.Join_HJ;
import com.javalec.restaurant_owner.SearchRestaurant_Owner;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Log_in_Restaurant {

//	private final String url_mysql = LoginShareVariable.url_mysql; 
//	private final String id_mysql = LoginShareVariable.id_mysql; 
//	private final String pw_mysql = LoginShareVariable.pw_mysql; 
	public JFrame frame;
	private JLabel lblNewLabel_2;
	private JTextField tfr_id;
	private JPasswordField tfr_password;
	private JButton brnlogin;
	private JButton btnForgotPw;
	private JLabel lblNewLabel_1;
	private JButton btnjoin;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JButton btnForgotId;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in_Restaurant window = new Log_in_Restaurant();
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
	public Log_in_Restaurant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("식당 로그인");
		frame.setBounds(100, 100, 309, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(getLblNewLabel_2());
        frame.getContentPane().add(getTfr_id());
        frame.getContentPane().add(getTfr_password());
        frame.getContentPane().add(getBrnlogin());
        frame.getContentPane().add(getBtnForgotPw());
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getBtnjoin());
        frame.getContentPane().add(getChckbxNewCheckBox());
        frame.getContentPane().add(getLblNewLabel());
        frame.getContentPane().add(getLblNewLabel_3());
        frame.getContentPane().add(getBtnForgotId());
        frame.getContentPane().add(getLblNewLabel_4());
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("JEOGIYO-GO!");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 22));
			lblNewLabel_2.setBounds(0, 18, 309, 54);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfr_id() {
		if (tfr_id == null) {
			tfr_id = new JTextField();
//			tfr_id.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					tfr_id.setText("");               
//				}
//			});
//			tfr_id.setText("Id를 입력해주세요");
			tfr_id.setText("");
			tfr_id.setColumns(10);
			tfr_id.setBounds(85, 108, 199, 26);
		}
		return tfr_id;
	}
	private JPasswordField getTfr_password() {
		if (tfr_password == null) {
			tfr_password = new JPasswordField();
			tfr_password.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						Rlogincheck();    // 엔터로 로그인
					}
				}
			});
			tfr_password.setBounds(85, 141, 199, 26);
		}
		return tfr_password;
	}
	private JButton getBrnlogin() {
		if (brnlogin == null) {
			brnlogin = new JButton("Sign in");
			brnlogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					space ();
//					Rlogincheck();    // 클릭시 로그인
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						Rlogincheck();
//						frame.setVisible(false);
//						ViewRestaurant_Owner viewRestaurant = new ViewRestaurant_Owner(wkNum);
//						viewRestaurant.frame.setVisible(true);
					}
				}
			});
			brnlogin.setFont(new Font("굴림", Font.PLAIN, 13));
			brnlogin.setBounds(24, 179, 175, 26);
		}
		return brnlogin;
	}
	//-------------2021.05.01 이도희-------------
	private JButton getBtnForgotPw() {
		if (btnForgotPw == null) {
			btnForgotPw = new JButton("Forgot password?");
			btnForgotPw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ForgotRestaurantPw forgotrestaurantpw = new ForgotRestaurantPw();
					forgotrestaurantpw.frame.setVisible(true);
				}
			});
			btnForgotPw.setForeground(Color.black);
			btnForgotPw.setFont(new Font("굴림", Font.PLAIN, 13));
			btnForgotPw.setBackground(Color.WHITE);
			btnForgotPw.setBounds(149, 213, 135, 26);
		}
		return btnForgotPw;
	}
	private JButton getBtnForgotId() {
		if (btnForgotId == null) {
			btnForgotId = new JButton("Forgot Id?");
			btnForgotId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ForgotRestaurantId forgotrestaurantid = new ForgotRestaurantId();
					forgotrestaurantid.frame.setVisible(true);
				}
			});
			btnForgotId.setForeground(Color.black);
			btnForgotId.setFont(new Font("굴림", Font.PLAIN, 13));
			btnForgotId.setBackground(Color.WHITE);
			btnForgotId.setBounds(24, 213, 126, 26);
		}
		return btnForgotId;
	}
	//-------------2021.05.01 이도희-------------
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New to JEOGIYO-GO!");
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(24, 239, 135, 36);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnjoin() {
		if (btnjoin == null) {
			btnjoin = new JButton("Join Now?");
			//-------------2021.05.01 이도희-------------
			btnjoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Join_HJ join_HJ = new Join_HJ();
					join_HJ.frame.setVisible(true);
				}
			});
			//-------------2021.05.01 이도희-------------
			btnjoin.setForeground(Color.black);
			btnjoin.setBackground(Color.WHITE);
			btnjoin.setBounds(165, 245, 119, 26);
		}
		return btnjoin;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("Show");
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxNewCheckBox.isSelected()) {
						tfr_password.setEchoChar((char)0);
					}else  {
						tfr_password.setEchoChar('*');
					}
				}
			});
			chckbxNewCheckBox.setBounds(215, 179, 69, 26);
		}
		return chckbxNewCheckBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 :");
			lblNewLabel.setBounds(29, 113, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 :");
			lblNewLabel_3.setBounds(29, 146, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("식당 로그인");
			lblNewLabel_4.setBounds(124, 70, 61, 16);
		}
		return lblNewLabel_4;
	}
	
	//////           로그인 확인 메소드        ///////////
	public void Rlogincheck () {
		
		DbactionRestaurant dbactionRestaurant = new DbactionRestaurant();    //식당 로그인 페이지 아이디, 패스워드 가져
	
		String restaurantID = tfr_id.getText().trim(); // 식당 로그인 아이디 값넣기                
		
		char[] pass = tfr_password.getPassword();     // 식당 로그인 비밀번호 값 넣기
		pass.toString();
		String pass2 = new String(pass);
	   
//		dbactionRestaurant.searchaction(restaurantID, pass2);  // db불러오기
		
		//-------------2021.05.01 이도희-------------
		int msg = dbactionRestaurant.searchaction(restaurantID, pass2);  // db불러오기
		
		if(msg == 1) {
			// 다음 페이지 - 레스토랑의 메인 페이지로 이동
			frame.setVisible(false);
			SearchRestaurant_Owner searchRestaurant = new SearchRestaurant_Owner(restaurantID);
			searchRestaurant.frame.setVisible(true);
		}else if(msg == 0) {
			JOptionPane.showMessageDialog(frame,  "아이디와 비밀번호를 확인해주세요");
		}else if(msg == -1) {
			JOptionPane.showMessageDialog(frame,  "등록되지 않은 아이디입니다");
		}else {
			JOptionPane.showMessageDialog(frame, "오류가 발생하였습니다.\n 관리자에게 문의하세요.");
		}
		//-------------2021.05.01 이도희-------------
	}
   
	//-------------2021.05.01 이도희-------------
	// 빈칸으로 로그인 버튼 누를 시 경고
	private int insertFieldCheck(){
		int i = 0;
		String message = "";
		
		char[] pw = tfr_password.getPassword();     // 식당 로그인 비밀번호 값 넣기
		pw.toString();
		String pw2 = new String(pw);
		
		if(tfr_id.getText().length() == 0){
			i++;
			tfr_id.requestFocus();
			message = "아이디";
		}
		if(pw2.length() == 0){
			i++;
			tfr_password.requestFocus();
			message = "비밀번호";
		}
		if(i>0) {
			JOptionPane.showMessageDialog(frame, message +"를 입력해주세요.");
		}
		return i;
	}
   	//-------------2021.05.01 이도희-------------
	
	
	////빈칸으로 버튼 누를시 경고  ////
//	public void space () {
//		char[] pass = tfr_password.getPassword();     // 식당 로그인 비밀번호 값 넣기
//		pass.toString();
//		String pass2 = new String(pass);
//   
//		if(tfr_id.getText()=="") {
//			frame.setVisible(false);
//		} else if(pass2 == "") {
//			JOptionPane.showMessageDialog(null,  "비밀번호를 입력하세요");
//		}
//	}
	
	
}
