import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class SearchBill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField nameT;
	private JTextField lastnameT;
	private JTextField conNameT;
	private JTextField zoneT;
	private JTextField priceT;
	private static Store store;
	private static ArrayList<Bill> billList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill(store,billList);
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
	
	public SearchBill(Store store,ArrayList<Bill> billList) {
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.store = store;
		
		JLabel lblSearchBill = new JLabel("Search Bill");
		lblSearchBill.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchBill.setBounds(10, 11, 284, 44);
		contentPane.add(lblSearchBill);
		
		JLabel lblNumberOfBill = new JLabel("Number Of Bill");
		lblNumberOfBill.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberOfBill.setBounds(24, 108, 116, 25);
		contentPane.add(lblNumberOfBill);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(177, 108, 128, 25);
		contentPane.add(textField);
		
		
		
		JButton searchB = new JButton("Search");
		
		searchB.setBounds(331, 108, 120, 30);
		contentPane.add(searchB);
		
		JLabel lblPayer = new JLabel("Payer");
		lblPayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPayer.setBounds(91, 180, 116, 25);
		contentPane.add(lblPayer);
		
		nameT = new JTextField();
		nameT.setColumns(10);
		nameT.setBounds(288, 183, 128, 25);
		contentPane.add(nameT);
		
		lastnameT = new JTextField();
		lastnameT.setColumns(10);
		lastnameT.setBounds(524, 183, 128, 25);
		contentPane.add(lastnameT);
		
		JLabel lblConcertName = new JLabel("Concert Name");
		lblConcertName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConcertName.setBounds(91, 248, 128, 25);
		contentPane.add(lblConcertName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(217, 180, 116, 25);
		contentPane.add(lblName);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastname.setBounds(429, 180, 116, 25);
		contentPane.add(lblLastname);
		
		conNameT = new JTextField();
		conNameT.setColumns(10);
		conNameT.setBounds(288, 251, 128, 25);
		contentPane.add(conNameT);
		
		JLabel lblZone = new JLabel("Zone");
		lblZone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblZone.setBounds(91, 312, 128, 25);
		contentPane.add(lblZone);
		
		zoneT = new JTextField();
		zoneT.setColumns(10);
		zoneT.setBounds(288, 315, 70, 25);
		contentPane.add(zoneT);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setBounds(91, 373, 128, 25);
		contentPane.add(lblPrice);
		
		priceT = new JTextField();
		priceT.setColumns(10);
		priceT.setBounds(288, 376, 128, 25);
		contentPane.add(priceT);
		
		JButton printB = new JButton("Print this bill");
		printB.setBounds(313, 477, 150, 50);
		contentPane.add(printB);
		
		nameT.setEditable(false);
		lastnameT.setEditable(false);
		conNameT.setEditable(false);
		zoneT.setEditable(false);
		priceT.setEditable(false);
		
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = store.searchBillByNumberOfBill(billList, Integer.parseInt(textField.getText()));
				if(index!=-1){
					Bill bill = billList.get(index);
					nameT.setText(bill.getPayer().getName());
					lastnameT.setText(bill.getPayer().getLastname());
					conNameT.setText(bill.getTicket().getConcertInfo().getConName());
					zoneT.setText(bill.getTicket().getZone());
					priceT.setText(bill.getTicket().getPrice()+"");
				}
				else {
					showDialog("Bill not found!!!!!","Error!!!");
				}
					
				
				
			}
		});
	}
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
