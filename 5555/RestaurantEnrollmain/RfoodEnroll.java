package com.javalec.RestaurantEnrollmain;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.javalec.Restaurantenrollfunction.DbActionRfoodEnroll;

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
import javax.swing.JPasswordField;

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
	private JTextField tfId;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JPasswordField pwtfpw;
	
	
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
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getLblNewLabel_9());
		frame.getContentPane().add(getLblNewLabel_10());
		frame.getContentPane().add(getPwtfpw());
	}
	private JComboBox getCbNeighborhood() {
		if (cbNeighborhood == null) {
			cbNeighborhood = new JComboBox();
			cbNeighborhood.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			cbNeighborhood.setModel(new DefaultComboBoxModel(new String[] {"?????????", "?????????", "?????????", "?????????", "??????"}));
			cbNeighborhood.setBackground(Color.WHITE);
			cbNeighborhood.setBounds(133, 111, 261, 25);
		}
		return cbNeighborhood;
	}

	private JComboBox getCbPeople() {
		if (cbPeople == null) {
			cbPeople = new JComboBox();
			cbPeople.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			cbPeople.setModel(new DefaultComboBoxModel(new String[] {"1???", "2???", "3???", "4???", "5?????????"}));
			cbPeople.setBackground(Color.WHITE);
			cbPeople.setBounds(133, 146, 261, 25);
		}
		return cbPeople;
	}

	private JComboBox getCbCategories() {
		if (cbCategories == null) {
			cbCategories = new JComboBox();
			cbCategories.setModel(new DefaultComboBoxModel(new String[] {"??????", "??????", "??????", "??????", "?????????", "??????","??????"}));
			cbCategories.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			cbCategories.setBackground(Color.WHITE);
			cbCategories.setBounds(133, 180, 261, 25);
		}
		return cbCategories;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(81, 277, 313, 25);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(81, 312, 313, 25);
		}
		return tfAddress;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(81, 347, 313, 25);
		}
		return tfTelno;
	}
	private JTextField getTfEnrollnumber() {
		if (tfEnrollnumber == null) {
			tfEnrollnumber = new JTextField();
			tfEnrollnumber.setColumns(10);
			tfEnrollnumber.setBounds(113, 382, 281, 25);
		}
		return tfEnrollnumber;
	}
	private JButton getBtnEnroll() {
		if (btnEnroll == null) {
			btnEnroll = new JButton("??????");
			btnEnroll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EnrollQuery();
				}
			});
			btnEnroll.setFont(new Font("????????? ???????????? ExtraBold", Font.PLAIN, 24));
			btnEnroll.setBackground(new Color(153, 204, 255));
			btnEnroll.setBounds(81, 440, 313, 38);
		}
		return btnEnroll;
	}
	
	//???????????? ??????
	
	private void EnrollQuery(){
		String id = tfId.getText().trim();
		String pw = pwtfpw.getPassword().toString();
		String enrollnumber = tfEnrollnumber.getText().trim();
		String name = tfName.getText().trim();
		String address = tfAddress.getText().trim();
		String telno = tfTelno.getText().trim();
		String neighborhood = cbNeighborhood.getSelectedItem().toString();
		String people = cbPeople.getSelectedItem().toString();
		String categories = cbCategories.getSelectedItem().toString();

		
		DbActionRfoodEnroll dbActionRfoodEnroll = new DbActionRfoodEnroll(enrollnumber,id,pw,name,address,telno,neighborhood,people,categories);
			boolean msg = dbActionRfoodEnroll.EnrollQuery();
				if(msg == true) {
				//	JOptionPane.showInputDialog(this, tfName.getText()+" ?????? ????????? ?????????????????????!"); 
				}else {
				// JOptionPane.showInputDialog(this, "DB ?????? ?????? ??? ????????? ??????????????????! \n ???????????????????????? ???????????????!");   
					}
		
	}

	//?????? ??? ?????????
	private void ClearColumn() {
		// TODO Auto-generated method stub
		tfEnrollnumber.setText("");
		tfName.setText("");
		tfAddress.setText("");
		tfTelno.setText("");
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("??????");
			lblNewLabel.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel.setBounds(19, 284, 50, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("??????");
			lblNewLabel_1.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(19, 319, 50, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("????????????");
			lblNewLabel_2.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(12, 354, 50, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("?????????????????????");
			lblNewLabel_3.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(12, 389, 114, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("??????");
			lblNewLabel_4.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(36, 116, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("??????");
			lblNewLabel_5.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(36, 151, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("??????");
			lblNewLabel_6.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(36, 187, 50, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("YOGI,YOGO");
			lblNewLabel_7.setFont(new Font("????????? ???????????? ExtraBold", Font.PLAIN, 30));
			lblNewLabel_7.setBounds(113, 21, 204, 39);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("?????? ??????");
			lblNewLabel_8.setFont(new Font("????????? ???????????? ExtraBold", Font.PLAIN, 24));
			lblNewLabel_8.setBounds(151, 59, 195, 42);
		}
		return lblNewLabel_8;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(81, 215, 313, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("?????????");
			lblNewLabel_9.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_9.setBounds(36, 212, 50, 15);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("????????????");
			lblNewLabel_10.setFont(new Font("????????? ???????????? Regular", Font.PLAIN, 12));
			lblNewLabel_10.setBounds(19, 251, 50, 15);
		}
		return lblNewLabel_10;
	}
	private JPasswordField getPwtfpw() {
		if (pwtfpw == null) {
			pwtfpw = new JPasswordField();
			pwtfpw.setBounds(81, 246, 313, 21);
		}
		return pwtfpw;
	}
}//----------------------------------
