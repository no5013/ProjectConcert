import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;


public class SelectZone extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static Concert selectCon;
	private static ArrayList<Customer> memberList;
	private static ArrayList<Ticket> ticketList;
	private static String selectZone;
	private static Store store;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectZone frame = new SelectZone(store,selectCon, memberList,ticketList);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private void showDialog(String dialogBox,String dialogHead){
		JOptionPane.showMessageDialog(this,dialogBox,dialogHead,JOptionPane.PLAIN_MESSAGE);
	}
	
	
	public SelectZone(Store store,Concert selectCon,ArrayList<Customer> memberList,ArrayList<Ticket> ticketList) {
		setTitle("Select Zone");
		
		setBounds(100, 100, 670, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.selectCon = selectCon;
		this.memberList = memberList;
		this.ticketList = ticketList;
		this.selectZone = "Z";
		
		ClassLoader loader = this.getClass().getClassLoader();
		
		JLabel lblSelectZone = new JLabel("Select Zone");
		lblSelectZone.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblSelectZone.setBounds(247, 11, 143, 36);
		contentPane.add(lblSelectZone);
		this.store = store;
		
		JLabel lblZoneA = new JLabel("Zone A");
		lblZoneA.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblZoneA.setBounds(20, 502, 106, 36);
		contentPane.add(lblZoneA);
		
		JLabel lblZoneB = new JLabel("Zone B");
		lblZoneB.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblZoneB.setBounds(234, 502, 77, 36);
		contentPane.add(lblZoneB);
		
		JLabel lblZoneC = new JLabel("Zone C");
		lblZoneC.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblZoneC.setBounds(424, 502, 88, 36);
		contentPane.add(lblZoneC);
		
		JLabel lblAvaliableSeats = new JLabel("Avaliable Seats");
		lblAvaliableSeats.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblAvaliableSeats.setBounds(31, 446, 211, 36);
		contentPane.add(lblAvaliableSeats);
		
		JLabel lblZoneD = new JLabel("Zone D");
		lblZoneD.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblZoneD.setBounds(123, 538, 91, 36);
		contentPane.add(lblZoneD);
		
		JLabel lblZoneE = new JLabel("Zone E");
		lblZoneE.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblZoneE.setBounds(309, 538, 77, 36);
		contentPane.add(lblZoneE);
		
		textField = new JTextField();
		textField.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField.setBounds(138, 502, 86, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(321, 502, 86, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(517, 502, 86, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(213, 543, 86, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(396, 538, 86, 28);
		contentPane.add(textField_4);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectZone.equals("Z")){
					showDialog("Please select zone!!!!!","Error!!!");
				}
				else{
				Booking bookingPage = new Booking(store,selectCon, memberList, selectZone,ticketList);
				bookingPage.run();
				}
			}
		});
		btnBooking.setFont(new Font("Gabriola", Font.BOLD, 30));
		btnBooking.setBounds(252, 585, 153, 34);
		contentPane.add(btnBooking);
		
		JLabel lblZone = new JLabel("zone");
		lblZone.setIcon(new ImageIcon(SelectZone.class.getResource("/image/zone.png")));
		lblZone.setBounds(50, 33, 535, 400);
		contentPane.add(lblZone);
		
		JLabel lblZoneaselect = new JLabel("zoneASelect");
		lblZoneaselect.setIcon(new ImageIcon(SelectZone.class.getResource("/image/zoneAG.png")));
		lblZoneaselect.setBounds(50, 33, 535, 400);
		contentPane.add(lblZoneaselect);
		
		JLabel lblZonebselect = new JLabel("zoneBSelect");
		lblZonebselect.setIcon(new ImageIcon(SelectZone.class.getResource("/image/zoneBG.png")));
		lblZonebselect.setBounds(50, 33, 535, 400);
		contentPane.add(lblZonebselect);
		
		JLabel lblZonecselect = new JLabel("zoneCSelect");
		lblZonecselect.setIcon(new ImageIcon(SelectZone.class.getResource("/image/zoneCG.png")));
		lblZonecselect.setBounds(50, 33, 535, 400);
		contentPane.add(lblZonecselect);
		
		JLabel lblZonedselect = new JLabel("zoneDSelect");
		lblZonedselect.setIcon(new ImageIcon(SelectZone.class.getResource("/image/zoneDG.png")));
		lblZonedselect.setBounds(50, 33, 535, 400);
		contentPane.add(lblZonedselect);
		
		JLabel lblZoneeselect = new JLabel("zoneESelect");
		lblZoneeselect.setIcon(new ImageIcon(SelectZone.class.getResource("/image/zoneEG.png")));
		lblZoneeselect.setBounds(50, 33, 535, 400);
		contentPane.add(lblZoneeselect);
		
		JLabel lblSelecta = new JLabel("");
		lblSelecta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(true);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "A";
					
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				
				}
			}
		});
		lblSelecta.setBounds(213, 153, 206, 103);
		contentPane.add(lblSelecta);
		
		JLabel lblSelectb = new JLabel("");
		lblSelectb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(true);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "B";
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				}
			}
		});
		lblSelectb.setBounds(195, 280, 235, 36);
		contentPane.add(lblSelectb);
		
		JLabel lblSelectc = new JLabel("");
		lblSelectc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(true);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone ="C";
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				}
			}
		});
		lblSelectc.setBounds(138, 335, 344, 36);
		contentPane.add(lblSelectc);
		
		JLabel lblSelectdleft = new JLabel("");
		lblSelectdleft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(true);
					lblZoneeselect.setVisible(false);
					selectZone = "D";
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				}
			}
		});
		lblSelectdleft.setBounds(123, 169, 50, 47);
		contentPane.add(lblSelectdleft);
		
		JLabel lblSelecteleft = new JLabel("");
		lblSelecteleft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(true);
					selectZone = "E";
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				}
			}
		});
		
		JLabel lblSelectdright = new JLabel("");
		lblSelectdright.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(true);
					lblZoneeselect.setVisible(false);
					selectZone = "D";
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				}
			}
		});
		lblSelectdright.setBounds(462, 169, 50, 47);
		contentPane.add(lblSelectdright);
		lblSelecteleft.setBounds(50, 192, 70, 124);
		contentPane.add(lblSelecteleft);
		
		JLabel lblSelecteright = new JLabel("");
		lblSelecteright.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblZone.isVisible()) {
					lblZone.setVisible(false);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(true);
					selectZone = "E";
				}
				else {
					lblZone.setVisible(true);
					lblZoneaselect.setVisible(false);
					lblZonebselect.setVisible(false);
					lblZonecselect.setVisible(false);
					lblZonedselect.setVisible(false);
					lblZoneeselect.setVisible(false);
					selectZone = "Z";
				}
			}
		});
		lblSelecteright.setBounds(515, 169, 70, 139);
		contentPane.add(lblSelecteright);
	}

	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
