package com.javalec.RmainPagemain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rmainpage {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnRfoodEnroll;
	private JButton btnRmenuEnroll;
	private JButton btnRmypage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rmainpage window = new Rmainpage();
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
	public Rmainpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnRfoodEnroll());
		frame.getContentPane().add(getBtnRmenuEnroll());
		frame.getContentPane().add(getBtnRmypage());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("YOGI,YOGO");
			lblNewLabel.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 28));
			lblNewLabel.setBounds(127, 80, 219, 63);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("식당 메인페이지");
			lblNewLabel_1.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 19));
			lblNewLabel_1.setBounds(152, 113, 170, 63);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnRfoodEnroll() {
		if (btnRfoodEnroll == null) {
			btnRfoodEnroll = new JButton("식당등록");
			btnRfoodEnroll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					foodClickAction();
				}
			});
			btnRfoodEnroll.setBackground(new Color(51, 102, 255));
			btnRfoodEnroll.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 16));
			btnRfoodEnroll.setBounds(91, 266, 257, 37);
		}
		return btnRfoodEnroll;
	}
	public void foodClickAction() {
		
	}
	private JButton getBtnRmenuEnroll() {
		if (btnRmenuEnroll == null) {
			btnRmenuEnroll = new JButton("메뉴등록");
			btnRmenuEnroll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					menuClickAction();
				}
			});
			btnRmenuEnroll.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 16));
			btnRmenuEnroll.setBackground(new Color(51, 102, 255));
			btnRmenuEnroll.setBounds(91, 199, 257, 37);
		}
		return btnRmenuEnroll;
	}
	//클릭하면 화면을 이동시킨다.
	public void menuClickAction() {
		
		if(true) {
			
		}
	}
	
	private JButton getBtnRmypage() {
		if (btnRmypage == null) {
			btnRmypage = new JButton("마이페이지");
			btnRmypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myClickAction();
				}
			});
			btnRmypage.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 16));
			btnRmypage.setBackground(new Color(51, 102, 255));
			btnRmypage.setBounds(91, 338, 257, 37);
		}
		return btnRmypage;
	}
	
	public void myClickAction(){
		
	}
	
	
}//==================================================
