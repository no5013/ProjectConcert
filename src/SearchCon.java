import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class SearchCon extends JFrame {

	private JPanel contentPane;
	private JTextField Id;
	private JTextField name;
	private JTextField date;
	private JTextField time;
	private JTextField venue;
	private JTextField price;
	private static Concert selectedConcert;
	private JTextField noT;
	private static ArrayList<Concert> concertList;
	private static Store store;

	/**
	 * Launch the application.
	 */
	private void showDialog(String dialogBox,String dialogHead){
		JOptionPane.showMessageDialog(this,dialogBox,dialogHead,JOptionPane.PLAIN_MESSAGE);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCon frame = new SearchCon(store,concertList);
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
	public SearchCon(Store store,ArrayList<Concert> concertList) {
		setTitle("Concert Info");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ClassLoader loader = this.getClass().getClassLoader();
		this.concertList = concertList;
		this.store = store;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel poster = new JLabel();
		poster.setBackground(Color.BLACK);
		poster.setBounds(69, 136, 225, 300);
		panel.add(poster);
		
		JLabel lblNewLabel_1 = new JLabel("Concert ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(383, 136, 114, 28);
		panel.add(lblNewLabel_1);
		
		Id = new JTextField();
		Id.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Id.setBounds(488, 139, 149, 28);
		panel.add(Id);
		Id.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(383, 178, 114, 28);
		panel.add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(488, 181, 149, 28);
		panel.add(name);
		
		JLabel lblInfomation = new JLabel("Description");
		lblInfomation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInfomation.setBounds(383, 220, 114, 28);
		panel.add(lblInfomation);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(383, 310, 114, 28);
		panel.add(lblDate);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(488, 313, 149, 28);
		panel.add(date);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(383, 352, 114, 28);
		panel.add(lblTime);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 220, 149, 82);
		panel.add(scrollPane);
		
		JTextPane info = new JTextPane();
		scrollPane.setViewportView(info);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(488, 355, 149, 28);
		panel.add(time);
		
		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVenue.setBounds(383, 394, 114, 28);
		panel.add(lblVenue);
		
		venue = new JTextField();
		venue.setColumns(10);
		venue.setBounds(487, 396, 150, 30);
		panel.add(venue);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setBounds(383, 437, 114, 28);
		panel.add(lblPrice);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(488, 439, 150, 30);
		panel.add(price);
		
		JLabel label = new JLabel("Customer Search/Print Bill");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(10, 11, 284, 44);
		panel.add(label);
		
		JLabel lblConcertNo = new JLabel("Concert No.");
		lblConcertNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConcertNo.setBounds(41, 66, 93, 25);
		panel.add(lblConcertNo);
		
		noT = new JTextField();
		noT.setText("1");
		noT.setColumns(10);
		noT.setBounds(140, 66, 140, 25);
		panel.add(noT);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = store.searchConcertByIndex(concertList, Integer.parseInt(noT.getText())-1);
				if(index!=-1){
					Concert concert = concertList.get(index);
					poster.setIcon(new ImageIcon(loader.getResource(concert.getUrl())));
					Id.setText(concert.getConcertInfo().getConcertID());
					name.setText(concert.getConcertInfo().getConName());
					info.setText(concert.getConcertInfo().getInfo());
					date.setText(concert.getConcertInfo().getConDate().toString());
					time.setText(concert.getConcertInfo().getConTime().toString());
					venue.setText(concert.getConcertInfo().getVenue());
					price.setText(concert.getZonePrice()[0]+"/"+concert.getZonePrice()[1]+"/"+concert.getZonePrice()[2]+"/"+concert.getZonePrice()[3]+"/"+concert.getZonePrice()[4]);
				}
				
				else{
					showDialog("Concert not found!!!!!","Error!!!");
				}
				
			}
		});
		button.setBounds(320, 63, 120, 30);
		panel.add(button);
		
		JButton btnCustomerList = new JButton("Customer List");
		btnCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = store.searchConcertByIndex(concertList, Integer.parseInt(noT.getText())-1);
				if(index!=-1){
					Concert concert = concertList.get(index);
				CustomerList customerList = new CustomerList(concert);
				customerList.run();
				}
				
				else{
					showDialog("Concert not found!!!!!","Error!!!");
				}
			}
		});
		btnCustomerList.setBounds(120, 474, 120, 30);
		panel.add(btnCustomerList);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
