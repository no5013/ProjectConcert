import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CustomerList extends JFrame {

	private JPanel contentPane;
	private JTextField conIDT;
	private static Concert concert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerList frame = new CustomerList(concert);
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
	public CustomerList(Concert concert) {
		setTitle("Customer List");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.concert = concert;
		
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerList.setBounds(10, 11, 284, 44);
		contentPane.add(lblCustomerList);
		
		JLabel conID = new JLabel("Concert ID");
		conID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conID.setBounds(33, 80, 94, 22);
		contentPane.add(conID);
		
		conIDT = new JTextField();
		conIDT.setBounds(135, 84, 112, 20);
		contentPane.add(conIDT);
		conIDT.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 764, 409);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		conIDT.setText(concert.getConcertInfo().getConcertID());
		textArea.setText(concert.getCustomerListToString());
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

}
