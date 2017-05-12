import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class SelectConcertInfo extends JFrame {

	private JPanel contentPane;
	private JTextField Id;
	private JTextField name;
	private JTextField date;
	private JTextField time;
	private JTextField venue;
	private JTextField price;
	private static Concert selectedConcert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectConcertInfo frame = new SelectConcertInfo(selectedConcert);
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
	public SelectConcertInfo(Concert selectedConcert) {
		setTitle("Concert Info");
		setBounds(100, 100, 550, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ClassLoader loader = this.getClass().getClassLoader();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 421);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(loader.getResource(selectedConcert.getUrl())));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(27, 61, 225, 300);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Concert ID");
		lblNewLabel_1.setBounds(262, 61, 114, 28);
		panel.add(lblNewLabel_1);
		
		Id = new JTextField(selectedConcert.getConcertInfo().getConcertID());
		Id.setBounds(348, 61, 149, 28);
		panel.add(Id);
		Id.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(262, 100, 114, 28);
		panel.add(lblName);
		
		name = new JTextField(selectedConcert.getConcertInfo().getConName());
		name.setColumns(10);
		name.setBounds(348, 100, 149, 28);
		panel.add(name);
		
		JLabel lblInfomation = new JLabel("Description");
		lblInfomation.setBounds(262, 139, 114, 28);
		panel.add(lblInfomation);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(262, 232, 114, 28);
		panel.add(lblDate);
		
		date = new JTextField(selectedConcert.getConcertInfo().getConDate().toString());
		date.setColumns(10);
		date.setBounds(348, 232, 149, 28);
		panel.add(date);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(262, 271, 114, 28);
		panel.add(lblTime);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 139, 149, 82);
		panel.add(scrollPane);
		
		JTextPane info = new JTextPane();
		scrollPane.setViewportView(info);
		info.setText(selectedConcert.getConcertInfo().getInfo());
		
		time = new JTextField(selectedConcert.getConcertInfo().getConTime().toString());
		time.setColumns(10);
		time.setBounds(348, 271, 149, 28);
		panel.add(time);
		
		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setBounds(262, 310, 114, 28);
		panel.add(lblVenue);
		
		venue = new JTextField(selectedConcert.getConcertInfo().getVenue());
		venue.setColumns(10);
		venue.setBounds(348, 310, 149, 28);
		panel.add(venue);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(262, 348, 114, 28);
		panel.add(lblPrice);
		
		price = new JTextField(selectedConcert.getZonePrice()[0]+"/"+selectedConcert.getZonePrice()[1]+"/"+selectedConcert.getZonePrice()[2]+"/"+selectedConcert.getZonePrice()[3]+"/"+selectedConcert.getZonePrice()[4]);
		price.setColumns(10);
		price.setBounds(348, 349, 149, 28);
		panel.add(price);
		
		JLabel lblConcertInfo = new JLabel("Concert Info");
		lblConcertInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConcertInfo.setBounds(10, 0, 284, 44);
		panel.add(lblConcertInfo);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
