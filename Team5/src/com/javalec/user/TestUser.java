package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.menu.BeanMenu;
import com.javalec.menu.DbActionMenu;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TestUser {

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfPw;
	private JTextField tfName;
	private JTextField tfTelno;
	private JTextField tfEmail;
	private JButton btnOK;
	private JCheckBox chkEggs;
	private JCheckBox chkMilk;
	private JCheckBox chkBuckwheat;
	private JCheckBox chkPeanut;
	private JCheckBox chkMackerel;
	private JCheckBox chkPork;
	private JCheckBox chkSo2;
	private JCheckBox chkBeef;
	private JCheckBox chkSoybean;
	private JCheckBox chkWheat;
	private JCheckBox chkShrimp;
	private JCheckBox chkTomato;
	private JCheckBox chkChicken;
	private JCheckBox chkShellfish;
	private JCheckBox chkCrab;
	private JCheckBox chkPeach;
	private JCheckBox chkWalnut;
	private JCheckBox chkSquid;
	private JTextField tfPwChk;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUser window = new TestUser();
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
	public TestUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입 테스트");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 367, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfPw());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getChkEggs());
		frame.getContentPane().add(getChkMilk());
		frame.getContentPane().add(getChkBuckwheat());
		frame.getContentPane().add(getChkPeanut());
		frame.getContentPane().add(getChkMackerel());
		frame.getContentPane().add(getChkPork());
		frame.getContentPane().add(getChkSo2());
		frame.getContentPane().add(getChkBeef());
		frame.getContentPane().add(getChkSoybean());
		frame.getContentPane().add(getChkWheat());
		frame.getContentPane().add(getChkShrimp());
		frame.getContentPane().add(getChkTomato());
		frame.getContentPane().add(getChkChicken());
		frame.getContentPane().add(getChkShellfish());
		frame.getContentPane().add(getChkCrab());
		frame.getContentPane().add(getChkPeach());
		frame.getContentPane().add(getChkWalnut());
		frame.getContentPane().add(getChkSquid());
		frame.getContentPane().add(getTfPwChk());
		frame.getContentPane().add(getLblNewLabel());
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(24, 101, 315, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setBounds(24, 139, 315, 26);
			tfPw.setColumns(10);
		}
		return tfPw;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(24, 63, 315, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(24, 253, 315, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(24, 215, 315, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					join();
				}
			});
			btnOK.setBounds(222, 507, 117, 29);
		}
		return btnOK;
	}
	private JCheckBox getChkEggs() {
		if (chkEggs == null) {
			chkEggs = new JCheckBox("eggs");
			chkEggs.setBounds(24, 305, 67, 23);
		}
		return chkEggs;
	}
	private JCheckBox getChkMilk() {
		if (chkMilk == null) {
			chkMilk = new JCheckBox("milk");
			chkMilk.setBounds(134, 305, 67, 23);
		}
		return chkMilk;
	}
	private JCheckBox getChkBuckwheat() {
		if (chkBuckwheat == null) {
			chkBuckwheat = new JCheckBox("buckwheat");
			chkBuckwheat.setBounds(232, 305, 107, 23);
		}
		return chkBuckwheat;
	}
	private JCheckBox getChkPeanut() {
		if (chkPeanut == null) {
			chkPeanut = new JCheckBox("peanut");
			chkPeanut.setBounds(24, 338, 80, 23);
		}
		return chkPeanut;
	}
	private JCheckBox getChkMackerel() {
		if (chkMackerel == null) {
			chkMackerel = new JCheckBox("mackerel");
			chkMackerel.setBounds(24, 373, 98, 23);
		}
		return chkMackerel;
	}
	private JCheckBox getChkPork() {
		if (chkPork == null) {
			chkPork = new JCheckBox("pork");
			chkPork.setBounds(24, 408, 80, 23);
		}
		return chkPork;
	}
	private JCheckBox getChkSo2() {
		if (chkSo2 == null) {
			chkSo2 = new JCheckBox("so2");
			chkSo2.setBounds(24, 443, 80, 23);
		}
		return chkSo2;
	}
	private JCheckBox getChkBeef() {
		if (chkBeef == null) {
			chkBeef = new JCheckBox("beef");
			chkBeef.setBounds(24, 478, 80, 23);
		}
		return chkBeef;
	}
	private JCheckBox getChkSoybean() {
		if (chkSoybean == null) {
			chkSoybean = new JCheckBox("soybean");
			chkSoybean.setBounds(134, 338, 86, 23);
		}
		return chkSoybean;
	}
	private JCheckBox getChkWheat() {
		if (chkWheat == null) {
			chkWheat = new JCheckBox("wheat");
			chkWheat.setBounds(232, 338, 107, 23);
		}
		return chkWheat;
	}
	private JCheckBox getChkShrimp() {
		if (chkShrimp == null) {
			chkShrimp = new JCheckBox("shrimp");
			chkShrimp.setBounds(232, 373, 107, 23);
		}
		return chkShrimp;
	}
	private JCheckBox getChkTomato() {
		if (chkTomato == null) {
			chkTomato = new JCheckBox("tomato");
			chkTomato.setBounds(232, 408, 107, 23);
		}
		return chkTomato;
	}
	private JCheckBox getChkChicken() {
		if (chkChicken == null) {
			chkChicken = new JCheckBox("chicken");
			chkChicken.setBounds(232, 443, 107, 23);
		}
		return chkChicken;
	}
	private JCheckBox getChkShellfish() {
		if (chkShellfish == null) {
			chkShellfish = new JCheckBox("shellfish");
			chkShellfish.setBounds(232, 478, 107, 23);
		}
		return chkShellfish;
	}
	private JCheckBox getChkCrab() {
		if (chkCrab == null) {
			chkCrab = new JCheckBox("crab");
			chkCrab.setBounds(134, 373, 67, 23);
		}
		return chkCrab;
	}
	private JCheckBox getChkPeach() {
		if (chkPeach == null) {
			chkPeach = new JCheckBox("peach");
			chkPeach.setBounds(134, 408, 86, 23);
		}
		return chkPeach;
	}
	private JCheckBox getChkWalnut() {
		if (chkWalnut == null) {
			chkWalnut = new JCheckBox("walnut");
			chkWalnut.setBounds(134, 443, 78, 23);
		}
		return chkWalnut;
	}
	private JCheckBox getChkSquid() {
		if (chkSquid == null) {
			chkSquid = new JCheckBox("squid");
			chkSquid.setBounds(134, 478, 67, 23);
		}
		return chkSquid;
	}
	private JTextField getTfPwChk() {
		if (tfPwChk == null) {
			tfPwChk = new JTextField();
			tfPwChk.setColumns(10);
			tfPwChk.setBounds(24, 177, 315, 26);
		}
		return tfPwChk;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(132, 19, 98, 26);
		}
		return lblNewLabel;
	}
	
	// 회원가입
	private void join() {
		
		String id = tfId.getText().trim();
		String pw = tfPw.getText().trim();
		String name = tfName.getText().trim();
		String telno = tfTelno.getText().trim();
		String email = tfEmail.getText().trim();
		
		DbActionUser dbActionUser = new DbActionUser(id, pw, name, telno, email, chkEggs, chkMilk, chkBuckwheat, chkPeanut, chkSoybean, chkWheat, chkMackerel, chkCrab, chkShrimp, chkPork, chkPeach, chkTomato, chkSo2, chkWalnut, chkChicken, chkBeef, chkSquid, chkShellfish);
		boolean msg = dbActionUser.joinUser();
		
		if(msg == true) {
			JOptionPane.showMessageDialog(null, tfName.getText() + "님 회원가입이 완료되었습니다!",
	                "등록 완료!", 
	                JOptionPane.INFORMATION_MESSAGE);   
		}else {
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 회원가입에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
	                "Critical Error!", 
	                JOptionPane.ERROR_MESSAGE);
		}

	}
	
}
