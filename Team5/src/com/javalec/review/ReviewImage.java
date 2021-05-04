package com.javalec.review;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.base.ShareVariable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewImage {

	public JFrame frame;
	private JLabel lbl;
	private JLabel lblImage;
	private JButton btnClose;

	String id;
	String wkId;
	String wkDate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewImage window = new ReviewImage();
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
	public ReviewImage() {
		initialize();
	}
	public ReviewImage(String id, String wkId, String wkDate) {
		this.id = id;
		this.wkId = wkId;
		this.wkDate = wkDate;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				image();
			}
		});
		frame.setTitle("영수증");
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLbl());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getBtnClose());
	}

	private JLabel getLbl() {
		if (lbl == null) {
			lbl = new JLabel("");
			lbl.setBounds(21, 17, 412, 16);
		}
		return lbl;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/leedohui/Desktop/null.png"));
			lblImage.setBounds(21, 45, 406, 211);
		}
		return lblImage;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
				}
			});
			btnClose.setBounds(316, 268, 117, 29);
		}
		return btnClose;
	}
	
	
	private void image() {
		
		// Image처리
        // File name이 틀려야 즉각 보여주기가 가능하여   
        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
		
		DbActionReview dbActionReview = new DbActionReview();
		BeanReview bean = dbActionReview.TableClick(wkId, wkDate);
		
		lbl.setText(wkId + "님의 영수증 리뷰입니다.");
		
		String filePath = Integer.toString(ShareVariable.filename);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
	}
	
}
