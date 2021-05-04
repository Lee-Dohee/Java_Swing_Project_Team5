package com.javalec.login_JP;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.restaurant_owner.SearchRestaurant_Owner;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotRestaurantId {

//	private final String url_mysql = LoginShareVariable.url_mysql; 
//	private final String id_mysql = LoginShareVariable.id_mysql; 
//	private final String pw_mysql = LoginShareVariable.pw_mysql; 
	public JFrame frame;
	public JTextField tfid_name;
	private JLabel sad;
	private JLabel lblNewLabel_1;
	private JLabel tftelcasdsa;
	public JTextField tfid_phone;
	private JLabel lblNewLabel_3;
	public JTextField tfid_email;
	private JButton btnid;
	private JButton btnlogin;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotRestaurantId window = new ForgotRestaurantId();
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
	public ForgotRestaurantId() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 311, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(getTfid_name());
        frame.getContentPane().add(getSad());
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getTftelcasdsa());
        frame.getContentPane().add(getTfid_phone());
        frame.getContentPane().add(getLblNewLabel_3());
        frame.getContentPane().add(getTfid_email());
        frame.getContentPane().add(getBtnid());
        frame.getContentPane().add(getBtnlogin());
        frame.getContentPane().add(getLblNewLabel());
	}

	private JTextField getTfid_name() {
		if (tfid_name == null) {
			tfid_name = new JTextField();
			tfid_name.setColumns(10);
			tfid_name.setBounds(82, 124, 196, 26);
		}
		return tfid_name;
	}
	private JLabel getSad() {
		if (sad == null) {
			sad = new JLabel("이름 :");
			sad.setFont(new Font("Dialog", Font.PLAIN, 13));
			sad.setBounds(29, 118, 39, 38);
		}
		return sad;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("JEOGIYO-GO!의 계정을 찾아가세요");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel_1.setBounds(0, 42, 311, 38);
		}
		return lblNewLabel_1;
	}
	private JLabel getTftelcasdsa() {
		if (tftelcasdsa == null) {
			tftelcasdsa = new JLabel("전화번호 :");
			tftelcasdsa.setFont(new Font("Dialog", Font.PLAIN, 13));
			tftelcasdsa.setBounds(29, 156, 61, 26);
		}
		return tftelcasdsa;
	}
	private JTextField getTfid_phone() {
		if (tfid_phone == null) {
			tfid_phone = new JTextField();
			tfid_phone.setColumns(10);
			tfid_phone.setBounds(82, 156, 196, 26);
		}
		return tfid_phone;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("email :");
			lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(29, 185, 52, 38);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfid_email() {
		if (tfid_email == null) {
			tfid_email = new JTextField();
			tfid_email.setColumns(10);
			tfid_email.setBounds(82, 191, 196, 26);
		}
		return tfid_email;
	}
	private JButton getBtnid() {
		if (btnid == null) {
			btnid = new JButton("아이디 찾기");
			btnid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					searchR_id();
				}
			});
			btnid.setBackground(Color.WHITE);
			btnid.setBounds(175, 229, 103, 26);
		}
		return btnid;
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
			lblNewLabel = new JLabel("아이디 찾기");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(124, 84, 61, 16);
		}
		return lblNewLabel;
	}
	
	public void searchR_id() {  //계정 아이디 찾을때 확인작업을 위한 데이터 넣기
	    
	    String r_name =  tfid_name.getText().trim();
		String r_phone = tfid_phone.getText().trim();
		String r_email = tfid_email.getText().trim();
	   
		DbactionRestaurant dbactionRestaurant = new DbactionRestaurant();
//		dbactionRestaurant.searchid(r_name, r_phone, r_email);
		
		//-------------2021.05.02 이도희-------------
		int msg = dbactionRestaurant.searchid(r_name, r_phone, r_email);
		
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
