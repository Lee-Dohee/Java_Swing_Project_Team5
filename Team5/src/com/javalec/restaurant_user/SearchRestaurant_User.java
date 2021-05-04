package com.javalec.restaurant_user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.login_JP.Log_in_User;
import com.javalec.review.Review;
import com.javalec.user.MyPage_User;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRestaurant_User {

	public JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JComboBox cbNeighborhood;
	private JComboBox cbPeople;
	private JComboBox cbCategory;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel_1_2;
	private JLabel lblCount;
	private JButton btnMyPage;
	private JButton btnLogOut;
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	
	String id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRestaurant_User window = new SearchRestaurant_User();
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
	public SearchRestaurant_User() {
		initialize();
	}
	public SearchRestaurant_User(String id) {
		this.id = id;
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
				restaurantTableInit();
				restaurantTable();
			}
		});
		frame.setBounds(100, 100, 450, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getCbNeighborhood());
		frame.getContentPane().add(getCbPeople());
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getLblCount());
		frame.getContentPane().add(getBtnMyPage());
		frame.getContentPane().add(getBtnLogOut());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("맛집 검색");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(188, 35, 74, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("동네 :");
			lblNewLabel_1.setBounds(24, 82, 40, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("사람 :");
			lblNewLabel_1_1.setBounds(235, 82, 40, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("음식 :");
			lblNewLabel_1_1_1.setBounds(24, 114, 40, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JComboBox getCbNeighborhood() {
		if (cbNeighborhood == null) {
			cbNeighborhood = new JComboBox();
			cbNeighborhood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchNeighborhood();
				}
			});
			cbNeighborhood.setModel(new DefaultComboBoxModel(new String[] {"전체", "강남", "홍대", "명동", "이태원"}));
			cbNeighborhood.setBounds(63, 77, 153, 27);
		}
		return cbNeighborhood;
	}
	private JComboBox getCbPeople() {
		if (cbPeople == null) {
			cbPeople = new JComboBox();
			cbPeople.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchPeople();
				}
			});
			cbPeople.setModel(new DefaultComboBoxModel(new String[] {"전체", "1인", "2인", "3인", "4인", "5인 이상"}));
			cbPeople.setBounds(274, 77, 153, 27);
		}
		return cbPeople;
	}
	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchCategory();
				}
			});
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"전체", "한식", "중식", "일식", "양식", "분식"}));
			cbCategory.setBounds(63, 110, 153, 27);
		}
		return cbCategory;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfSearch.setText("");
				}
			});
			tfSearch.setBounds(228, 110, 145, 26);
			tfSearch.setColumns(10);
			tfSearch.setText("이름을 검색하세요.");
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					restaurantTableInit();
					searchAction();
				}
			});
			btnSearch.setBounds(375, 109, 52, 29);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 170, 403, 295);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable(Outer_Table) {
				@Override
				public boolean isCellEditable(int row100, int column100) {
					return false;
				}
			};
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("맛집 :");
			lblNewLabel_1_2.setBounds(24, 142, 40, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCount.setBounds(343, 142, 84, 16);
		}
		return lblCount;
	}
	private JButton getBtnMyPage() {
		if (btnMyPage == null) {
			btnMyPage = new JButton("MyPage");
			btnMyPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					MyPage_User myPage_User = new MyPage_User(id);
					myPage_User.frame.setVisible(true);
				}
			});
			btnMyPage.setBounds(6, 6, 74, 29);
		}
		return btnMyPage;
	}
	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("LogOut");
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Log_in_User log_in_User = new Log_in_User();
					log_in_User.frame.setVisible(true);
				}
			});
			btnLogOut.setBounds(370, 6, 74, 29);
		}
		return btnLogOut;
	}
	
	// 화면 restaurant Table 초기화
	private void restaurantTableInit() {
			
		Outer_Table.addColumn("no");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("별점");
		Outer_Table.addColumn("위치");
		Outer_Table.setColumnCount(4);
			
		// Table 초기화
		int i = Outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
		
		// 크기 조절 불가능
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
		// Table 상단 바 생성 (Outer_Table)
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 250;
		col.setPreferredWidth(width);
	}
	
	// restaurant Table값 불러오기
	private void restaurantTable() {
		
		DbActionRestaurant_User dbActionRestrant = new DbActionRestaurant_User();
        ArrayList<BeanRestaurant_User> beanList = dbActionRestrant.restaurantTable();
        
        for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getNum());
        	String[] qTxt = {temp, beanList.get(i).getName(), beanList.get(i).getStar(), beanList.get(i).getLocation()};
        	Outer_Table.addRow(qTxt);
        }
        lblCount.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// 동네 필터
	private void searchNeighborhood() {
		int i = cbNeighborhood.getSelectedIndex();
		String neighborhood = "";
		String a = "";
		String b = "";
		String c = "";
		switch (i) {
			case 0:
				neighborhood = "";
				break;
			case 1:
				neighborhood = "and rt.neighborhood='강남' ";
				break;
			case 2:
				neighborhood = "and rt.neighborhood='홍대' ";
				break;
			case 3:
				neighborhood = "and rt.neighborhood='명동' ";
				break;
			case 4:
				neighborhood = "and rt.neighborhood='이태원' ";
				break;
			default:
				break;
		}
		restaurantTableInit();
		searchNeighborhoodAction(neighborhood, a, b, c);

	}
	private void searchNeighborhoodAction(String columnName, String a, String b, String c) {
		
		DbActionRestaurant_User dbActionRestrant = new DbActionRestaurant_User(columnName, a, b, c);
		ArrayList<BeanRestaurant_User> beanList = dbActionRestrant.searchNeighborhoodAction();
		
		for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getNum());
        	String[] qTxt = {temp, beanList.get(i).getName(), beanList.get(i).getStar(), beanList.get(i).getLocation()};
        	Outer_Table.addRow(qTxt);
        }
        lblCount.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// 사람 필터
	private void searchPeople() {
		int i = cbPeople.getSelectedIndex();
		String people = "";
		String a = "";
		String b = "";
		String c = "";
		switch (i) {
			case 0:
				people = "";
				break;
			case 1:
				people = "and rt.people='1인' ";
				break;
			case 2:
				people = "and rt.people='2인' ";
				break;
			case 3:
				people = "and rt.people='3인' ";
				break;
			case 4:
				people = "and rt.people='4인' ";
				break;
			case 5:
				people = "and rt.people='5인이상' ";
				break;
			default:
				break;
		}
		restaurantTableInit();
		searchPeopleAction(a, people, b, c);
	}
	private void searchPeopleAction(String a, String columnName, String b, String c) {
		
		DbActionRestaurant_User dbActionRestrant = new DbActionRestaurant_User(a, columnName, b, c);
		ArrayList<BeanRestaurant_User> beanList = dbActionRestrant.searchPeopleAction();
		
		for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getNum());
        	String[] qTxt = {temp, beanList.get(i).getName(), beanList.get(i).getStar(), beanList.get(i).getLocation()};
        	Outer_Table.addRow(qTxt);
        }
        lblCount.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// 음식 카테고리 필터
	private void searchCategory() {
		int i = cbCategory.getSelectedIndex();
		String category = "";
		String a = "";
		String b = "";
		String c = "";
		switch (i) {
			case 0:
				category = "";
				break;
			case 1:
				category = "and rt.category='한식' ";
				break;
			case 2:
				category = "and rt.category='중식' ";
				break;
			case 3:
				category = "and rt.category='일식' ";
				break;
			case 4:
				category = "and rt.category='양식' ";
				break;
			case 5:
				category = "and rt.category='분식' ";
				break;
			default:
				break;
		}
		restaurantTableInit();
		searchCategoryAction(a, b, category, c);
	}
	private void searchCategoryAction(String a, String b, String columnName, String c) {
		
		DbActionRestaurant_User dbActionRestrant = new DbActionRestaurant_User(a, b, columnName, c);
		ArrayList<BeanRestaurant_User> beanList = dbActionRestrant.searchCategoryAction();
		
		for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getNum());
        	String[] qTxt = {temp, beanList.get(i).getName(), beanList.get(i).getStar(), beanList.get(i).getLocation()};
        	Outer_Table.addRow(qTxt);
        }
        lblCount.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// 일반 검색 - 이름
	private void searchAction() {
		
		String name = tfSearch.getText().trim();
		
		DbActionRestaurant_User dbActionRestrant = new DbActionRestaurant_User(name);
		ArrayList<BeanRestaurant_User> beanList = dbActionRestrant.searchAction();
		
		for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getNum());
        	String[] qTxt = {temp, beanList.get(i).getName(), beanList.get(i).getStar(), beanList.get(i).getLocation()};
        	Outer_Table.addRow(qTxt);
        }
        lblCount.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// restaurant 테이블 클릭 시 식당 상세 정보 보여주기
	private void tableClick() {
		
		int i = Inner_Table.getSelectedRow();
		String wkNum = (String) Inner_Table.getValueAt(i, 0);
		
		frame.setVisible(false);
		ViewRestaurant_User allergyUser = new ViewRestaurant_User(wkNum, id);
		allergyUser.frame.setVisible(true);
	}
}
