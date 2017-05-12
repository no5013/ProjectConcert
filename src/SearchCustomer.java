import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Component;                                       
import java.util.ArrayList;
public class SearchCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField inNameT;
	private JTextField inLastT;
	private JTextField cusIDT;
	private JTextField nameT;
	private JTextField lastT;
	private JTextField genT;
	private JTextField telT;
	private JTextField memT;
	private JTextField disT;
	private JTextField IDT;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	private void showDialog(String dialogBox,String dialogHead){
		JOptionPane.showMessageDialog(this,dialogBox,dialogHead,JOptionPane.PLAIN_MESSAGE);
	}


	public SearchCustomer(Store store,ArrayList<Customer> memberList) {
		setResizable(false);
		setTitle("Search and Print");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 774, 550);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCustomerSearchprintBill = new JLabel("Customer Search/Print Bill");
		lblCustomerSearchprintBill.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerSearchprintBill.setBounds(0, 0, 284, 44);
		panel.add(lblCustomerSearchprintBill);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(70, 78, 65, 25);
		panel.add(lblNewLabel);

		inNameT = new JTextField();
		inNameT.setColumns(10);
		inNameT.setBounds(133, 78, 140, 25);
		panel.add(inNameT);

		JButton btnGetInfo = new JButton("Search");

		btnGetInfo.setBounds(569, 75, 120, 30);
		panel.add(btnGetInfo);

		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastname.setBounds(300, 78, 88, 25);
		panel.add(lblLastname);

		inLastT = new JTextField();
		inLastT.setColumns(10);
		inLastT.setBounds(382, 78, 140, 25);
		panel.add(inLastT);

		JLabel lblId = new JLabel("Customer ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(70, 195, 110, 25);
		panel.add(lblId);

		cusIDT = new JTextField();
		cusIDT.setColumns(10);
		cusIDT.setBounds(190, 195, 86, 25);
		panel.add(cusIDT);

		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(70, 267, 65, 25);
		panel.add(label);

		nameT = new JTextField();
		nameT.setColumns(10);
		nameT.setBounds(190, 267, 140, 25);
		panel.add(nameT);

		JLabel label_1 = new JLabel("Lastname");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(70, 303, 88, 25);
		panel.add(label_1);

		lastT = new JTextField();
		lastT.setColumns(10);
		lastT.setBounds(190, 303, 140, 25);
		panel.add(lastT);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(70, 339, 88, 25);
		panel.add(lblGender);

		genT = new JTextField();
		genT.setColumns(10);
		genT.setBounds(190, 339, 86, 25);
		panel.add(genT);

		JLabel lblTel = new JLabel("Tel");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTel.setBounds(70, 375, 88, 25);
		panel.add(lblTel);

		telT = new JTextField();
		telT.setColumns(10);
		telT.setBounds(190, 375, 140, 25);
		panel.add(telT);

		JLabel lblMemberClass = new JLabel("Member Class");
		lblMemberClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemberClass.setBounds(70, 411, 110, 25);
		panel.add(lblMemberClass);

		memT = new JTextField();
		memT.setColumns(10);
		memT.setBounds(190, 411, 86, 25);
		panel.add(memT);

		JLabel lblDiscountRate = new JLabel("Discount Rate");
		lblDiscountRate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiscountRate.setBounds(70, 447, 110, 25);
		panel.add(lblDiscountRate);

		disT = new JTextField();
		disT.setColumns(10);
		disT.setBounds(190, 450, 86, 25);
		panel.add(disT);

		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId_1.setBounds(70, 231, 110, 25);
		panel.add(lblId_1);

		IDT = new JTextField();
		IDT.setColumns(10);
		IDT.setBounds(190, 231, 86, 25);
		panel.add(IDT);

		JLabel lblInfomation = new JLabel("Infomation");
		lblInfomation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInfomation.setBounds(70, 140, 284, 44);
		panel.add(lblInfomation);

		JLabel lblTicketlist = new JLabel("Ticket List");
		lblTicketlist.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTicketlist.setBounds(448, 140, 284, 44);
		panel.add(lblTicketlist);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(448, 195, 284, 101);
		panel.add(scrollPane);

		JTextArea ticT = new JTextArea();
		scrollPane.setViewportView(ticT);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(448, 371, 284, 101);
		panel.add(scrollPane_1);

		JTextArea billT = new JTextArea();
		scrollPane_1.setViewportView(billT);

		JLabel lblBillList = new JLabel("Bill List");
		lblBillList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBillList.setBounds(448, 320, 284, 44);
		panel.add(lblBillList);

		cusIDT.setEditable(false);
		IDT.setEditable(false);
		nameT.setEditable(false);
		lastT.setEditable(false);
		genT.setEditable(false);
		telT.setEditable(false);
		memT.setEditable(false);
		disT.setEditable(false);
		ticT.setEditable(false);
		billT.setEditable(false);
		
		
		btnGetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = store.searchCustomerByName(memberList,inNameT.getText(),inLastT.getText());

				if(index!=-1){
					Customer show = memberList.get(index);
					cusIDT.setText(show.getCustomerID());
					IDT.setText(show.getId());
					nameT.setText(show.getName());
					lastT.setText(show.getLastname());
					genT.setText(show.getGender());
					telT.setText(show.getTel());
					memT.setText(show.getMemberClass()+"");
					disT.setText(show.getDiscountRate()+"");
					ticT.setText(show.getTicketListToString());
					billT.setText(show.getBillListToString());
					
				}
				else{
					showDialog("User not found!!!!!","Error!!!");
				}
			}
		});


	}

	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
