package com.javalec.restaurant_owner;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterRestaurant_HJ {

	//-------------2021.05.01 이도희-------------
	public JFrame frame;
	private JComboBox cbNeighborhood;
	private JComboBox cbPeople;
	private JComboBox cbCategory;
	private JButton btnCancel;
	String id;
	//-------------2021.05.01 이도희-------------
//	private JFrame frame;
//	private JComboBox<?> cbNeighborhood;
//	private JComboBox<?> cbPeople;
//	private JComboBox<?> cbCategory;
	private JTextField tfName;
	private JTextField tfLocation;
	private JTextField tfTelno;
	private JTextField tfNumber;
	private JButton btnEnroll;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterRestaurant_HJ window = new RegisterRestaurant_HJ();
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
	public RegisterRestaurant_HJ() {
		initialize();
	}
	//-------------2021.05.01 이도희-------------
	public RegisterRestaurant_HJ(String id) {
		this.id = id;
		initialize();
	}
	//-------------2021.05.01 이도희-------------
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		setFrame(new JFrame());
//		getFrame().getContentPane().setBackground(Color.WHITE);
//		getFrame().setBounds(100, 100, 450, 537);
//		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		getFrame().getContentPane().setLayout(null);
//		getFrame().getContentPane().add(getCbNeighborhood());
//		getFrame().getContentPane().add(getCbPeople());
//		getFrame().getContentPane().add(getCbCategory());
//		getFrame().getContentPane().add(getTfName());
//		getFrame().getContentPane().add(getTfLocation());
//		getFrame().getContentPane().add(getTfTelno());
//		getFrame().getContentPane().add(getTfNumber());
//		getFrame().getContentPane().add(getBtnEnroll());
//		getFrame().getContentPane().add(getLblNewLabel());
//		getFrame().getContentPane().add(getLblNewLabel_1());
//		getFrame().getContentPane().add(getLblNewLabel_2());
//		getFrame().getContentPane().add(getLblNewLabel_3());
//		getFrame().getContentPane().add(getLblNewLabel_4());
//		getFrame().getContentPane().add(getLblNewLabel_5());
//		getFrame().getContentPane().add(getLblNewLabel_6());
//		getFrame().getContentPane().add(getLblNewLabel_7());
//		getFrame().getContentPane().add(getLblNewLabel_8());
		//-------------2021.05.01 이도희-------------
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 281, 416);
		frame.setTitle("맛집 등록");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbNeighborhood());
		frame.getContentPane().add(getCbPeople());
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfLocation());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfNumber());
		frame.getContentPane().add(getBtnEnroll());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getLblNewLabel_8());
		frame.getContentPane().add(getBtnCancel());
		//-------------2021.05.01 이도희-------------
	}
	private JComboBox getCbNeighborhood() {
		if (cbNeighborhood == null) {
			cbNeighborhood = new JComboBox();
			cbNeighborhood.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			cbNeighborhood.setModel(new DefaultComboBoxModel(new String[] {"강남", "홍대", "명동", "이태원"}));
			cbNeighborhood.setBackground(Color.WHITE);
			cbNeighborhood.setBounds(50, 73, 204, 25);
		}
		return cbNeighborhood;
	}

	private JComboBox getCbPeople() {
		if (cbPeople == null) {
			cbPeople = new JComboBox();
			cbPeople.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			cbPeople.setModel(new DefaultComboBoxModel(new String[] {"1인", "2인", "3인", "4인", "5인이상"}));
			cbPeople.setBackground(Color.WHITE);
			cbPeople.setBounds(50, 108, 204, 25);
		}
		return cbPeople;
	}

	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"한식", "중식", "일식", "양식", "분식"}));
			cbCategory.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			cbCategory.setBackground(Color.WHITE);
			cbCategory.setBounds(50, 144, 204, 25);
		}
		return cbCategory;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(50, 181, 204, 31);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfLocation() {
		if (tfLocation == null) {
			tfLocation = new JTextField();
			tfLocation.setColumns(10);
			tfLocation.setBounds(50, 224, 204, 31);
		}
		return tfLocation;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(70, 267, 184, 31);
		}
		return tfTelno;
	}
	private JTextField getTfNumber() {
		if (tfNumber == null) {
			tfNumber = new JTextField();
			tfNumber.setColumns(10);
			tfNumber.setBounds(96, 310, 158, 31);
		}
		return tfNumber;
	}
	private JButton getBtnEnroll() {
		if (btnEnroll == null) {
			btnEnroll = new JButton("등록");
			btnEnroll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					EnrollQuery();
					selectCb();
					registerReview();
					frame.setVisible(false);
					SearchRestaurant_Owner searchRestaurant_Owner = new SearchRestaurant_Owner(id);
					searchRestaurant_Owner.frame.setVisible(true);
				}
			});
			btnEnroll.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnEnroll.setBackground(new Color(153, 204, 255));
			btnEnroll.setBounds(179, 353, 75, 25);
		}
		return btnEnroll;
		
		//이 부분에 맛집 검색 창이 떠야 함
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel.setBounds(19, 189, 50, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("주소");
			lblNewLabel_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(19, 232, 235, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호");
			lblNewLabel_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(19, 275, 50, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("사업자등록번호");
			lblNewLabel_3.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(19, 318, 114, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("동네");
			lblNewLabel_4.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(19, 78, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("인원");
			lblNewLabel_5.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(19, 113, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("음식");
			lblNewLabel_6.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(19, 149, 50, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("맛집 등록");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_8.setBounds(35, 19, 195, 42);
		}
		return lblNewLabel_8;
	}
	//-------------2021.05.01 이도희-------------
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					SearchRestaurant_Owner searchRestaurant_Owner = new SearchRestaurant_Owner(id);
					searchRestaurant_Owner.frame.setVisible(true);
				}
			});
			btnCancel.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnCancel.setBackground(new Color(153, 204, 255));
			btnCancel.setBounds(96, 353, 75, 25);
		}
		return btnCancel;
	}
	//-------------2021.05.01 이도희-------------
	
	
//	public JFrame getFrame() {
//		return frame;
//	}
//
//	public void setFrame(JFrame frame) {
//		this.frame = frame;
//		frame.setTitle("맛집 등록");
//	}
//	메뉴 등록
//	private void EnrollQuery(){
//		String id = tfId.getText().trim();
//		String number = tfNumber.getText().trim();
//		String name = tfName.getText().trim();
//		String location = tfLocation.getText().trim();
//		String telno = tfTelno.getText().trim();
//		String people = cbPeople.getSelectedItem().toString();
//		String neighborhood = cbNeighborhood.getSelectedItem().toString();
//		String category = cbCategory.getSelectedItem().toString();
//		
//		DbActionFood dbActionRfoodEnroll = new DbActionFood(number, name, telno, location, category, neighborhood, people);
//	
//		boolean msg = dbActionRfoodEnroll.EnrollQuery();
//		
//		if(msg == true) {
//			
//		}else {
//			
//		}
//	}
//	입력한 것 다시 작성하기 위해 비우기
//	private void ClearColumn() {
//		tfNumber.setText("");
//		tfName.setText("");
//		tfLocation.setText("");
//		tfTelno.setText("");
//	}

	
	//-------------2021.05.01 이도희-------------
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
		registerRestaurant(neighborhood, people, category);
	}
	
	// 식당등록
	private void registerRestaurant(String neighborhood, String people, String category) {
		
		// 유저 아이디로 설정
		String name = tfName.getText().trim();
		String location = tfLocation.getText().trim();
		String telno = tfTelno.getText().trim();
		String number = tfNumber.getText().trim();
		
		DbActionRegisterRestaurant_HJ dbActionFood = new DbActionRegisterRestaurant_HJ(id, neighborhood, people, category, name, location, telno, number);

		boolean msg = dbActionFood.registerRestaurant();
		
		// 식당 등록이 제대로 완료되었나 확인
		if(msg == true) {
			JOptionPane.showMessageDialog(frame, "식당 등록이 완료되었습니다!",
	                  "입력 완료!", 
	                  JOptionPane.INFORMATION_MESSAGE); 
		}else {
			JOptionPane.showMessageDialog(frame, "식당 등록에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
	                  "Critical Error!", 
	                  JOptionPane.ERROR_MESSAGE);   
		}
	}
	
	// 리뷰 등록
	// 기본 리뷰 하나는 있어야 식당 목록에 뜸
	private void registerReview() {
		
		String name = tfName.getText().trim();
		String location = tfLocation.getText().trim();
		String telno = tfTelno.getText().trim();
		String number = tfNumber.getText().trim();
		
		DbActionRegisterRestaurant_HJ dbActionFood = new DbActionRegisterRestaurant_HJ(id, name, location, telno, number);
		
		ArrayList<BeanRestaurant_Owner> beanList = dbActionFood.rCode();
		
		String rCode = beanList.get(0).getR_code();
		dbActionFood.registerReview(rCode);
	}
	//-------------2021.05.01 이도희-------------
	
}
