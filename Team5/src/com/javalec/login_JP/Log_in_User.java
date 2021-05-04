package com.javalec.login_JP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.restaurant_user.SearchRestaurant_User;
import com.javalec.user.User;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Log_in_User {

//	private final String url_mysql = LoginShareVariable.url_mysql; 
//	private final String id_mysql = LoginShareVariable.id_mysql; 
//	private final String pw_mysql = LoginShareVariable.pw_mysql; 
	public JFrame frame;
	private JLabel lblNewLabel_2;
	private JTextField tfid;
	private JPasswordField passwordfield;
	private JCheckBox chckbxNewCheckBox;
	private JButton brnlogin;
	private JButton btnForgotPw;
	private JLabel lblNewLabel_1;
	private JButton btnjoin;
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
					Log_in_User window = new Log_in_User();
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
	public Log_in_User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("일반 로그인");
		frame.setBounds(100, 100, 309, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(getLblNewLabel_2());
        frame.getContentPane().add(getTfid());
        frame.getContentPane().add(getPasswordfield());
        frame.getContentPane().add(getChckbxNewCheckBox());
        frame.getContentPane().add(getBrnlogin());
        frame.getContentPane().add(getBtnForgotPw());
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getBtnjoin());
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
	private JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
//			tfid.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					tfid.setText("");               
//				}
//			});
//			tfid.setText("Id를 입력해주세요");
			tfid.setText("");
			tfid.setColumns(10);
			tfid.setBounds(85, 108, 199, 26);
		}
		return tfid;
	}
	private JPasswordField getPasswordfield() {
		if (passwordfield == null) {
			passwordfield = new JPasswordField();
			passwordfield.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						UserloginCheck();
					}
				}
			});
			passwordfield.setBounds(85, 141, 199, 26);
		}
		return passwordfield;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("Show");
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxNewCheckBox.isSelected()) {
						passwordfield.setEchoChar((char)0);
					}else  {
						passwordfield.setEchoChar('*');
					}
				}
			});
			chckbxNewCheckBox.setBounds(215, 179, 69, 26);
		}
		return chckbxNewCheckBox;
	}
	private JButton getBrnlogin() {
		if (brnlogin == null) {
			brnlogin = new JButton("Sign in");
			brnlogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					UserloginCheck();     // 버튼  클릭하면 로그인 확인 작업
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						UserloginCheck(); 
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
	private JButton getBtnForgotId() {
		if (btnForgotId == null) {
			btnForgotId = new JButton("Forgot Id?");
			btnForgotId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ForgotUserId forgotuserid = new ForgotUserId();
					forgotuserid.frame.setVisible(true);
				}
			});
			btnForgotId.setForeground(Color.black);
			btnForgotId.setFont(new Font("굴림", Font.PLAIN, 13));
			btnForgotId.setBackground(Color.WHITE);
			btnForgotId.setBounds(24, 213, 126, 26);
		}
		return btnForgotId;
	}
	private JButton getBtnForgotPw() {
		if (btnForgotPw == null) {
			btnForgotPw = new JButton("Forgot password?");
			btnForgotPw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					ForgotUserPw forgotuserpw = new ForgotUserPw();
					forgotuserpw.frame.setVisible(true);
				}
			});
			btnForgotPw.setForeground(Color.black);
			btnForgotPw.setFont(new Font("굴림", Font.PLAIN, 13));
			btnForgotPw.setBackground(Color.WHITE);
			btnForgotPw.setBounds(149, 213, 135, 26);
		}
		return btnForgotPw;
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
					User user = new User();
					user.frame.setVisible(true);
				}
			});
			//-------------2021.05.01 이도희-------------
			btnjoin.setForeground(Color.black);
			btnjoin.setBackground(Color.WHITE);
			btnjoin.setBounds(165, 245, 119, 26);
		}
		return btnjoin;
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
			lblNewLabel_4 = new JLabel("일반 로그인");
			lblNewLabel_4.setBounds(124, 70, 61, 16);
		}
		return lblNewLabel_4;
	}
	
	
	public void UserloginCheck() {  //로그인시 확인작업을 위한 데이터 넣기
	
		String userID = tfid.getText();
		
		char[] pass = passwordfield.getPassword();
		pass.toString();
		String pass2 = new String(pass);
		
		DbactionUser dbactioonuser = new DbactionUser();
//		dbactioonuser.Userlogin(userID, pass2);
		
		//-------------2021.05.01 이도희-------------
		int msg = dbactioonuser.Userlogin(userID, pass2);
		
		if(msg == 1) {
			// 다음 페이지 - 유저의 메인 페이지로 이동
			frame.setVisible(false);
			SearchRestaurant_User searchRestaurant = new SearchRestaurant_User(userID);
			searchRestaurant.frame.setVisible(true);
		}else if(msg == 0) {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.");
		}else if(msg == -1) {
			JOptionPane.showMessageDialog(null, "등록되지 않은 아이디입니다.");
		}else {
			JOptionPane.showMessageDialog(null, "오류가 발생하였습니다.\n 관리자에게 문의하세요.");
		}
		//-------------2021.05.01 이도희-------------
	}
	
	//-------------2021.05.01 이도희-------------
	// 빈칸으로 로그인 버튼 누를 시 경고
	private int insertFieldCheck(){
		int i = 0;
		String message = "";
		
		char[] pw = passwordfield.getPassword();     // 식당 로그인 비밀번호 값 넣기
		pw.toString();
		String pw2 = new String(pw);
		
		if(tfid.getText().length() == 0){
			i++;
			tfid.requestFocus();
			message = "아이디";
		}
		if(pw2.length() == 0){
			i++;
			passwordfield.requestFocus();
			message = "비밀번호";
		}
		if(i>0) {
			JOptionPane.showMessageDialog(null, message +"를 입력해주세요.");
		}
		return i;
	}
	//-------------2021.05.01 이도희-------------
	
}
