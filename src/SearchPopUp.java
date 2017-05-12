import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SearchPopUp extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Concert> concertList;
	private static ArrayList<Customer> memberList;
	private static ArrayList<Bill> billList;
	private static Store store;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPopUp frame = new SearchPopUp(store,concertList,memberList,billList);
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
	public SearchPopUp(Store store,ArrayList<Concert> concertList,ArrayList<Customer> memberList,ArrayList<Bill> billList) {
		setTitle("Search");
		setBounds(100, 100, 400, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.store = store;
		this.concertList = concertList;
		this.memberList = memberList;
		this.billList = billList;
		
		JButton searchConcert = new JButton("Search Concert");
		searchConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCon searchCon = new SearchCon(store,concertList);
				searchCon.run();
			}
		});
		searchConcert.setBounds(10, 10, 364, 60);
		contentPane.add(searchConcert);
		
		JButton searchMember = new JButton("Search Member");
		searchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomer searchCustomer = new SearchCustomer(store,memberList);
				searchCustomer.run();
			}
		});
		searchMember.setBounds(10, 80, 364, 60);
		contentPane.add(searchMember);
		
		JButton searchBill = new JButton("Search Bill");
		searchBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBill searchBill = new SearchBill(store,billList);
				searchBill.run();
			}
		});
		searchBill.setBounds(10, 150, 364, 60);
		contentPane.add(searchBill);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}


