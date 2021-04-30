package com.javalec.restaurant_owner;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.restaurant_user.BeanRestaurant_User;
import com.javalec.restaurant_user.DbActionRestaurant_User;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class SearchRestaurant_Owner {

	public JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblCount;
	private JButton btnMyPage;
	private JButton btnRegisterRestaurant;
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRestaurant_Owner window = new SearchRestaurant_Owner();
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
	public SearchRestaurant_Owner() {
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
		frame.setTitle("내 식당");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblCount());
		frame.getContentPane().add(getBtnMyPage());
		frame.getContentPane().add(getBtnRegisterRestaurant());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("식당 목록");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(188, 35, 74, 25);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 82, 403, 295);
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
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCount.setBounds(366, 61, 61, 16);
		}
		return lblCount;
	}
	private JButton getBtnMyPage() {
		if (btnMyPage == null) {
			btnMyPage = new JButton("MyPage");
			btnMyPage.setBounds(6, 6, 74, 29);
		}
		return btnMyPage;
	}
	private JButton getBtnRegisterRestaurant() {
		if (btnRegisterRestaurant == null) {
			btnRegisterRestaurant = new JButton("식당 등록");
			btnRegisterRestaurant.setBounds(310, 389, 117, 29);
		}
		return btnRegisterRestaurant;
	}
	
	
	// 식당 목록 Table 초기화
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
		
		DbActionRestaurant_Owner dbActionRestrant = new DbActionRestaurant_Owner();
        ArrayList<BeanRestaurant_Owner> beanList = dbActionRestrant.restaurantTable();
        
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
		ViewRestaurant_Owner testRestaurant = new ViewRestaurant_Owner(wkNum);
		testRestaurant.frame.setVisible(true);
	}
	
	
}
