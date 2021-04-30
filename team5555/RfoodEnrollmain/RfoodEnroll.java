		package com.javalec.RfoodEnrollmain;
		
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
			private JComboBox<?> cbCategory;
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
								window.getFrame().setVisible(true);
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
					setFrame(new JFrame());
					getFrame().getContentPane().setBackground(Color.WHITE);
					getFrame().setBounds(100, 100, 450, 537);
					getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					getFrame().getContentPane().setLayout(null);
					getFrame().getContentPane().add(getCbNeighborhood());
					getFrame().getContentPane().add(getCbPeople());
					getFrame().getContentPane().add(getCbCategory());
					getFrame().getContentPane().add(getTfName());
					getFrame().getContentPane().add(getTfLocation());
					getFrame().getContentPane().add(getTfTelno());
					getFrame().getContentPane().add(getTfNumber());
					getFrame().getContentPane().add(getBtnEnroll());
					getFrame().getContentPane().add(getLblNewLabel());
					getFrame().getContentPane().add(getLblNewLabel_1());
					getFrame().getContentPane().add(getLblNewLabel_2());
					getFrame().getContentPane().add(getLblNewLabel_3());
					getFrame().getContentPane().add(getLblNewLabel_4());
					getFrame().getContentPane().add(getLblNewLabel_5());
					getFrame().getContentPane().add(getLblNewLabel_6());
					getFrame().getContentPane().add(getLblNewLabel_7());
					getFrame().getContentPane().add(getLblNewLabel_8());
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
			
				private JComboBox getCbCategory() {
					if (cbCategory == null) {
						cbCategory = new JComboBox();
						cbCategory.setModel(new DefaultComboBoxModel(new String[] {"한식", "중식", "일식", "양식", "디저트", "분식"}));
						cbCategory.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
						cbCategory.setBackground(Color.WHITE);
						cbCategory.setBounds(133, 180, 261, 25);
					}
					return cbCategory;
				}
			
				private JTextField getTfName() {
					if (tfName == null) {
						tfName = new JTextField();
						tfName.setBounds(81, 227, 313, 31);
						tfName.setColumns(10);
					}
					return tfName;
				}
				private JTextField getTfLocation() {
					if (tfLocation == null) {
						tfLocation = new JTextField();
						tfLocation.setColumns(10);
						tfLocation.setBounds(81, 289, 313, 31);
					}
					return tfLocation;
				}
				private JTextField getTfTelno() {
					if (tfTelno == null) {
						tfTelno = new JTextField();
						tfTelno.setColumns(10);
						tfTelno.setBounds(133, 342, 261, 31);
					}
					return tfTelno;
				}
				private JTextField getTfNumber() {
					if (tfNumber == null) {
						tfNumber = new JTextField();
						tfNumber.setColumns(10);
						tfNumber.setBounds(133, 399, 261, 31);
					}
					return tfNumber;
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
					
					//이 부분에 맛집 검색 창이 떠야 함
					
				}
			
				//메뉴 등록
				private void EnrollQuery(){
				//	String id = tfId.getText().trim();
					String number = tfNumber.getText().trim();
					String name = tfName.getText().trim();
					String location = tfLocation.getText().trim();
					String telno = tfTelno.getText().trim();
					String people = cbPeople.getSelectedItem().toString();
					String neighborhood = cbNeighborhood.getSelectedItem().toString();
					String category = cbCategory.getSelectedItem().toString();
					
					
				DbActionRfoodEnroll dbActionRfoodEnroll = new DbActionRfoodEnroll (number, name, telno, location, category, neighborhood, people);
				
					boolean msg = dbActionRfoodEnroll.EnrollQuery();
					
						if(msg == true) {
							
						}else {
							
							}
						
						}
		
							//입력한 것 다시 작성하기 위해 비우기
							private void ClearColumn() {
									tfNumber.setText("");
									tfName.setText("");
									tfLocation.setText("");
									tfTelno.setText("");
									}
		
			
			
					private JLabel getLblNewLabel() {
						if (lblNewLabel == null) {
							lblNewLabel = new JLabel("이름");
							lblNewLabel.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
							lblNewLabel.setBounds(19, 237, 50, 15);
						}
						return lblNewLabel;
					}
					private JLabel getLblNewLabel_1() {
						if (lblNewLabel_1 == null) {
							lblNewLabel_1 = new JLabel("주소");
							lblNewLabel_1.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
							lblNewLabel_1.setBounds(19, 299, 50, 15);
						}
						return lblNewLabel_1;
					}
					private JLabel getLblNewLabel_2() {
						if (lblNewLabel_2 == null) {
							lblNewLabel_2 = new JLabel("전화번호");
							lblNewLabel_2.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
							lblNewLabel_2.setBounds(19, 352, 50, 15);
						}
						return lblNewLabel_2;
					}
					private JLabel getLblNewLabel_3() {
						if (lblNewLabel_3 == null) {
							lblNewLabel_3 = new JLabel("사업자등록번호");
							lblNewLabel_3.setFont(new Font("티머니 둥근바람 Regular", Font.PLAIN, 12));
							lblNewLabel_3.setBounds(19, 412, 114, 15);
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

					public JFrame getFrame() {
						return frame;
					}

					public void setFrame(JFrame frame) {
						this.frame = frame;
					}
		}//----------------------------------
