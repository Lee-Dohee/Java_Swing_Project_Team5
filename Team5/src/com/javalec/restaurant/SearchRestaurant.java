package com.javalec.restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.review.TestReview;

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

public class SearchRestaurant {

	public JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JComboBox cbNeighborhood;
	private JComboBox cbPeople;
	private JComboBox cbCategory;
	private JComboBox cbStar;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel_1_2;
	private JLabel lblCount;
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRestaurant window = new SearchRestaurant();
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
	public SearchRestaurant() {
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
//		100, 100, 450, 594
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getCbNeighborhood());
		frame.getContentPane().add(getCbPeople());
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getCbStar());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getLblCount());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("맛집 검색");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(188, 22, 74, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("동네 :");
			lblNewLabel_1.setBounds(24, 69, 40, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("사람 :");
			lblNewLabel_1_1.setBounds(235, 69, 40, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("음식 :");
			lblNewLabel_1_1_1.setBounds(24, 101, 40, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("별점:");
			lblNewLabel_1_1_1_1.setBounds(235, 101, 40, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JComboBox getCbNeighborhood() {
		if (cbNeighborhood == null) {
			cbNeighborhood = new JComboBox();
			cbNeighborhood.setBounds(63, 64, 153, 27);
		}
		return cbNeighborhood;
	}
	private JComboBox getCbPeople() {
		if (cbPeople == null) {
			cbPeople = new JComboBox();
			cbPeople.setBounds(274, 64, 153, 27);
		}
		return cbPeople;
	}
	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setBounds(63, 97, 153, 27);
		}
		return cbCategory;
	}
	private JComboBox getCbStar() {
		if (cbStar == null) {
			cbStar = new JComboBox();
			cbStar.setBounds(274, 97, 153, 27);
		}
		return cbStar;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(24, 129, 238, 26);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(274, 129, 153, 29);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 195, 403, 274);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
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
			lblNewLabel_1_2.setBounds(24, 167, 40, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCount.setBounds(343, 170, 84, 16);
		}
		return lblCount;
	}
	
	// 화면 restaurant Table 초기화
	private void restaurantTableInit() {
			
		Outer_Table.addColumn("no");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("별점");
		Outer_Table.addColumn("위치");
		Outer_Table.setColumnCount(4);
			
		// Table 초기화
		int i = Outer_Table.getRowCount();	// .getRowCount = 가로 줄의 수 == i는 가로 줄 수
		for(int j=0; j<i; j++) {		// i만큼 for문 돌려라 = 가로 줄 수만큼 For문 돌려라 = 가로줄 다 없어질때까지 지워라 = 초기화
			Outer_Table.removeRow(0);	// 계속 0번을 지워라 - 계속 지울려면 0으로 설정, j아님, j설정 시 모두 지울 수 없음 = 초기화 안됨, 0으로 설정해야 모두 지울 수 있음 = 초기화 가능
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
		
		int j = Inner_Table.getSelectedRow();					// i = 선택한 inner테이블이 몇번째 줄인지
		String tempNum = (String) Inner_Table.getValueAt(j, 0);
		int wkNum = Integer.parseInt(tempNum);
		
		DbActionRestrant dbActionRestrant = new DbActionRestrant();
        // selectList를 어Bean으로 저장
        ArrayList<BeanRestrant> beanList = dbActionRestrant.restaurantTable();
        String star = dbActionRestrant.restaurantStar(tempNum);
        
        for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getNum());
        	String[] qTxt = {temp, beanList.get(i).getName(), star, beanList.get(i).getLocation()};
        	// 만든 배열을 Outer_Table에 추가
        	Outer_Table.addRow(qTxt);
        }
        
        lblCount.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// restaurant 테이블 클릭 시 식당 상세 정보 보여주기
	private void tableClick() {
		
		int i = Inner_Table.getSelectedRow();					// i = 선택한 inner테이블이 몇번째 줄인지
		String tempNum = (String) Inner_Table.getValueAt(i, 0);
		int wkNum = Integer.parseInt(tempNum);
		
		frame.setVisible(false);
		TestRestaurant testRestaurant = new TestRestaurant(wkNum);
		testRestaurant.frame.setVisible(true);
	}
	
}
