package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;

public class AddressInsert {

	private JFrame frame;
	private JTextField tfName;
	
	private JTextField tfTelno;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;
	
	//database ȯ������
	private final String url_mysql ="jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert window = new AddressInsert();
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
	public AddressInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC131\uBA85");
		lblNewLabel.setBounds(35, 36, 50, 15);
		frame.getContentPane().add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(92, 33, 96, 21);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JButton btnOk = new JButton("\uC785\uB825");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		btnOk.setBounds(304, 218, 91, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1.setBounds(24, 79, 50, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_2.setBounds(35, 117, 50, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uC790\uC6B0\uD3B8");
		lblNewLabel_3.setBounds(24, 154, 50, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAD00\uACC4");
		lblNewLabel_4.setBounds(24, 188, 50, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfTelno = new JTextField();
		tfTelno.setBounds(92, 76, 123, 21);
		frame.getContentPane().add(tfTelno);
		tfTelno.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(92, 114, 303, 21);
		frame.getContentPane().add(tfAddress);
		tfAddress.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(92, 151, 178, 21);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfRelation = new JTextField();
		tfRelation.setBounds(92, 185, 303, 21);
		frame.getContentPane().add(tfRelation);
		tfRelation.setColumns(10);
	}
	private void check() {
		if(tfName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�̸��� �ٽ� �Է��ϼ���");
		}else if(tfTelno.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �ٽ� �Է��ϼ���");
		}else if(tfAddress.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�ּҸ� �ٽ� �Է��ϼ���");
		}else if(tfEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�̸����� �ٽ� �Է��ϼ���");
		}else if(tfRelation.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "���踦 �ٽ� �Է��ϼ���");
		}else{
			insertAction();	
		}
	
		
	}
	private void insertAction() { //����� ���� �Է�
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into userinfo(name,telno,address,email,relation)";
			String query1 = " values (?,?,?,?,?)";
			
			ps = conn_mysql.prepareStatement(query+query1);
			ps.setString(1, tfName.getText().trim());
			ps.setString(2, tfTelno.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			ps.executeUpdate();
			
			conn_mysql.close();
			
			JOptionPane.showMessageDialog(null, tfName.getText()+"���� ������ �ԷµǾ����ϴ�.");
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}//------ 