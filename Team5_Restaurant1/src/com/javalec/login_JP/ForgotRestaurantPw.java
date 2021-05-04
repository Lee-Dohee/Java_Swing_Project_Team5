package com.javalec.login_JP;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotRestaurantPw {

//	private final String url_mysql = LoginShareVariable.url_mysql; 
//	private final String id_mysql = LoginShareVariable.id_mysql; 
//	private final String pw_mysql = LoginShareVariable.pw_mysql; 
	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel sad_1;
	private JTextField tfpw_id;
	private JLabel sad_1_1;
	private JTextField tfpw_name;
	private JLabel tftelcasdsa_1;
	private JTextField tfpw_phone;
	private JLabel lblNewLabel_3_1;
	private JTextField tfpw_email;
	private JButton btnpassword;
	private JButton btnlogin;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotRestaurantPw window = new ForgotRestaurantPw();
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
	public ForgotRestaurantPw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 312, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getSad_1());
        frame.getContentPane().add(getTfpw_id());
        frame.getContentPane().add(getSad_1_1());
        frame.getContentPane().add(getTfpw_name());
        frame.getContentPane().add(getTftelcasdsa_1());
        frame.getContentPane().add(getTfpw_phone());
        frame.getContentPane().add(getLblNewLabel_3_1());
        frame.getContentPane().add(getTfpw_email());
        frame.getContentPane().add(getBtnpassword());
        frame.getContentPane().add(getBtnlogin());
        frame.getContentPane().add(getLblNewLabel());
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("JEOGIYO-GO!의 계정을 찾아가세요.");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel_1.setBounds(0, 42, 311, 38);
		}
		return lblNewLabel_1;
	}
	private JLabel getSad_1() {
		if (sad_1 == null) {
			sad_1 = new JLabel("아이디 :");
			sad_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			sad_1.setBounds(29, 118, 52, 38);
		}
		return sad_1;
	}
	private JTextField getTfpw_id() {
		if (tfpw_id == null) {
			tfpw_id = new JTextField();
			tfpw_id.setColumns(10);
			tfpw_id.setBounds(82, 124, 196, 26);
		}
		return tfpw_id;
	}
	private JLabel getSad_1_1() {
		if (sad_1_1 == null) {
			sad_1_1 = new JLabel("이름 :");
			sad_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			sad_1_1.setBounds(29, 156, 61, 26);
		}
		return sad_1_1;
	}
	private JTextField getTfpw_name() {
		if (tfpw_name == null) {
			tfpw_name = new JTextField();
			tfpw_name.setColumns(10);
			tfpw_name.setBounds(82, 156, 196, 26);
		}
		return tfpw_name;
	}
	private JLabel getTftelcasdsa_1() {
		if (tftelcasdsa_1 == null) {
			tftelcasdsa_1 = new JLabel("전화번호 :");
			tftelcasdsa_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			tftelcasdsa_1.setBounds(29, 185, 52, 38);
		}
		return tftelcasdsa_1;
	}
	private JTextField getTfpw_phone() {
		if (tfpw_phone == null) {
			tfpw_phone = new JTextField();
			tfpw_phone.setColumns(10);
			tfpw_phone.setBounds(82, 191, 196, 26);
		}
		return tfpw_phone;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("email :");
			lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_3_1.setBounds(29, 216, 52, 38);
		}
		return lblNewLabel_3_1;
	}
	private JTextField getTfpw_email() {
		if (tfpw_email == null) {
			tfpw_email = new JTextField();
			tfpw_email.setColumns(10);
			tfpw_email.setBounds(82, 222, 196, 26);
		}
		return tfpw_email;
	}
	private JButton getBtnpassword() {
		if (btnpassword == null) {
			btnpassword = new JButton("비밀번호 찾기");
			btnpassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					searchR_pw();
				}
			});
			btnpassword.setBackground(Color.WHITE);
			btnpassword.setBounds(175, 260, 103, 26);
		}
		return btnpassword;
	}
	private JButton getBtnlogin() {
		if (btnlogin == null) {
			btnlogin = new JButton("뒤로");
			btnlogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				 frame.setVisible(false);   
				 Log_in_Restaurant loginrestaurant = new Log_in_Restaurant();
			     loginrestaurant.frame.setVisible(true);
						}
				
			});
			btnlogin.setBackground(Color.WHITE);
			btnlogin.setBounds(6, 6, 65, 32);
		}
		return btnlogin;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호 찾기");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(101, 81, 108, 16);
		}
		return lblNewLabel;
	}
	
    public void searchR_pw() {  //계정 비번 찾을때 확인작업을 위한 데이터 넣기
	 
		String r_id = tfpw_id.getText().trim();
		String r_name = tfpw_name.getText().trim();
		String r_phone = tfpw_phone.getText().trim();
		String r_email = tfpw_email.getText().trim();  
		
		DbactionRestaurant dbactionRestaurant = new DbactionRestaurant();
//		dbactionRestaurant.searchpw(r_id, r_name, r_phone, r_email);
		
		//-------------2021.05.02 이도희-------------
		int msg = dbactionRestaurant.searchpw(r_id, r_name, r_phone, r_email);
		
		if(msg == 1) {
			
		}else if(msg == 0) {
			JOptionPane.showMessageDialog(frame,  "등록되지 않은 정보입니다 다시 확인해주세요");
		}else if(msg == -1) {
			JOptionPane.showMessageDialog(frame,  "등록되지 않은 정보입니다 다시 확인해주세요");
		}else {
			JOptionPane.showMessageDialog(frame, "오류가 발생하였습니다.\n 관리자에게 문의하세요.");
		}
		//-------------2021.05.02 이도희-------------
	}
	
}
