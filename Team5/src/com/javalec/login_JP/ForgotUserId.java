package com.javalec.login_JP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.base.ShareVariable;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotUserId {

//	private final String url_mysql = ShareVariable.url_mysql;
//	private final String id_mysql = ShareVariable.id_mysql;
//	private final String pw_mysql = ShareVariable.pw_mysql;
	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel sad;
	private JLabel tftelcasdsa;
	private JTextField tfphone;
	private JTextField tfname;
	private JLabel lblNewLabel_3;
	private JTextField tfemail;
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
					ForgotUserId window = new ForgotUserId();
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
	public ForgotUserId() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("아이디 찾기");
		frame.setBounds(100, 100, 311, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getSad());
        frame.getContentPane().add(getTftelcasdsa());
        frame.getContentPane().add(getTfphone());
        frame.getContentPane().add(getTfname());
        frame.getContentPane().add(getLblNewLabel_3());
        frame.getContentPane().add(getTfemail());
        frame.getContentPane().add(getBtnid());
        frame.getContentPane().add(getBtnlogin());
        frame.getContentPane().add(getLblNewLabel());
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
	private JLabel getSad() {
		if (sad == null) {
			sad = new JLabel("이름");
			sad.setFont(new Font("Dialog", Font.PLAIN, 13));
			sad.setBounds(29, 118, 39, 38);
		}
		return sad;
	}
	private JLabel getTftelcasdsa() {
		if (tftelcasdsa == null) {
			tftelcasdsa = new JLabel("전화번호");
			tftelcasdsa.setFont(new Font("Dialog", Font.PLAIN, 13));
			tftelcasdsa.setBounds(29, 156, 61, 26);
		}
		return tftelcasdsa;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setColumns(10);
			tfphone.setBounds(82, 156, 196, 26);
		}
		return tfphone;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setColumns(10);
			tfname.setBounds(82, 124, 196, 26);
		}
		return tfname;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("email");
			lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(29, 185, 52, 38);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfemail() {
		if (tfemail == null) {
			tfemail = new JTextField();
			tfemail.setColumns(10);
			tfemail.setBounds(82, 191, 196, 26);
		}
		return tfemail;
	}
	private JButton getBtnid() {
		if (btnid == null) {
			btnid = new JButton("아이디 찾기");
			btnid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					searchu_id();  // 검색 클릭시 회원정보 확인
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
				    Log_in_User loginindividual = new Log_in_User();
					loginindividual.frame.setVisible(true);
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
  
	
	
	public void searchu_id() {  //계정 아이디 찾을때 확인작업을 위한 데이터 넣기
	    String name = tfname.getText().trim();
	    String phone = tfphone.getText().trim();
	    String email = tfemail.getText().trim();
		
	    DbactionUser dbactioonuser = new DbactionUser();
//	    dbactioonuser.searchuserid(name, phone, email);
	    
	    //-------------2021.05.02 이도희-------------
	    int msg = dbactioonuser.searchuserid(name, phone, email);
	    
	    if(msg == 1) {
			
		}else if(msg == 0) {
			JOptionPane.showMessageDialog(frame,  "사용자 정보를 다시 확인해주세요");
		}else if(msg == -1) {
			JOptionPane.showMessageDialog(frame,  "사용자 정보를 다시 확인해주세요");
		}else {
			JOptionPane.showMessageDialog(frame, "오류가 발생하였습니다.\n 관리자에게 문의하세요.");
		}
	    //-------------2021.05.02 이도희-------------
	}
}
