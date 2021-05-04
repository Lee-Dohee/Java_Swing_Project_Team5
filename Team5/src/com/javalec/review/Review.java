package com.javalec.review;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.restaurant_user.DbActionRestaurant_User;
import com.javalec.restaurant_user.ViewRestaurant_User;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Review {

	public JFrame frame;
	private JComboBox cbStar;
	private JTextArea taContent;
	private JButton btnOK;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfMenu;
	private JButton btnCancel;
	
	String wkNum;
	String id;
	private JButton btnFile;
	private JTextField tfFile;
	private JLabel lblImage;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review window = new Review();
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
	public Review() {
		initialize();
	}
	public Review(String wkNum, String id) {
		this.wkNum = wkNum;
		this.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("리뷰 등록");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbStar());
		frame.getContentPane().add(getTaContent());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfMenu());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getBtnFile());
		frame.getContentPane().add(getTfFile());
		frame.getContentPane().add(getLblImage());
	}
	private JComboBox getCbStar() {
		if (cbStar == null) {
			cbStar = new JComboBox();
			cbStar.setModel(new DefaultComboBoxModel(new String[] {"★", "★★", "★★★", "★★★★", "★★★★★"}));
			cbStar.setBounds(28, 20, 139, 27);
			cbStar.setForeground(new Color(255, 187, 0));
		}
		return cbStar;
	}
	private JTextArea getTaContent() {
		if (taContent == null) {
			taContent = new JTextArea();
			taContent.setBounds(28, 124, 397, 120);
		}
		return taContent;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						register();
						frame.setVisible(false);
						ViewRestaurant_User testRestaurant = new ViewRestaurant_User(wkNum, id);
						testRestaurant.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(frame, "리뷰항목을 모두 입력하세요!",
								"리뷰 입력", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnOK.setBounds(308, 440, 117, 29);
		}
		return btnOK;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("리뷰 :");
			lblNewLabel.setBounds(28, 98, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("영수증 :");
			lblNewLabel_1.setBounds(28, 261, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("메뉴 :");
			lblNewLabel_2.setBounds(28, 64, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfMenu() {
		if (tfMenu == null) {
			tfMenu = new JTextField();
			tfMenu.setBounds(68, 60, 357, 26);
			tfMenu.setColumns(10);
		}
		return tfMenu;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ViewRestaurant_User testRestaurant = new ViewRestaurant_User(wkNum, id);
					testRestaurant.frame.setVisible(true);
				}
			});
			btnCancel.setBounds(179, 440, 117, 29);
		}
		return btnCancel;
	}
	// 이미지 첨부
	private JButton getBtnFile() {
		if (btnFile == null) {
			btnFile = new JButton("파일 첨부");
			btnFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filePath();
				}
			});
			btnFile.setBounds(308, 255, 117, 29);
		}
		return btnFile;
	}
	private JTextField getTfFile() {
		if (tfFile == null) {
			tfFile = new JTextField();
			tfFile.setBounds(75, 256, 221, 26);
			tfFile.setColumns(10);
		}
		return tfFile;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/leedohui/Desktop/null.png"));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(28, 289, 397, 139);
		}
		return lblImage;
	}
	
	
	
	
	
	// 콤보박스 선택한 것 등록할 정보 판단 후 등록
	private void register() {
		
		PreparedStatement ps = null;
		
		int i = cbStar.getSelectedIndex();	// 콤보를 몇번째를 선택했니?
		String star = "";
		
		switch(i) {
			case 0:
				star = "★";
				break;
			case 1:
				star = "★★";
				break;
			case 2:
				star = "★★★";
				break;
			case 3:
				star = "★★★★";
				break;
			case 4:
				star = "★★★★★";
				break;
			default:
				break;
		}
		registerAction(star);
	}
	
	// 리뷰 등로 액션
	private void registerAction(String star) {
		
		
		String u_id = id;	// 해당 유저로 설정
		String r_code = wkNum;
		String menu = tfMenu.getText().trim();
		String content = taContent.getText().trim();
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFile.getText());
		try {
			input = new FileInputStream(file);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		DbActionReview dbActionReview = new DbActionReview(u_id, r_code, menu, content, input);
		
		boolean msg = dbActionReview.registerAction(star);
		
		if (msg == true) {
			JOptionPane.showMessageDialog(frame, "리뷰 등록이 완료되었습니다!",
                  "입력 완료!", 
                  JOptionPane.INFORMATION_MESSAGE);  
		}else {
			JOptionPane.showMessageDialog(frame, "리뷰 등록에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
                  "Critical Error!", 
                  JOptionPane.ERROR_MESSAGE);    
		}          
	}
	
	
	// 영수증 이미지 선택
	private void filePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(frame);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(frame, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFile.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	
		
	}
	
	// 값을 다 썼나 체크
	private int insertFieldCheck(){
		int i = 0;
		if(tfMenu.getText().length() == 0){
			i++;
			tfMenu.requestFocus();
		}
		if(taContent.getText().length() == 0){
			i++;
			taContent.requestFocus();
		}	
		return i;
	}
	
	
}
