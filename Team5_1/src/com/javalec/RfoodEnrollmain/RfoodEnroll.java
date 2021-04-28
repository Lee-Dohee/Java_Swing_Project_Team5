package com.javalec.RfoodEnroll;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.javalec.Restaurantenroll.DbActionRfoodEnroll;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RfoodEnroll {

	private JFrame frame;
	private JComboBox<?> cbNeighborhood;
	private JComboBox<?> cbPeople;
	private JComboBox<?> cbCategories;
	private JTextField tfName;
	private JTextField tfAddress;
	private JTextField tfTelno;
	private JTextField tfEnrollnumber;
	private JButton btnEnroll;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RfoodEnroll window = new RfoodEnroll();
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
	public RfoodEnroll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbNeighborhood());
		frame.getContentPane().add(getCbPeople());
		frame.getContentPane().add(getCbCategories());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfEnrollnumber());
		frame.getContentPane().add(getBtnEnroll());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getLblNewLabel_7());
		frame.getContentPane().add(getLblNewLabel_8());
	}
	private JComboBox getCbNeighborhood() {
		if (cbNeighborhood == null) {
			cbNeighborhood = new JComboBox();
			cbNeighborhood.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			cbNeighborhood.setModel(new DefaultComboBoxModel(new String[] {"한남동", "이태원", "역삼동", "연남동", "잠실"}));
			cbNeighborhood.setBackground(Color.WHITE);
			cbNeighborhood.setBounds(133, 111, 261, 25);
		}
		return cbNeighborhood;
	}

	private JComboBox getCbPeople() {
		if (cbPeople == null) {
			cbPeople = new JComboBox();
			cbPeople.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			cbPeople.setModel(new DefaultComboBoxModel(new String[] {"1인", "2인", "3인", "4인", "5인이상"}));
			cbPeople.setBackground(Color.WHITE);
			cbPeople.setBounds(133, 146, 261, 25);
		}
		return cbPeople;
	}

	private JComboBox getCbCategories() {
		if (cbCategories == null) {
			cbCategories = new JComboBox();
			cbCategories.setModel(new DefaultComboBoxModel(new String[] {"한식", "중식", "일식", "양식", "디저트", "분식"}));
			cbCategories.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			cbCategories.setBackground(Color.WHITE);
			cbCategories.setBounds(133, 180, 261, 25);
		}
		return cbCategories;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(81, 215, 313, 39);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(81, 275, 313, 39);
		}
		return tfAddress;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(151, 334, 243, 39);
		}
		return tfTelno;
	}
	private JTextField getTfEnrollnumber() {
		if (tfEnrollnumber == null) {
			tfEnrollnumber = new JTextField();
			tfEnrollnumber.setColumns(10);
			tfEnrollnumber.setBounds(151, 391, 243, 39);
		}
		return tfEnrollnumber;
	}
	private JButton getBtnEnroll() {
		if (btnEnroll == null) {
			btnEnroll = new JButton("등록");
			btnEnroll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EnrollQuery();
				}
			});
			btnEnroll.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
			btnEnroll.setBackground(new Color(153, 204, 255));
			btnEnroll.setBounds(81, 440, 313, 38);
		}
		return btnEnroll;
	}
	
	private void EnrollQuery(){
		String enrollnumber = tfEnrollnumber.getText().trim();
		String name = tfName.getText().trim();
		String address = tfAddress.getText().trim();
		String telno = tfTelno.getText().trim();
//		String neighborhood = cbNeighborhood.getActionCommand().trim();
		String neighborhood = cbNeighborhood.getSelectedItem().toString();
		String people = cbPeople.getSelectedItem().toString();
		String categories = cbCategories.getSelectedItem().toString();
		//String neighborhood = cbNeighborhood.getSelectedObjects().toString();
		//String people = cbPeople.getSelectedObjects().toString();
		//String categories = cbCategories.getSelectedObjects().toString();
		
		DbActionRfoodEnroll dbActionRfoodEnroll = new DbActionRfoodEnroll(enrollnumber,name,address,telno,neighborhood,people,categories);
			boolean msg = dbActionRfoodEnroll.EnrollQuery();
				if(msg == true) {
				//	JOptionPane.showInputDialog(this, tfName.getText()+" 님의 정보가 입력되었습니다!"); 
				}else {
				// JOptionPane.showInputDialog(this, "DB 자료 입력 중 에러가 발생했습니다! \n 시스템관리자에게 문의하세요!");   
					}
		
	}

	private void ClearColumn() {
		// TODO Auto-generated method stub
		tfEnrollnumber.setText("");
		tfName.setText("");
		tfAddress.setText("");
		tfTelno.setText("");
	}


	
	
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel.setBounds(19, 227, 50, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("주소");
			lblNewLabel_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(19, 287, 50, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호");
			lblNewLabel_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(19, 346, 50, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("사업자등록번호");
			lblNewLabel_3.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(12, 403, 114, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("동네");
			lblNewLabel_4.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(36, 116, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("인원");
			lblNewLabel_5.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(36, 151, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("음식");
			lblNewLabel_6.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(36, 187, 50, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("YOGI,YOGO");
			lblNewLabel_7.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 30));
			lblNewLabel_7.setBounds(113, 21, 204, 39);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("맛집 등록");
			lblNewLabel_8.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
			lblNewLabel_8.setBounds(151, 59, 195, 42);
		}
		return lblNewLabel_8;
	}
}//----------------------------------
