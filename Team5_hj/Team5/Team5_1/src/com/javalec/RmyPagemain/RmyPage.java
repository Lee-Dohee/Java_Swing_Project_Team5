package com.javalec.RmyPagemain;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import com.javalec.RmyPagefunction.BeanRmyPage;
import com.javalec.RmyPagefunction.DbActionRmyPage;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RmyPage {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JTextField tfId;
	private JTextField tfTelno;
	private JTextField tfEnrollnumber;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_2_4;
	private JButton btnUpdate;
	private JButton btnAction;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblpw;
	private JPasswordField pwtfPw;
	private JPasswordField pwtfPw2;
	private JLabel lblPw;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RmyPage window = new RmyPage();
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
	public RmyPage() {
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
				startAction();
			}
		});
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfEnrollnumber());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_2());
		frame.getContentPane().add(getLblNewLabel_2_3());
		frame.getContentPane().add(getLblNewLabel_2_4());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtnAction());
		frame.getContentPane().add(getLblNewLabel_2_2_1());
		frame.getContentPane().add(getLblpw());
		frame.getContentPane().add(getPwtfPw());
		frame.getContentPane().add(getPwtfPw2());
		frame.getContentPane().add(getLblPw());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("YOGI,YOGO");
			lblNewLabel.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
			lblNewLabel.setBounds(126, 10, 166, 65);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("식당회원정보");
			lblNewLabel_1.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(146, 56, 106, 43);
		}
		return lblNewLabel_1;
	}
	
	
	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
			try {
				RmyPage dialog = new RmyPage();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				RmyPage.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	private void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}
		
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(156, 121, 186, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(156, 168, 186, 21);
		}
		return tfId;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(156, 299, 186, 21);
		}
		return tfTelno;
	}
	private JTextField getTfEnrollnumber() {
		if (tfEnrollnumber == null) {
			tfEnrollnumber = new JTextField();
			tfEnrollnumber.setColumns(10);
			tfEnrollnumber.setBounds(156, 334, 186, 21);
		}
		return tfEnrollnumber;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(54, 124, 50, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("아이디");
			lblNewLabel_2_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2_1.setBounds(54, 171, 50, 15);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("비밀번호");
			lblNewLabel_2_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2_2.setBounds(54, 218, 50, 15);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("전화번호");
			lblNewLabel_2_3.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2_3.setBounds(54, 304, 50, 15);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("사업자등록번호");
			lblNewLabel_2_4.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2_4.setBounds(54, 339, 90, 15);
		}
		return lblNewLabel_2_4;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Update();
					insertFieldCheck();
					ClearColumn();
				}
			});
			btnUpdate.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			btnUpdate.setBounds(89, 388, 106, 23);
		}
		return btnUpdate;
	}
	
		//정보 수정
		private void Update(){
			
			String name = tfName.getText().trim();
			String id = tfId.getText().trim();
			//pw1(비밀번호 입력)
			char[] str = pwtfPw.getPassword();
			String pw = new String(str);
			
			//pw2(비밀번호 똑같이 입력하였는지 확인)
			char[] str2 = pwtfPw2.getPassword();
			String pw2 = new String(str2);
			
			String telno = tfTelno.getText().trim();
			String enrollnumber = tfEnrollnumber.getText().trim();
		
			if(pw.equals(pw2)) {
	  			lblpw.setText("비밀번호가 동일합니다.");
	  		}else {
	  			lblpw.setText("비밀번호가 일치하지 않습니다.");
	  		}
			
		
		DbActionRmyPage dbActionRjoinPage = new DbActionRmyPage(name, id, pw, pw2, telno, enrollnumber);
							boolean msg = dbActionRjoinPage.UpdateAction();
							if(msg == true) {
								JOptionPane.showMessageDialog(null, tfName.getText()+"님의 정보가 수정되었습니다."); 
							}else {
								JOptionPane.showMessageDialog(null, "DB 자료 입력 중 에러가 발생했습니다! \n 시스템관리자에게 문의하세요!");
								}
		
		}


	
	//확인 버튼
	private JButton getBtnAction() {
		if (btnAction == null) {
			btnAction = new JButton("확인");
			btnAction.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					correct();
				}
			});
			btnAction.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			btnAction.setBounds(227, 388, 115, 23);
		}
		return btnAction;
	}

	
	//정보 확인
	public void correct() {
		String wkId = "";
		wkId = tfId.getText().trim();
		char[] wkPw2 = pwtfPw2.getPassword();
		String wkPw = "";
		String wkName = "";
		String wkTelno = "";
		String wkEnrollnumber = "";
		for(int i = 0; i<wkPw2.length;i++) {
			wkPw += wkPw2[i];
		}
		DbActionRmyPage dbActionRjoinPage = new DbActionRmyPage(wkId,wkPw,wkName,wkTelno,wkEnrollnumber);
		BeanRmyPage beanRmyPage = dbActionRjoinPage.correct();
		if(btnAction.isSelected()==true) {
			if(wkId.equals(beanRmyPage.getId()) && wkPw.equals(beanRmyPage.getPw())) {
				JOptionPane.showMessageDialog(null, beanRmyPage.getName()+"님의 정보를 확인하었습니다."); 	
			
			}else {
				JOptionPane.showMessageDialog(null, "당신의 정보를 확인하세요.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "회원만 볼 수 있는 정보입니다. 로그인하세요.");
		}
	}

	
	
	private void control() {
		// TODO Auto-generated method stub
		
	}

	private void mainVisible() {
		// TODO Auto-generated method stub
		
	}

	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("비밀번호 확인");
			lblNewLabel_2_2_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2_2_1.setBounds(54, 258, 76, 15);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblpw() {
		if (lblpw == null) {
			lblpw = new JLabel("");
			lblpw.setBounds(156, 274, 196, 15);
		}
		return lblpw;
	}
	private JPasswordField getPwtfPw() {
		if (pwtfPw == null) {
			pwtfPw = new JPasswordField();
			pwtfPw.setBounds(156, 213, 186, 21);
		}
		return pwtfPw;
	}
	private JPasswordField getPwtfPw2() {
		if (pwtfPw2 == null) {
			pwtfPw2 = new JPasswordField();
			pwtfPw2.setBounds(156, 253, 186, 21);
		}
		return pwtfPw2;
	}
	
	//화면 정리
	private void ScreenPartition() {
		
		
		// 수정화면 정리
		if(btnUpdate.isSelected() == true) {
			btnUpdate.setVisible(true);
			tfName.setEditable(true);
			tfId.setEditable(false);
			pwtfPw.setEditable(true);
			pwtfPw2.setEditable(true);
			tfTelno.setEditable(true);
			tfEnrollnumber.setEditable(true);						
		}
		
		//확인화면 정리
		if(btnAction.isSelected() == true) {
			btnAction.setVisible(true);
			tfId.setEditable(false);
			pwtfPw.setEditable(false);
			pwtfPw2.setEditable(false);
			tfTelno.setEditable(false);
			tfEnrollnumber.setEditable(false);
		}
	}
	
	// Action 구분하기 
	private void ActionPartition() {
		//수정 Action
		if(btnUpdate.isSelected() == true) {
			int i_chk = insertFieldCheck();
			if(i_chk == 0){
				Update();
				ClearColumn();
			}else {
				JOptionPane.showInputDialog(this, "주소록 정보 수정 ! " + "\n" + 
						"Data를 입력하세요 하세요!");        			
				
			}			
			ScreenPartition();
		}
		//확인 Action
		if(btnAction.isSelected() == true) {
				correct();
				ClearColumn();			
				ScreenPartition();
			}
	}
	
	//정보 입력시, 입력하지 않은 곳에 깜빡이기
	private int insertFieldCheck(){
		int i = 0;
		if(tfName.getText().length() == 0){
			i++;
			tfName.requestFocus();
		}
		if(tfId.getText().length() == 0){
			i++;
			tfId.requestFocus();
		}
		if(pwtfPw.getPassword().length == 0){
			i++;
			pwtfPw.requestFocus();
		}
		if(pwtfPw2.getPassword().length == 0){
			i++;
			pwtfPw.requestFocus();
		}
		if(tfTelno.getText().length() == 0){
			i++;
			tfTelno.requestFocus();
		}
		if(tfEnrollnumber.getText().length() == 0){
			i++;
			tfEnrollnumber.requestFocus();
		}
				
		return i;
	}
	
	
	// DataField 정리
	private void ClearColumn() {
		tfName.setText("");
		tfId.setText("");
		pwtfPw.setText("");
		pwtfPw2.setText("");
		tfTelno.setText("");
		tfEnrollnumber.setText("");
	}
	
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("New label");
			lblPw.setBounds(155, 274, 187, 15);
		}
		return lblPw;
	}
	
	//창을 열면 식당 회원의 정보가 보이는 것
	private void startAction() {
		//
		DbActionRmyPage dbActionRmyPage = new DbActionRmyPage(tfId);
		BeanRmyPage bean = dbActionRmyPage.startAction();
		
		tfName.setText(bean.getName());
		tfId.setText(bean.getId());
		pwtfPw.setText(bean.getPw());
		pwtfPw2.setText(bean.getPw2());
		tfTelno.setText(bean.getTelno());
		tfEnrollnumber.setText(bean.getEnrollnumber());
		
	}
	
}//-------------------------------------------------------------------------
