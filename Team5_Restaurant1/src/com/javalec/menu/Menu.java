package com.javalec.menu;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.restaurant_owner.ViewRestaurant_Owner;

public class Menu {

	public JFrame frame;
	private JCheckBox chkEggs;
	private JCheckBox chkMilk;
	private JCheckBox chkBuckwheat;
	private JCheckBox chkPeanut;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfContent;
	private JButton btnOK;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
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
	private JButton btnCancle;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;

	String wkNum;
	String id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}
	public Menu(String wkNum, String id) {
		this.id = id;
		this.wkNum = wkNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("메뉴 등록");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 366, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getChkEggs());
		frame.getContentPane().add(getChkMilk());
		frame.getContentPane().add(getChkBuckwheat());
		frame.getContentPane().add(getChkPeanut());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfPrice());
		frame.getContentPane().add(getTfContent());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
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
		frame.getContentPane().add(getBtnCancle());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_2());
	}

	private JCheckBox getChkEggs() {
		if (chkEggs == null) {
			chkEggs = new JCheckBox("eggs");
			chkEggs.setBounds(24, 85, 67, 23);
		}
		return chkEggs;
	}
	private JCheckBox getChkMilk() {
		if (chkMilk == null) {
			chkMilk = new JCheckBox("milk");
			chkMilk.setBounds(134, 85, 67, 23);
		}
		return chkMilk;
	}
	private JCheckBox getChkBuckwheat() {
		if (chkBuckwheat == null) {
			chkBuckwheat = new JCheckBox("buckwheat");
			chkBuckwheat.setBounds(232, 85, 107, 23);
		}
		return chkBuckwheat;
	}
	private JCheckBox getChkPeanut() {
		if (chkPeanut == null) {
			chkPeanut = new JCheckBox("peanut");
			chkPeanut.setBounds(24, 118, 80, 23);
		}
		return chkPeanut;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("알레르기 :");
			lblNewLabel.setBounds(30, 57, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("메뉴등록");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(142, 23, 78, 23);
		}
		return lblNewLabel_1;
	}
	private JCheckBox getChkMackerel() {
		if (chkMackerel == null) {
			chkMackerel = new JCheckBox("mackerel");
			chkMackerel.setBounds(24, 153, 98, 23);
		}
		return chkMackerel;
	}
	private JCheckBox getChkPork() {
		if (chkPork == null) {
			chkPork = new JCheckBox("pork");
			chkPork.setBounds(24, 188, 80, 23);
		}
		return chkPork;
	}
	private JCheckBox getChkSo2() {
		if (chkSo2 == null) {
			chkSo2 = new JCheckBox("so2");
			chkSo2.setBounds(24, 223, 80, 23);
		}
		return chkSo2;
	}
	private JCheckBox getChkBeef() {
		if (chkBeef == null) {
			chkBeef = new JCheckBox("beef");
			chkBeef.setBounds(24, 258, 80, 23);
		}
		return chkBeef;
	}
	private JCheckBox getChkSoybean() {
		if (chkSoybean == null) {
			chkSoybean = new JCheckBox("soybean");
			chkSoybean.setBounds(134, 118, 86, 23);
		}
		return chkSoybean;
	}
	private JCheckBox getChkWheat() {
		if (chkWheat == null) {
			chkWheat = new JCheckBox("wheat");
			chkWheat.setBounds(232, 118, 107, 23);
		}
		return chkWheat;
	}
	private JCheckBox getChkShrimp() {
		if (chkShrimp == null) {
			chkShrimp = new JCheckBox("shrimp");
			chkShrimp.setBounds(232, 153, 107, 23);
		}
		return chkShrimp;
	}
	private JCheckBox getChkTomato() {
		if (chkTomato == null) {
			chkTomato = new JCheckBox("tomato");
			chkTomato.setBounds(232, 188, 107, 23);
		}
		return chkTomato;
	}
	private JCheckBox getChkChicken() {
		if (chkChicken == null) {
			chkChicken = new JCheckBox("chicken");
			chkChicken.setBounds(232, 223, 107, 23);
		}
		return chkChicken;
	}
	private JCheckBox getChkShellfish() {
		if (chkShellfish == null) {
			chkShellfish = new JCheckBox("shellfish");
			chkShellfish.setBounds(232, 258, 107, 23);
		}
		return chkShellfish;
	}
	private JCheckBox getChkCrab() {
		if (chkCrab == null) {
			chkCrab = new JCheckBox("crab");
			chkCrab.setBounds(134, 153, 67, 23);
		}
		return chkCrab;
	}
	private JCheckBox getChkPeach() {
		if (chkPeach == null) {
			chkPeach = new JCheckBox("peach");
			chkPeach.setBounds(134, 188, 86, 23);
		}
		return chkPeach;
	}
	private JCheckBox getChkWalnut() {
		if (chkWalnut == null) {
			chkWalnut = new JCheckBox("walnut");
			chkWalnut.setBounds(134, 223, 78, 23);
		}
		return chkWalnut;
	}
	private JCheckBox getChkSquid() {
		if (chkSquid == null) {
			chkSquid = new JCheckBox("squid");
			chkSquid.setBounds(134, 258, 67, 23);
		}
		return chkSquid;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(93, 294, 246, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setBounds(93, 332, 246, 26);
			tfPrice.setColumns(10);
		}
		return tfPrice;
	}
	private JTextField getTfContent() {
		if (tfContent == null) {
			tfContent = new JTextField();
			tfContent.setBounds(93, 370, 246, 26);
			tfContent.setColumns(10);
		}
		return tfContent;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("등록");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						register();
						frame.setVisible(false);
						ViewRestaurant_Owner viewRestaurant = new ViewRestaurant_Owner(wkNum, id);
						viewRestaurant.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(frame, "메뉴 항목을 모두 입력하세요!",
								"메뉴 입력", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnOK.setBounds(222, 408, 117, 29);
		}
		return btnOK;
	}
	private JButton getBtnCancle() {
		if (btnCancle == null) {
			btnCancle = new JButton("취소");
			btnCancle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ViewRestaurant_Owner testRestaurant = new ViewRestaurant_Owner(wkNum, id);
					testRestaurant.frame.setVisible(true);
				}
			});
			btnCancle.setBounds(103, 408, 117, 29);
		}
		return btnCancle;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("메뉴 이름 :");
			lblNewLabel_2.setBounds(30, 299, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("메뉴 가격 :");
			lblNewLabel_2_1.setBounds(30, 337, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("메뉴 설명 :");
			lblNewLabel_2_2.setBounds(30, 375, 61, 16);
		}
		return lblNewLabel_2_2;
	}
	
	
	
	
	// ok버튼 누르면 메뉴 등록
	private void register() {
		
		String name = tfName.getText().trim();
		String price = tfPrice.getText().trim();
		String content = tfContent.getText().trim();
		
		DbActionMenu dbActionMenu = new DbActionMenu(name, price, content, chkEggs, chkMilk, chkBuckwheat, chkPeanut, chkSoybean, chkWheat, chkMackerel, chkCrab, chkShrimp, chkPork, chkPeach, chkTomato, chkSo2, chkWalnut, chkChicken, chkBeef, chkSquid, chkShellfish);
		boolean msg = dbActionMenu.registerMenu(wkNum);
		
		if(msg == true) {
			JOptionPane.showMessageDialog(frame, tfName.getText() + " 메뉴 등록이 완료되었습니다!",
	                "등록 완료!", 
	                JOptionPane.INFORMATION_MESSAGE);   
		}else {
			JOptionPane.showMessageDialog(frame, " 메뉴 등록에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
	                "Critical Error!", 
	                JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// 값을 다 썼나 체크
	private int insertFieldCheck(){
		int i = 0;
		if(tfName.getText().length() == 0){
			i++;
			tfName.requestFocus();
		}
		if(tfPrice.getText().length() == 0){
			i++;
			tfPrice.requestFocus();
		}
		if(tfContent.getText().length() == 0){
			i++;
			tfContent.requestFocus();
		}
		return i;
	}
}
