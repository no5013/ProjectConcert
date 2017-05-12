import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagementPopUp extends JFrame {

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
					ManagementPopUp frame = new ManagementPopUp(store,concertList, memberList,billList);
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
	public ManagementPopUp(Store store,ArrayList<Concert> concertList,ArrayList<Customer> memberList,ArrayList<Bill> billList) {
		setTitle("Management");
		setBounds(100, 100, 400, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.concertList = concertList;
		this.memberList = memberList;
		this.billList = billList;
		this.store = store;
		
		JButton btnReceivePayment = new JButton("Receive Payment");
		btnReceivePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceivePayment receivePayment = new ReceivePayment(store,concertList,memberList,billList);
				receivePayment.run();
			}
		});
		btnReceivePayment.setBounds(10, 10, 364, 60);
		contentPane.add(btnReceivePayment);
		
		JButton btnStore = new JButton("Revenue - Expense");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreGUI storeGui = new StoreGUI(store);
				storeGui.run();
			}
		});
		btnStore.setBounds(10, 80, 364, 60);
		contentPane.add(btnStore);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

}
