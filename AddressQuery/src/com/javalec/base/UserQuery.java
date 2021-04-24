package com.javalec.base;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserQuery {

	private JFrame frame;
	private JTextField tfSelection;
	private JTable Inner_table;
	private JTextField tfSeqno;
	private JTextField tfName;
	private JTextField tfNumber;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;
	
	//database 환경정의
		private final String url_mysql ="jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
		private final String id_mysql = "root";
		private final String pw_mysql = "qwer1234";
		
	//Table 환경 정의
		private final DefaultTableModel Outer_table = new DefaultTableModel();
		private JTextField tfCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserQuery window = new UserQuery();
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
	public UserQuery() {
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
				tableInit();
				searchAction();
			}
		});
		frame.setBounds(100, 100, 458, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cbselection = new JComboBox();
		cbselection.setModel(new DefaultComboBoxModel(new String[] {"\uC774\uB984 ", "\uC8FC\uC18C", "\uAD00\uACC4"}));
		cbselection.setBounds(12, 23, 114, 25);
		frame.getContentPane().add(cbselection);
		
		tfSelection = new JTextField();
		tfSelection.setBounds(138, 25, 196, 21);
		frame.getContentPane().add(tfSelection);
		tfSelection.setColumns(10);
		
		JButton btnQuery = new JButton("\uAC80\uC0C9");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionQuery();
			}
		});
		btnQuery.setBounds(346, 24, 91, 23);
		frame.getContentPane().add(btnQuery);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 66, 391, 104);
		frame.getContentPane().add(scrollPane);
		
		Inner_table = new JTable();
		Inner_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Inner_table.setModel(Outer_table); //**** 중요하다!!!!!
		scrollPane.setViewportView(Inner_table);
		
		JLabel lblNewLabel = new JLabel("seq No:");
		lblNewLabel.setBounds(22, 180, 50, 21);
		frame.getContentPane().add(lblNewLabel);
		
		tfSeqno = new JTextField();
		tfSeqno.setEditable(false);
		tfSeqno.setBounds(84, 180, 50, 21);
		frame.getContentPane().add(tfSeqno);
		tfSeqno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984:");
		lblNewLabel_1.setBounds(32, 211, 50, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setColumns(10);
		tfName.setBounds(84, 211, 96, 21);
		frame.getContentPane().add(tfName);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_2.setBounds(22, 258, 60, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfNumber = new JTextField();
		tfNumber.setEditable(false);
		tfNumber.setColumns(10);
		tfNumber.setBounds(89, 258, 316, 21);
		frame.getContentPane().add(tfNumber);
		
		JLabel lblNewLabel_3 = new JLabel("\uC8FC\uC18C:");
		lblNewLabel_3.setBounds(44, 303, 50, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfAddress = new JTextField();
		tfAddress.setEditable(false);
		tfAddress.setColumns(10);
		tfAddress.setBounds(89, 303, 316, 21);
		frame.getContentPane().add(tfAddress);
		
		JLabel lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C:");
		lblNewLabel_4.setBounds(32, 352, 50, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(89, 352, 316, 21);
		frame.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_5 = new JLabel("\uAD00\uACC4:");
		lblNewLabel_5.setBounds(44, 419, 50, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfRelation = new JTextField();
		tfRelation.setEditable(false);
		tfRelation.setColumns(10);
		tfRelation.setBounds(89, 419, 316, 21);
		frame.getContentPane().add(tfRelation);
		
		tfCount = new JTextField();
		tfCount.setBounds(342, 180, 40, 21);
		frame.getContentPane().add(tfCount);
		tfCount.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uBA85");
		lblNewLabel_6.setBounds(394, 183, 50, 15);
		frame.getContentPane().add(lblNewLabel_6);
	}
	
	//화면 Table 초기화
	private void tableInit() {
		Outer_table.addColumn("순서");
		Outer_table.addColumn("이름");
		Outer_table.addColumn("전화번호");
		Outer_table.addColumn("관계");
		Outer_table.setColumnCount(4);//-->화면에 보여지는 종류가 몇개인지
		
		int i = Outer_table.getRowCount();
		for(int j =0; j<i;j++) {
			Outer_table.removeRow(0); //-->0번을 계속 지우니까 하나씩 지워지기 반복
		}
		Inner_table.setAutoResizeMode(Inner_table.AUTO_RESIZE_OFF);
		
		int vColIndex = 0; //-->첫번째 행
		TableColumn col = Inner_table.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1; 
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2; 
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);
		
		vColIndex = 3; 
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
	}
	

		

	private void searchAction() {
		String query = "select seqno , name, telno, relation from userinfo";
		int datacount = 0;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				String [] qTxt = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				Outer_table.addRow(qTxt);
				datacount++;
			}
			conn_mysql.close();
			tfCount.setText(Integer.toString(datacount));
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//table click
	private void tableClick() {
		int i = Inner_table.getSelectedRow();
		String wkSeq = (String)Inner_table.getValueAt(i, 0);
		
		String query = "select seqno,name,telno,address,email,relation from userinfo where seqno =" + wkSeq;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				tfSeqno.setText(rs.getString(1));
				tfName.setText(rs.getString(2));
				tfNumber.setText(rs.getString(3));
				tfAddress.setText(rs.getString(4));
				tfEmail.setText(rs.getString(5));
				tfRelation.setText(rs.getString(6));
				
			}
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	
	}
	//조건검색
	private void conditionQuery() {
		int i = cbs.getSelectedIndex();
		String conditionQueryColumn = "";
		switch(i){
			case 0 :
				conditionQueryColumn = "name";
				break;
			case 1 :
				conditionQueryColumn = "address";
				break;
			case 2 :
				conditionQueryColumn = "relation";
				break;
		}
		System.out.println(conditionQueryColumn);
//		tableInit();
//		clearColumn();
//		conditionQueryAction(conditionQueryColumn);
		
		
	}
	
	private void conditionQueryAction(String columnName) {
		String query1 = "select seqno , name, telno, relation from userinfo where " +columnName;
		String query2 = "like '%"+tfSelection.getText()+"%'";
	//	System.out.println(query1+query2);
		int datacount = 0;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1+query2);
			
			while(rs.next()) {
				String [] qTxt = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				Outer_table.addRow(qTxt);
				datacount++;
			}
			conn_mysql.close();
			tfCount.setText(Integer.toString(datacount));
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void clearColumn() {
		tfSeqno.setText("");
		tfName.setText("");
		tfNumber.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		tfCount.setText("");
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//-------
