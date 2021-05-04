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

import com.javalec.login_JP.Log_in_Restaurant;

public class Join_HJ {

	public JFrame frame;
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
	private JLabel lblpw;
	private JPasswordField pwtfPw;
	private JLabel lblNewLabel_2_2_1_1;
	private JTextField tfTelno;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_HJ window = new Join_HJ();
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
	public Join_HJ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setTitle("식당 회원가입");
//		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 366, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
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
		frame.getContentPane().add(getLblpw());
		frame.getContentPane().add(getLblNewLabel_2_2_1_1());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getBtnCancel());
	}
	
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(80, 63, 150, 26);
		}
		return tfName;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(80, 215, 259, 26);
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
			pwtfpw2.setBounds(110, 177, 229, 26);
		}
		return pwtfpw2;
	}
	private JPasswordField getPwtfpw() {
		if (pwtfpw == null) {
			pwtfpw = new JPasswordField();
			pwtfpw.setBounds(110, 139, 229, 26);
		}
		return pwtfpw;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(80, 101, 150, 26);
		}
		return tfId;
	}
	private JButton getBtnId() {
		if (btnId == null) {
			btnId = new JButton("중복확인");
			btnId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					idAction();
					//-------------2021.04.30 이도희-------------
					int chk = insertIdCheck();
					if(chk==0) {
						idAction();
					}else {
						JOptionPane.showMessageDialog(frame, "Id를 입력하세요!",
								"ID 입력", 
								JOptionPane.INFORMATION_MESSAGE);
					}
					//-------------2021.04.30 이도희-------------
				}
			});
			btnId.setBounds(232, 101, 107, 29);
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
			btnNewButton.setBounds(222, 291, 117, 29);
		}
		return btnNewButton;
		
	}
	private JLabel getLblNewLabel_2_5() {
		if (lblNewLabel_2_5 == null) {
			lblNewLabel_2_5 = new JLabel("이름");
			lblNewLabel_2_5.setBounds(24, 68, 37, 16);
		}
		return lblNewLabel_2_5;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("아이디");
			lblNewLabel_2.setBounds(24, 106, 50, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("비밀번호");
			lblNewLabel_2_1.setBounds(24, 144, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("비밀번호 확인");
			lblNewLabel_2_2.setBounds(24, 182, 80, 16);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("e-mail");
			lblNewLabel_2_2_1.setBounds(24, 220, 50, 16);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("회원가입");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(0, 19, 366, 26);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblpw() {
		if (lblpw == null) {
			lblpw = new JLabel("");
			lblpw.setBounds(110, 201, 218, 16);
		}
		return lblpw;
	}
	private JLabel getLblNewLabel_2_2_1_1() {
		if (lblNewLabel_2_2_1_1 == null) {
			lblNewLabel_2_2_1_1 = new JLabel("전화번호");
			lblNewLabel_2_2_1_1.setBounds(24, 258, 67, 16);
		}
		return lblNewLabel_2_2_1_1;
		}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(80, 253, 259, 26);
		}
		return tfTelno;
	}
	//-------------2021.05.02 이도희-------------
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Log_in_Restaurant log_in_Restaurant = new Log_in_Restaurant();
					log_in_Restaurant.frame.setVisible(true);
				}
			});
			btnCancel.setBounds(93, 291, 117, 29);
		}
		return btnCancel;
	}
	//-------------2021.05.02 이도희-------------
	
	
	
	
	//가입하기
	private void joinAction() {
	
		String id = tfId.getText().trim();
		
		//pw1(비밀번호 입력)
		char[] str = pwtfpw.getPassword();
		String pw = new String(str);
		
		//pw2(비밀번호 똑같이 입력할 것)
		char[] str2 = pwtfpw2.getPassword();
		String pw2 = new String(str2);
		
		String name = tfName.getText().trim();
		String email = tfEmail.getText().trim();
		String telno = tfTelno.getText().trim();
	
		//비밀번호 입력을 똑같이 넣었는 지 확인하는 것
		if(pw.equals(pw2)) {
			DbActionJoin_HJ dbActionJoin = new DbActionJoin_HJ(id, pw, name, telno, email);
			boolean msg = dbActionJoin.joinAction();
		
//			if(msg == true) {
//				 JOptionPane.showMessageDialog(frame, "회원가입 완료!");
//			}
			//-------------2021.05.03 이도희-------------
			if(msg == true) {
				JOptionPane.showMessageDialog(frame, tfName.getText() + "님 회원가입이 완료되었습니다!",
		                "등록 완료!", 
		                JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Log_in_Restaurant log_in_Restaurant = new Log_in_Restaurant();
				log_in_Restaurant.frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, tfName.getText() + "님의 회원가입에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
		                "Critical Error!", 
		                JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(frame, "비밀번호를 다시 확인해주세요.",
	                "비밀번호 확인", 
	                JOptionPane.INFORMATION_MESSAGE);
		}
		//-------------2021.05.03 이도희-------------
	}

	//입력 못한 곳을 알려주는 창
	private int insertFieldCheck() {
	
		int i = 0;
		String message = "";
		
		if(tfName.getText().trim().length() == 0){
			i++;
			message= "이름을";
			tfName.requestFocus();
		}
//		if(tfId.getText().trim().length() == 0){
//			i++;
//			message= "아이디를";
//			tfId.requestFocus();
//		}
//		if(pwtfpw.getPassword().toString().length() == 0){
//			i++;
//			message= "비밀번호를";
//			pwtfpw.requestFocus();
//		}
//		if(pwtfpw2.getPassword().toString().length() == 0){
//			i++;
//			message= "비밀번호 확인을";
//			pwtfpw2.requestFocus();
//		}
		//-------------2021.05.01 이도희-------------
		char[] pw = pwtfpw.getPassword();     // 식당 로그인 비밀번호 값 넣기
		pw.toString();
		String pw2 = new String(pw);
		
		if(pw2.length() == 0){
			i++;
			message= "비밀번호를";
			pwtfpw.requestFocus();
		}
		
		char[] pwChk = pwtfpw2.getPassword();     // 식당 로그인 비밀번호 값 넣기
		pwChk.toString();
		String pwChk2 = new String(pwChk);
		
		if(pwChk2.length() == 0){
			i++;
			message= "비밀번호 확인을";
			pwtfpw2.requestFocus();
		}
		//-------------2021.05.01 이도희-------------
		if(tfEmail.getText().length() == 0){
			i++;
			message= "이메일을";
			tfEmail.requestFocus();
		}
		if(tfTelno.getText().length() == 0){
			i++;
			message= "전화번호를";
			tfTelno.requestFocus();
		}
		
		if(i>0) {
			JOptionPane.showMessageDialog(frame, message +"입력해주세요.");
		}
		return i;
	}
	
	//-------------2021.04.30 이도희-------------
	// id 값 넣었나 확인
	private int insertIdCheck(){
		int i = 0;
		if(tfId.getText().length() == 0){
			i++;
			tfId.requestFocus();
		}
		return i;
	}
	//-------------2021.04.30 이도희-------------

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
  			//-------------2021.05.03 이도희-------------
  			lblpw.setForeground(Color.black);
  			//-------------2021.05.03 이도희-------------
  		}else {
  			lblpw.setText("비밀번호가 일치하지 않습니다.");
  			//-------------2021.05.03 이도희-------------
  			lblpw.setForeground(Color.red);
  			//-------------2021.05.03 이도희-------------
  		}
	}
	
	//아이디 중복확인
	private void idAction() {
		
//		String idcorrect3 = tfId.getText().trim();
//		DbActionJoin dbActionRjoin = new DbActionJoin(null, null, null, null,idcorrect3); 
		//DbActionjoin에 정의된 변수들을 null로 처리하지 않으면 값이 안나옴 --> 다른 변수들을 다 null로 처리하고 id만 지정하여 하고 싶었던 아이디만 괄호 안에 넣음
//		boolean idAction = dbActionRjoin.idAction(idcorrect3);
//		boolean idAction = dbActionJoin.idAction();
		//id가 중복되는 지 아닌 지 확인하기 
//		if(idAction==true) {
//			JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
//		}else{
//			JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
//			
//		}
		
		//-------------2021.04.30 이도희-------------
		String id = tfId.getText().trim();
		
		DbActionJoin_HJ dbActionJoin = new DbActionJoin_HJ(id); 
		int msg = dbActionJoin.idChk();
		
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
		//-------------2021.04.30 이도희-------------
		
		
	}   
	
	//-------------2021.05.01 이도희-------------
	// BeanJoin 필요없음 삭제
	//-------------2021.05.01 이도희-------------
}
