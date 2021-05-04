package com.javalec.restaurant_owner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ModifyRestaurant {

	public JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnModify;
	private JButton btnCancel;
	private JTextField tfName;
	private JTextField tfLocation;
	private JTextField tfTelno;
	private JComboBox cbNeighborhood;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JComboBox cbPeople;
	private JComboBox cbCategory;

	String wkNum;
	String id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyRestaurant window = new ModifyRestaurant();
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
	public ModifyRestaurant() {
		initialize();
	}
	public ModifyRestaurant(String wkNum, String id) {
		this.id = id;
		this.wkNum = wkNum;
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
				setText();
			}
		});
		frame.setTitle("식당 정보 수정");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 262, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getBtnModify());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfLocation());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getCbNeighborhood());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getCbPeople());
		frame.getContentPane().add(getCbCategory());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("정보 수정");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setBounds(87, 31, 74, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setBounds(26, 85, 41, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("위치 :");
			lblNewLabel_2.setBounds(26, 120, 41, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화번호 :");
			lblNewLabel_3.setBounds(26, 156, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정하기");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0){
						selectCb();
						frame.setVisible(false);
						ViewRestaurant_Owner testRestaurant = new ViewRestaurant_Owner(wkNum, id);
						testRestaurant.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(frame, "메뉴 수정 항목을 모두 입력하세요!",
								"메뉴 수정", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnModify.setBounds(142, 335, 84, 29);
		}
		return btnModify;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ViewRestaurant_Owner testRestaurant = new ViewRestaurant_Owner(wkNum, id);
					testRestaurant.frame.setVisible(true);
				}
			});
			btnCancel.setBounds(62, 335, 84, 29);
		}
		return btnCancel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(62, 80, 164, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfLocation() {
		if (tfLocation == null) {
			tfLocation = new JTextField();
			tfLocation.setColumns(10);
			tfLocation.setBounds(62, 115, 164, 26);
		}
		return tfLocation;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(87, 151, 139, 26);
		}
		return tfTelno;
	}
	private JComboBox getCbNeighborhood() {
		if (cbNeighborhood == null) {
			cbNeighborhood = new JComboBox();
			cbNeighborhood.setModel(new DefaultComboBoxModel(new String[] {"강남", "홍대", "명동", "이태원"}));
			cbNeighborhood.setBounds(62, 184, 164, 27);
		}
		return cbNeighborhood;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("동네 :");
			lblNewLabel_1_1.setBounds(26, 189, 41, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("사람 :");
			lblNewLabel_1_1_1.setBounds(26, 224, 41, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel(" 음식 :");
			lblNewLabel_1_1_1_1.setBounds(26, 262, 41, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JComboBox getCbPeople() {
		if (cbPeople == null) {
			cbPeople = new JComboBox();
			cbPeople.setModel(new DefaultComboBoxModel(new String[] {"1인", "2인", "3인", "4인", "5인이상"}));
			cbPeople.setBounds(62, 220, 164, 27);
		}
		return cbPeople;
	}
	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"한식", "중식", "일식", "양식", "분식"}));
			cbCategory.setBounds(62, 258, 164, 27);
		}
		return cbCategory;
	}
	
	// 기본 정보 넣어주기
	private void setText() {
		DbActionRestaurant_Owner dbActionRestrant = new DbActionRestaurant_Owner();
		
		// restaurant 기본 정보 불러오기
		BeanRestaurant_Owner beanRestrantInfo = dbActionRestrant.restaurantInfo(wkNum);
		tfName.setText(beanRestrantInfo.getName());
		tfLocation.setText(beanRestrantInfo.getLocation());
		tfTelno.setText(beanRestrantInfo.getTelno());
	}
	
	// 콤보박스 선택
	private void selectCb() {
		
		// 동네
		int i = cbNeighborhood.getSelectedIndex();
		String neighborhood = "";
		switch (i) {
			case 0:
				neighborhood = "강남";
				break;
			case 1:
				neighborhood = "홍대";
				break;
			case 2:
				neighborhood = "명동";
				break;
			case 3:
				neighborhood = "이태원";
				break;
			default:
				break;
		}
		
		// 사람
		int j = cbPeople.getSelectedIndex();
		String people = "";
		switch (j) {
			case 0:
				people = "1인";
				break;
			case 1:
				people = "2인";
				break;
			case 2:
				people = "3인";
				break;
			case 3:
				people = "4인";
				break;
			case 4:
				people = "5인이상";
				break;
			default:
				break;
		}
		
		// 음식 카테고리
		int k = cbCategory.getSelectedIndex();
		String category = "";
		switch (k) {
			case 0:
				category = "한식";
				break;
			case 1:
				category = "중식";
				break;
			case 2:
				category = "일식";
				break;
			case 3:
				category = "양식";
				break;
			case 4:
				category = "분식";
				break;
			default:
				break;
		}
		modifyInfo(neighborhood, people, category);
	}
	
	
	// 정보수정
	private void modifyInfo(String neighborhood, String people, String category) {
		String name = tfName.getText().trim();
		String location = tfLocation.getText().trim();
		String telno = tfTelno.getText().trim();
		
		DbActionRestaurant_Owner dbActionRestaurant = new DbActionRestaurant_Owner(name, location, telno);
		
		boolean msg = dbActionRestaurant.modifyAction(wkNum, neighborhood, people, category);
		
		if (msg == true) {
			JOptionPane.showMessageDialog(frame, "정보 수정이 완료되었습니다!",
                  "입력 완료!", 
                  JOptionPane.INFORMATION_MESSAGE);  
		}else {
			JOptionPane.showMessageDialog(frame, "정보 수정에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
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
		if(tfLocation.getText().length() == 0){
			i++;
			tfLocation.requestFocus();
		}
		if(tfTelno.getText().length() == 0){
			i++;
			tfTelno.requestFocus();
		}
		return i;
	}
}
