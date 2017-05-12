import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConcertPopUp extends JFrame {
	
	private static Store store;
	private static ArrayList<Concert> concertList;
	private static ArrayList<Customer> memberList;
	private static ArrayList<Ticket> ticketList;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcertPopUp frame = new ConcertPopUp(store,concertList,memberList,ticketList);
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
	public ConcertPopUp(Store store,ArrayList<Concert> concertList,ArrayList<Customer> memberList,ArrayList<Ticket> ticketList) {
		setTitle("Concert");
		setBounds(100, 100, 400, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.concertList = concertList;
		this.memberList = memberList;
		this.ticketList = ticketList;
		this.store = store;
		
		JButton btnConcert = new JButton("Buy Ticket");
		btnConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectConcert selectConcert = new SelectConcert(store,concertList,memberList,ticketList);
				selectConcert.run();
			}
		});
		btnConcert.setBounds(10, 10, 364, 60);
		contentPane.add(btnConcert);
		
		JButton btnCancelclear = new JButton("Cancel / Clear ");
		btnCancelclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancel cancel = new Cancel(store,concertList,memberList,ticketList);
				cancel.run();
			}
		});
		btnCancelclear.setBounds(10, 80, 364, 60);
		contentPane.add(btnCancelclear);
	}

	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
	
}
