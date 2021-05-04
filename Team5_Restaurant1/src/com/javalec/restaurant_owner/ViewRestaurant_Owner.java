package com.javalec.restaurant_owner;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.javalec.menu.DbActionMenu;
import com.javalec.menu.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ViewRestaurant_Owner {

	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private JTable Inner_Table_Menu;
	private JLabel lblCountM;
	private JLabel lblNewLabel_4_1;
	private JScrollPane scrollPane_1;
	private JTable Inner_Table_Review;
	private JLabel lblCountR;
	private JLabel lblName;
	private JLabel lblLocation;
	private JLabel lblTelno;
	private JLabel lblStar;
	private JLabel lblMenu;
	private JButton btnReview;
	private JButton btnBack;
	private JButton btnDelete;
	private JButton btnRegisterMenu;

	private final DefaultTableModel Outer_Table_Menu = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_Review = new DefaultTableModel();
	
	String id;
	String wkNum;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRestaurant_Owner window = new ViewRestaurant_Owner();
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
	public ViewRestaurant_Owner() {
		initialize();
	}
	public ViewRestaurant_Owner(String wkNum, String id) {
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
				restaurantInfo();
				menuTableInit();
				menuTable();
				reviewTableInit();
				reviewTable();
			}
		});
		frame.setTitle("맛집 정보");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblCountM());
		frame.getContentPane().add(getLblNewLabel_4_1());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getLblCountR());
		frame.getContentPane().add(getLblName());
		frame.getContentPane().add(getLblLocation());
		frame.getContentPane().add(getLblTelno());
		frame.getContentPane().add(getLblStar());
		frame.getContentPane().add(getLblMenu());
		frame.getContentPane().add(getBtnReview());
		frame.getContentPane().add(getBtnBack());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnRegisterMenu());
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("위치 : ");
			lblNewLabel_1.setBounds(20, 80, 34, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호 :");
			lblNewLabel_2.setBounds(20, 108, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("별점 : ");
			lblNewLabel_3.setBounds(20, 136, 34, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("메뉴 : ");
			lblNewLabel_4.setBounds(20, 164, 34, 16);
		}
		return lblNewLabel_4;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 192, 406, 143);
			scrollPane.setViewportView(getInner_Table_Menu());
		}
		return scrollPane;
	}
	private JTable getInner_Table_Menu() {
		if (Inner_Table_Menu == null) {
			Inner_Table_Menu = new JTable(Outer_Table_Menu) {
				@Override
				public boolean isCellEditable(int row100, int column100) {
					return false;
				}
			};
			Inner_Table_Menu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
					menuTableInit();
					menuTable();
				}
			});
			Inner_Table_Menu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_Menu.setModel(Outer_Table_Menu);
		}
		return Inner_Table_Menu;
	}
	private JLabel getLblCountM() {
		if (lblCountM == null) {
			lblCountM = new JLabel("");
			lblCountM.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCountM.setBounds(365, 164, 61, 16);
		}
		return lblCountM;
	}

	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("리뷰 : ");
			lblNewLabel_4_1.setBounds(20, 347, 61, 16);
		}
		return lblNewLabel_4_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(20, 375, 406, 143);
			scrollPane_1.setViewportView(getInner_Table_Review());
		}
		return scrollPane_1;
	}
	private JTable getInner_Table_Review() {
		if (Inner_Table_Review == null) {
			Inner_Table_Review = new JTable(Outer_Table_Review) {
				@Override
				public boolean isCellEditable(int row100, int column100) {
					return false;
				}
				public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			        JComponent c = (JComponent) super.prepareRenderer(renderer, row, column);

			        if(column == 2) {
			        	c.setForeground(new Color(255, 187, 0));
			        }else {
			        	c.setForeground(Color.black);
			        }
			        
			        return c;
			    }
			};
			Inner_Table_Review.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_Review.setModel(Outer_Table_Review);
		}
		return Inner_Table_Review;
	}
	private JLabel getLblCountR() {
		if (lblCountR == null) {
			lblCountR = new JLabel("");
			lblCountR.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCountR.setBounds(365, 347, 61, 16);
		}
		return lblCountR;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(47, 35, 352, 29);
		}
		return lblName;
	}
	private JLabel getLblLocation() {
		if (lblLocation == null) {
			lblLocation = new JLabel("");
			lblLocation.setBounds(56, 80, 352, 16);
		}
		return lblLocation;
	}
	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("");
			lblTelno.setBounds(82, 108, 326, 16);
		}
		return lblTelno;
	}
	private JLabel getLblStar() {
		if (lblStar == null) {
			lblStar = new JLabel("");
			lblStar.setBounds(56, 136, 352, 16);
		}
		return lblStar;
	}
	private JLabel getLblMenu() {
		if (lblMenu == null) {
			lblMenu = new JLabel("");
			lblMenu.setBounds(56, 164, 352, 16);
		}
		return lblMenu;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("정보 수정");
			btnReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					ModifyRestaurant testReview = new ModifyRestaurant(wkNum, id);
					testReview.frame.setVisible(true);
				}
			});
			btnReview.setBounds(309, 530, 117, 29);
		}
		return btnReview;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					SearchRestaurant_Owner searchRestaurant = new SearchRestaurant_Owner(id);
					searchRestaurant.frame.setVisible(true);
				}
			});
			btnBack.setBounds(6, 6, 61, 29);
		}
		return btnBack;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("식당 삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteRestaurant();
				}
			});
			btnDelete.setBounds(189, 530, 117, 29);
		}
		return btnDelete;
	}
	private JButton getBtnRegisterMenu() {
		if (btnRegisterMenu == null) {
			btnRegisterMenu = new JButton("메뉴 등록");
			btnRegisterMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Menu testMenu = new Menu(wkNum, id);
					testMenu.frame.setVisible(true);
				}
			});
			btnRegisterMenu.setBounds(71, 530, 117, 29);
		}
		return btnRegisterMenu;
	}
	
	// 식당 정보 보여주기
	private void restaurantInfo() {
		
		DbActionRestaurant_Owner dbActionRestrant = new DbActionRestaurant_Owner();
		
		// restaurant 기본 정보 불러오기
		BeanRestaurant_Owner beanRestrantInfo = dbActionRestrant.restaurantInfo(wkNum);
		lblName.setText(beanRestrantInfo.getName());
		lblLocation.setText(beanRestrantInfo.getLocation());
		lblTelno.setText(beanRestrantInfo.getTelno());
		
		// restaurant 평균 별점 불러오기
		String star = dbActionRestrant.restaurantStar(wkNum);
		lblStar.setText(star);
	}

	// 화면 Menu Table 초기화
	private void menuTableInit() {
			
		Outer_Table_Menu.addColumn("코드");
		Outer_Table_Menu.addColumn("이름");
		Outer_Table_Menu.addColumn("가격");
		Outer_Table_Menu.addColumn("설명");
		Outer_Table_Menu.addColumn("알레르기");
		Outer_Table_Menu.setColumnCount(5);
			
		// Table 초기화
		int i = Outer_Table_Menu.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table_Menu.removeRow(0);
		}
		
		// 크기 조절 불가능
		Inner_Table_Menu.setAutoResizeMode(Inner_Table_Menu.AUTO_RESIZE_OFF);
		
		// Table 상단 바 생성 (Outer_Table)
		int vColIndex = 0;
		TableColumn col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = Inner_Table_Menu.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
	}
	
	// Menu Table값 불러오기
	private void menuTable() {
		
		DbActionRestaurant_Owner dbActionRestaurant = new DbActionRestaurant_Owner();
		
        ArrayList<BeanRestaurant_Owner> beanList = dbActionRestaurant.menuTable(wkNum);
        
        for(int i=0; i<beanList.size(); i++) {
        	String temp = Integer.toString(beanList.get(i).getCode());
        	String[] qTxt = {temp, beanList.get(i).getName(), beanList.get(i).getPrice(), beanList.get(i).getContent(), beanList.get(i).getAllergy()};
        	// 만든 배열을 Outer_Table에 추가
        	Outer_Table_Menu.addRow(qTxt);
        }
        
        lblCountM.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// 화면 review Table 초기화
	private void reviewTableInit() {
			
		Outer_Table_Review.addColumn("날짜");
		Outer_Table_Review.addColumn("아이디");
		Outer_Table_Review.addColumn("별");
		Outer_Table_Review.addColumn("메뉴");
		Outer_Table_Review.addColumn("내용");
		Outer_Table_Review.setColumnCount(5);
			
		// Table 초기화
		int i = Outer_Table_Review.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table_Review.removeRow(0);
		}
		
		// 크기 조절 불가능
		Inner_Table_Review.setAutoResizeMode(Inner_Table_Review.AUTO_RESIZE_OFF);
		
		// Table 상단 바 생성 (Outer_Table)
		int vColIndex = 0;
		TableColumn col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = Inner_Table_Review.getColumnModel().getColumn(vColIndex);
		width = 300;
		col.setPreferredWidth(width);
	}
	
	// Review Table값 불러오기
	private void reviewTable() {
		
		DbActionRestaurant_Owner dbActionRestrant = new DbActionRestaurant_Owner();
        
		ArrayList<BeanRestaurant_Owner> beanList = dbActionRestrant.reviewTable(wkNum);
        
        for(int i=0; i<beanList.size(); i++) {
        	String[] qTxt = {beanList.get(i).getDate(), beanList.get(i).getU_id(), beanList.get(i).getStar(), beanList.get(i).getMenu(), beanList.get(i).getContent()};
        	// 만든 배열을 Outer_Table에 추가
        	Outer_Table_Review.addRow(qTxt);
        }
        lblCountR.setText(Integer.toString(beanList.size()) + "개");
	}
	
	// 식당 삭제
	private void deleteRestaurant() {
		
		// 선택창 띄우기
		int result = JOptionPane.showConfirmDialog(frame, "해당 식당을 삭제하시겠습니까?", "식당 삭제", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		// yes 누르면 식당 삭제
		if(result == 0) {
			DbActionRestaurant_Owner dbActionRestaurant = new DbActionRestaurant_Owner();
			boolean msg = dbActionRestaurant.deleteRestaurantAction(wkNum);
			
			if (msg == true) {
				
				// 리뷰 삭제
				dbActionRestaurant.deleteReviewAction(wkNum);
				dbActionRestaurant.deleteMenuAction(wkNum);
				dbActionRestaurant.deleteMenuChkAction(wkNum);
				
				JOptionPane.showMessageDialog(frame, "식당 삭제가 완료되었습니다!",
	                  "입력 완료!",
	                  JOptionPane.INFORMATION_MESSAGE);  
				frame.setVisible(false);
				SearchRestaurant_Owner searchRestaurant = new SearchRestaurant_Owner(id);
				searchRestaurant.frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, "식당 삭제에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
	                  "Critical Error!", 
	                  JOptionPane.ERROR_MESSAGE);    
			}
		}
	}
	
	// 메뉴 클릭, 메뉴 삭제
	private void tableClick() {
		
		DbActionMenu dbActionMenu = new DbActionMenu();
		
		int i = Inner_Table_Menu.getSelectedRow();
		String wkNum = (String) Inner_Table_Menu.getValueAt(i, 0);	// i = 메뉴 코드
		
		// 선택 창 띄우기 - yes는 1, no는 0, x는 -1로 리턴됨
		int result = JOptionPane.showConfirmDialog(frame, "이 메뉴를 삭제하시겠습니까?", "메뉴 삭제", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

		// 메뉴 삭제
		if(result == 0) {
			
			boolean msg = dbActionMenu.deleteMenuAction(wkNum);
			
			if (msg == true) {
				JOptionPane.showMessageDialog(frame, "메뉴가 삭제되었습니다!",
	                  "삭제 완료!", 
	                  JOptionPane.INFORMATION_MESSAGE);  
			}else {
				JOptionPane.showMessageDialog(frame, "메뉴 삭제에 오류가 발생하였습니다! \n 시스템관리자에 문의하세요!",
	                  "Critical Error!", 
	                  JOptionPane.ERROR_MESSAGE);    
			}
		}
	}
	
	
}
