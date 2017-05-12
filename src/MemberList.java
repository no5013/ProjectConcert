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


public class MemberList extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Customer> memberList;
	private static Store store;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberList frame = new MemberList(store, memberList);
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
	public MemberList(Store store,ArrayList<Customer> memberList) {
		setTitle("Customer List");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.memberList = memberList;
		
		JLabel lblCustomerList = new JLabel("MemberList");
		lblCustomerList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerList.setBounds(10, 11, 284, 44);
		contentPane.add(lblCustomerList);
		
		JLabel conID = new JLabel("Member of our store");
		conID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conID.setBounds(64, 78, 197, 22);
		contentPane.add(conID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 764, 409);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(store.getMemberListToString(memberList));
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

}
