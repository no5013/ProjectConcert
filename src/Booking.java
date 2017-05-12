import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Booking extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerid;
	private JTextArea textField_1;
	
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
					Booking frame = new Booking(store,selectCon, memberList,selectZone,ticketList);
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
	public Booking(Store store,Concert selectCon,ArrayList<Customer> memberList,String selectZone,ArrayList<Ticket> ticketList) {
		setTitle("Booking");
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.selectZone = selectZone;
		
		JLabel lblBooking = new JLabel("Booking");
		lblBooking.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblBooking.setBounds(339, 17, 107, 40);
		contentPane.add(lblBooking);
		
		JLabel lblCustomerid = new JLabel("CustomerID");
		lblCustomerid.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblCustomerid.setBounds(164, 83, 199, 32);
		contentPane.add(lblCustomerid);
		
		txtCustomerid = new JTextField();
		txtCustomerid.setText("PS:");
		txtCustomerid.setFont(new Font("Gabriola", Font.PLAIN, 25));
		txtCustomerid.setBounds(411, 87, 270, 27);
		contentPane.add(txtCustomerid);
		txtCustomerid.setColumns(10);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selectCusID =  txtCustomerid.getText();
				int index = store.searchCustomerByCustomerID(memberList, selectCusID);
				if(index==-1){
					textField_1.setText("not found");
				}
				else {
					Customer customer = memberList.get(store.searchCustomerByCustomerID(memberList, selectCusID));
					store.booking(selectCon,customer, selectZone , ticketList);
					textField_1.setText("Successfull"+customer.toString()+customer.getTicketListToString());
				}
			}
		});
		btnBooking.setFont(new Font("Gabriola", Font.BOLD, 30));
		btnBooking.setBounds(107, 154, 239, 34);
		contentPane.add(btnBooking);
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddNewCustomer newCusPage = new AddNewCustomer(memberList);
				newCusPage.run();
			}
		});
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewCustomer.setFont(new Font("Gabriola", Font.BOLD, 30));
		btnNewCustomer.setBounds(455, 154, 239, 34);
		contentPane.add(btnNewCustomer);
		
		textField_1 = new JTextArea();
		textField_1.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_1.setBounds(48, 233, 695, 272);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Booking.class.getResource("/image/BGNewCus2.png")));
		lblNewLabel.setBounds(0, 0, 800, 600);
		contentPane.add(lblNewLabel);
	}

	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
