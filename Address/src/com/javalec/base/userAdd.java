package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class userAdd {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSearch;
	private JButton btnQuery;
	private JLabel lblNewLabel;
	private JTextField tfSeqno;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_2;
	private JTextField tfTelno;
	private JLabel lblNewLabel_3;
	private JTextField tfAddress;
	private JLabel lblNewLabel_4;
	private JTextField tfEmail;
	private JLabel lblNewLabel_5;
	private JTextField tfRelation;
	private JScrollPane scrollPane;
	private JTable Inner_table;

	
	

	
	//database ȯ������
			private final String url_mysql ="jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
			private final String id_mysql = "root";
			private final String pw_mysql = "qwer1234";
			
		//Table ȯ�� ����
			private final DefaultTableModel Outer_table = new DefaultTableModel();
			private JLabel lblNewLabel_6;
			private JTextField tfCount;
			private JRadioButton rdInsert;
			private JRadioButton rdEdit;
			private JRadioButton rdDelete;
			private JRadioButton rdSearch;
			private JButton btnOk;
			private final ButtonGroup buttonGroup = new ButtonGroup();

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userAdd window = new userAdd();
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
	public userAdd() {
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
		frame.setBounds(100, 100, 450, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getTfCount());
		frame.getContentPane().add(getRdInsert());
		frame.getContentPane().add(getRdEdit());
		frame.getContentPane().add(getRdDelete());
		frame.getContentPane().add(getRdSearch());
		frame.getContentPane().add(getBtnOk());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"\uC774\uB984", "\uC8FC\uC18C", "\uAD00\uACC4"}));
			cbSelection.setBounds(12, 33, 58, 25);
		}
		return cbSelection;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			tfSearch.setBounds(82, 35, 239, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("\uAC80\uC0C9");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnQuery.setBounds(333, 34, 91, 23);
		}
		return btnQuery;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("seq No:");
			lblNewLabel.setBounds(12, 217, 73, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEditable(false);
			tfSeqno.setBounds(64, 214, 96, 21);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774\uB984:");
			lblNewLabel_1.setBounds(12, 258, 50, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(64, 255, 96, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638 :");
			lblNewLabel_2.setBounds(0, 305, 73, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(64, 302, 237, 21);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC8FC\uC18C :");
			lblNewLabel_3.setBounds(12, 354, 50, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setBounds(64, 351, 360, 21);
			tfAddress.setColumns(10);
		}
		return tfAddress;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C :");
			lblNewLabel_4.setBounds(12, 404, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(64, 401, 360, 21);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uAD00\uACC4 :");
			lblNewLabel_5.setBounds(12, 443, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uBA85:");
			lblNewLabel_6.setBounds(284, 217, 50, 15);
		}
		return lblNewLabel_6;
	}
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.setBounds(306, 214, 96, 21);
			tfCount.setColumns(10);
		}
		return tfCount;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setBounds(64, 440, 360, 21);
			tfRelation.setColumns(10);
		}
		return tfRelation;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 68, 390, 132);
			scrollPane.setViewportView(getInner_table());
		}
		return scrollPane;
	}
	private JTable getInner_table() {
		if (Inner_table == null) {
			Inner_table = new JTable();
			Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_table.setModel(Outer_table); //**** �߿��ϴ�!!!!!
			scrollPane.setViewportView(Inner_table);
			Inner_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
		}
		return Inner_table;
	}

private JRadioButton getRdInsert() {
	if (rdInsert == null) {
		rdInsert = new JRadioButton("\uC785\uB825");
		rdInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(1);
			}
		});
		buttonGroup.add(rdInsert);
		rdInsert.setBounds(75, 6, 58, 23);
	}
	return rdInsert;
}
private JRadioButton getRdEdit() {
	if (rdEdit == null) {
		rdEdit = new JRadioButton("\uC218\uC815");
		rdEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(1);
			}
		});
		buttonGroup.add(rdEdit);
		rdEdit.setBounds(137, 6, 58, 23);
	}
	return rdEdit;
}
private JRadioButton getRdDelete() {
	if (rdDelete == null) {
		rdDelete = new JRadioButton("\uC0AD\uC81C");
		rdDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(0);
			}
		});
		buttonGroup.add(rdDelete);
		rdDelete.setBounds(199, 6, 58, 23);
	}
	return rdDelete;
}
private JRadioButton getRdSearch() {
	if (rdSearch == null) {
		rdSearch = new JRadioButton("\uAC80\uC0C9");
		rdSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(0);
			}
		});
		rdSearch.setSelected(true);
		buttonGroup.add(rdSearch);
		rdSearch.setBounds(261, 6, 58, 23);
	}
	return rdSearch;
}
private JButton getBtnOk() {
	if (btnOk == null) {
		btnOk = new JButton("OK");
		btnOk.setBounds(333, 482, 91, 23);
	}
	return btnOk;
}
	//���̺� ����&����
	
	private void editable(int i) {
		if(rdInsert.isSelected()==true) {
			tfName.setEditable(true);
			tfTelno.setEditable(true);
			tfAddress.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);
			btnQuery.setVisible(true);
			btnOk.setVisible(true);
			
		}else if(rdEdit.isSelected()==true) {
			tfName.setEditable(true);
			tfTelno.setEditable(true);
			tfAddress.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);
			btnQuery.setVisible(true);
			btnOk.setVisible(true);
			
		}else if(rdDelete.isSelected()==true) {
			tfName.setEditable(true);
			tfTelno.setEditable(true);
			tfAddress.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);
			btnQuery.setVisible(true);
			btnOk.setVisible(true);
			
		}else if(rdSearch.isSelected()==true) {
			tfName.setEditable(true);
			tfTelno.setEditable(true);
			tfAddress.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);
			btnQuery.setVisible(true);
			btnOk.setVisible(true);
		}else{
			
		}
	}



	private void tableInit() {
		Outer_table.addColumn("����");
		Outer_table.addColumn("�̸�");
		Outer_table.addColumn("��ȭ��ȣ");
		Outer_table.addColumn("����");
		Outer_table.setColumnCount(4);//-->ȭ�鿡 �������� ������ �����
		
		int i = Outer_table.getRowCount();
		for(int j =0; j<i;j++) {
			Outer_table.removeRow(0); //-->0���� ��� ����ϱ� �ϳ��� �������� �ݺ�
		}
		
		Inner_table.setAutoResizeMode(Inner_table.AUTO_RESIZE_OFF);
		
		int vColIndex = 0; //-->ù��° ��
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
	
	//�˻�
	private void searchAction() {
		String query = "select seqno , name, telno, relation from userinfo ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn_mysql = (java.sql.Connection) DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
		
				ResultSet rs = stmt_mysql.executeQuery(query);
		
		while(rs.next()) {
			String [] qTxt = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
			Outer_table.addRow(qTxt);
		}
			conn_mysql.close();
			
			
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
				java.sql.Connection conn_mysql = (java.sql.Connection) DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
			
				ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				tfSeqno.setText(rs.getString(1));
				tfName.setText(rs.getString(2));
				tfTelno.setText(rs.getString(3));
				tfAddress.setText(rs.getString(4));
				tfEmail.setText(rs.getString(5));
				tfRelation.setText(rs.getString(6));
				
			}
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}



	}
	//���ǰ˻�
	private void conditionQuery() {
		int i = cbSelection.getSelectedIndex();
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
		//System.out.println(conditionQueryColumn);
		
		clearColumn();
		//System.out.println(000);
		tableInit();
		//System.out.println(111);
		conditionQueryAction(conditionQueryColumn);
	}

	private void conditionQueryAction(String columnName) {
//		System.out.println(columnName);
		String query1 = "select seqno , name, telno, relation from userinfo where " +columnName;
		String query2 = " like '%"+tfSearch.getText()+"%'";
		//System.out.println(3);
		System.out.println(query1+query2);
		int datacount = 0;
		//System.out.println(2);
		try {
			//System.out.println(1);
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn_mysql = (java.sql.Connection) DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
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
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		tfCount.setText("");
	}
	
	private void search() {
		String query = "select seqno , name, telno, relation from userinfo ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn_mysql = (java.sql.Connection) DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
		
				ResultSet rs = stmt_mysql.executeQuery(query);
		
		while(rs.next()) {
			String [] qTxt = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
			Outer_table.addRow(qTxt);
		}
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	//OK��ư
	private void okAction() {
		if(rdInsert.isSelected()==true) {
			//System.out.println(1);
			PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
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
		if(rdEdit.isSelected()==true) {
			//System.out.println(2);
			PreparedStatement ps = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String query1 = "Update userinfo set name = ?,telno=?,address=?,email=?,relation=?";
				String query2 = " where seqno=? ";
				
				ps = conn_mysql.prepareStatement(query1+query2);
				ps.setString(1, tfName.getText());
				ps.setString(2, tfTelno.getText());
				ps.setString(3, tfAddress.getText());
				ps.setString(4, tfEmail.getText());
				ps.setString(5, tfRelation.getText());
				ps.setString(6, tfSeqno.getText());
				
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText()+"���� ������ �����Ǿ����ϴ�.");
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(rdDelete.isSelected()==true) {
			//System.out.println(3);
			PreparedStatement ps = null;
			int i = Inner_table.getSelectedRow();
			String str = (String) Inner_table.getValueAt(i, 0);
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				String query = "delete from userinfo where seqno = " + str;
				
				
				ps = conn_mysql.prepareStatement(query);
				ps.executeUpdate();
				
				conn_mysql.close();
				
				JOptionPane.showMessageDialog(null, tfName.getText()+"���� ������ �����Ǿ����ϴ�.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
}//-----