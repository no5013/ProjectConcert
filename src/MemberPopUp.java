import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MemberPopUp extends JFrame {

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
					MemberPopUp frame = new MemberPopUp(store,memberList);
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
	public MemberPopUp(Store store, ArrayList<Customer> memberList) {
		setTitle("Member");
		setBounds(100, 100, 400, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.memberList = memberList;
		this.store = store;
		
		JButton btnAddNewMember = new JButton("Add New Customer");
		btnAddNewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewCustomer addNewCustomer = new AddNewCustomer(memberList);
				addNewCustomer.run();
			}
		});
		btnAddNewMember.setBounds(10, 10, 364, 60);
		contentPane.add(btnAddNewMember);
		
		JButton btnMemberlist = new JButton("Memberlist");
		btnMemberlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberList memberListGUI = new MemberList(store,memberList);
				memberListGUI.run();
			}
		});
		btnMemberlist.setBounds(10, 80, 364, 60);
		contentPane.add(btnMemberlist);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

}
