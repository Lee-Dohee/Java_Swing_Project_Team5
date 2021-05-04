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

public class ForgotUserPw {

//	private final String url_mysql = ShareVariable.url_mysql;
//	private final String id_mysql = ShareVariable.id_mysql;
//	private final String pw_mysql = ShareVariable.pw_mysql;
	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JButton btnlogin;
	private JButton btnpassword;
	private JTextField tfpemail;
	private JLabel lblNewLabel_3_1;
	private JTextField tfpphone;
	private JLabel tftelcasdsa_1;
	private JTextField tfpname;
	private JLabel sad_1_1;
	private JTextField tfpid;
	private JLabel sad_1;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotUserPw window = new ForgotUserPw();
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
	public ForgotUserPw() {
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
        frame.getContentPane().add(getBtnlogin());
        frame.getContentPane().add(getBtnpassword());
        frame.getContentPane().add(getTfpemail());
        frame.getContentPane().add(getLblNewLabel_3_1());
        frame.getContentPane().add(getTfpphone());
        frame.getContentPane().add(getTftelcasdsa_1());
        frame.getContentPane().add(getTfpname());
        frame.getContentPane().add(getSad_1_1());
        frame.getContentPane().add(getTfpid());
        frame.getContentPane().add(getSad_1());
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
	private JButton getBtnpassword() {
		if (btnpassword == null) {
			btnpassword = new JButton("비밀번호 찾기");
			btnpassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					searchu_pw();
				}
			});
			btnpassword.setBackground(Color.WHITE);
			btnpassword.setBounds(175, 260, 103, 26);
		}
		return btnpassword;
	}
	private JTextField getTfpemail() {
		if (tfpemail == null) {
			tfpemail = new JTextField();
			tfpemail.setColumns(10);
			tfpemail.setBounds(82, 222, 196, 26);
		}
		return tfpemail;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("email :");
			lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_3_1.setBounds(29, 216, 52, 38);
		}
		return lblNewLabel_3_1;
	}
	private JTextField getTfpphone() {
		if (tfpphone == null) {
			tfpphone = new JTextField();
			tfpphone.setColumns(10);
			tfpphone.setBounds(82, 191, 196, 26);
		}
		return tfpphone;
	}
	private JLabel getTftelcasdsa_1() {
		if (tftelcasdsa_1 == null) {
			tftelcasdsa_1 = new JLabel("전화번호 :");
			tftelcasdsa_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			tftelcasdsa_1.setBounds(29, 185, 52, 38);
		}
		return tftelcasdsa_1;
	}
	private JTextField getTfpname() {
		if (tfpname == null) {
			tfpname = new JTextField();
			tfpname.setColumns(10);
			tfpname.setBounds(82, 156, 196, 26);
		}
		return tfpname;
	}
	private JLabel getSad_1_1() {
		if (sad_1_1 == null) {
			sad_1_1 = new JLabel("이름 :");
			sad_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			sad_1_1.setBounds(29, 156, 61, 26);
		}
		return sad_1_1;
	}
	private JTextField getTfpid() {
		if (tfpid == null) {
			tfpid = new JTextField();
			tfpid.setColumns(10);
			tfpid.setBounds(82, 124, 196, 26);
		}
		return tfpid;
	}
	private JLabel getSad_1() {
		if (sad_1 == null) {
			sad_1 = new JLabel("아이디 :");
			sad_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			sad_1.setBounds(29, 118, 52, 38);
		}
		return sad_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호 찾기");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(101, 81, 108, 16);
		}
		return lblNewLabel;
	}
	
	////호ㅣ원 비밀 번호 찾기./////////
    public void searchu_pw() {  //계정 비번 찾을때 확인작업을 위한 데이터 넣기

	    String id = tfpid.getText().trim();
	    String name = tfpname.getText().trim();
	    String phone = tfpphone.getText().trim();
	    String email = tfpemail.getText().trim();
	    
	    DbactionUser dbactioonuser = new DbactionUser();
//	    dbactioonuser.searchpw(id, name, phone, email);
	    
	  //-------------2021.05.02 이도희-------------
	    int msg = dbactioonuser.searchpw(id, name, phone, email);
	    
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
