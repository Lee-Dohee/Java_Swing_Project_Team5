package com.javalec.menuenroll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableColumn;

import com.khankong.function.Bean;
import com.khankong.function.DbAction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RmenuEnroll {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable Inner_table;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RmenuEnroll window = new RmenuEnroll();
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
	public RmenuEnroll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTextField_2());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTextField_3());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnSearch());
		frame.setBounds(100, 100, 450, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("우리동네 맛집");
			lblNewLabel.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
			lblNewLabel.setBounds(12, 10, 166, 37);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("메뉴등록");
			lblNewLabel_1.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(147, 59, 122, 37);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("알레르기");
			lblNewLabel_2.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(22, 109, 91, 24);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(101, 110, 246, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 143, 374, 117);
			scrollPane.setViewportView(getInner_table());
		}
		return scrollPane;
	}
	private JTable getInner_table() {
		if (Inner_table == null) {
			Inner_table = new JTable();
			Inner_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
			Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table); 
		}
		return Inner_table;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("이름");
			lblNewLabel_3.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(86, 299, 50, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("가격");
			lblNewLabel_4.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(85, 330, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(147, 325, 218, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("설명");
			lblNewLabel_5.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(86, 366, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(147, 366, 218, 66);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("등록");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBackground(new Color(153, 204, 255));
			btnNewButton.setFont(new Font("티머니 둥근바람 ExtraBold", Font.PLAIN, 20));
			btnNewButton.setBounds(107, 442, 255, 33);
		}
		return btnNewButton;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchAction();
				}
			});
			btnSearch.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
			btnSearch.setBackground(new Color(153, 204, 255));
			btnSearch.setBounds(358, 109, 66, 23);
		}
		return btnSearch;
	}
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
        Outer_Table.addColumn("알레르기 코드");
        Outer_Table.addColumn("알레르기 이름");
      

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 30;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);


	}
	
	private void SearchAction(){
		DbActionRmenuEnroll dbAction = new DbActionRmenuEnroll();
		ArrayList<BeanRmenuEnroll> beanList = dbAction.selectList();
		
		int listCount = beanList.size();
		for(int i = 0; i<listCount;i++) {
			String temp = Integer.toString(beanList.get(i).getM_code());
			String[] qTxt = {temp,beanList.get(i).getM_name(),beanList.get(i).getM_allergy(), beanList.get(i).getM_price(),beanList.get(i).getM_content()};
			Outer_Table.addRow(qTxt);
			}
	
		}
}//======
	
