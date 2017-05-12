import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;




public class ReceivePayment extends JFrame {

	private JPanel contentPane;
	private JLabel lblCustomerId;
	private JButton btnReceivePayment;
	private JTextField txtPs;
	private JLabel conID;
	private JTextField textField_conID;
	private JLabel lblName;
	private JTextField textField_name;
	private JLabel lblLastName;
	private JTextField textField_lastname;
	private JTextArea textArea;
	private int mode;
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
					ReceivePayment frame = new ReceivePayment(store,concertList,memberList,billList);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 */

	private void showDialog(String dialogBox,String dialogHead){
		JOptionPane.showMessageDialog(this,dialogBox,dialogHead,JOptionPane.PLAIN_MESSAGE);
	}


	public ReceivePayment(Store store,ArrayList<Concert> concertList,ArrayList<Customer> memberList,ArrayList<Bill> billList) {
		setTitle("Receive Payment");
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.store = store;
		this.concertList = concertList;
		this.memberList = memberList;
		this.billList = billList;
		
		JLabel lblReceivePayment = new JLabel("Receive Payment");
		lblReceivePayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReceivePayment.setBounds(307, 56, 179, 32);
		contentPane.add(lblReceivePayment);

		lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerId.setBounds(98, 220, 100, 24);
		contentPane.add(lblCustomerId);

		btnReceivePayment = new JButton("Receive Payment");
		btnReceivePayment.setBounds(307, 491, 179, 44);
		contentPane.add(btnReceivePayment);

		conID = new JLabel("Concert ID");
		conID.setBounds(98, 175, 60, 24);
		contentPane.add(conID);

		/*textField_conID = new JTextField();
		textField_conID.setColumns(10);
		textField_conID.setBounds(98, 71, 86, 20);
		contentPane.add(textField_conID);*/
		
	    String[] conIDnum = new String[concertList.size()];
		for(int i=0;i<concertList.size();i++)
			conIDnum[i] = i+1+"";
		JComboBox conID = new JComboBox(conIDnum);
		conID.setBounds(195, 177, 86, 20);
		contentPane.add(conID);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(127, 220, 51, 24);
		contentPane.add(lblName);

		lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(328, 220, 78, 24);
		lblLastName.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		contentPane.add(lblLastName);

		textField_lastname = new JTextField();
		textField_lastname.setColumns(10);
		textField_lastname.setBounds(402, 224, 113, 20);
		contentPane.add(textField_lastname);

		textArea = new JTextArea();
		textArea.setBounds(78, 275, 638, 199);
		contentPane.add(textArea);

		JComboBox comboBox = new JComboBox(new String[] {"CustomerID","CustomerName"});
		comboBox.setBounds(402, 177, 115, 20);
		contentPane.add(comboBox);

		JLabel lblPayBy = new JLabel("Customer");
		lblPayBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPayBy.setBounds(328, 173, 63, 24);
		contentPane.add(lblPayBy);

		txtPs = new JTextField();
		txtPs.setText("PS:");
		txtPs.setColumns(10);
		txtPs.setBounds(195, 224, 113, 20);
		contentPane.add(txtPs);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(196, 224, 113, 20);
		contentPane.add(textField_name);

		/*lblCustomerId.setVisible(true);
		lblLastName.setVisible(false);
		lblName.setVisible(false);

		textField_cusID.setVisible(true);
		textField_name.setVisible(false);
		textField_lastname.setVisible(false);*/

		contentPane.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				String combo = (String) comboBox.getSelectedItem();
				if(combo.equals("CustomerID")){
					mode=1;
					lblCustomerId.setVisible(true);
					lblLastName.setVisible(false);
					lblName.setVisible(false);

					txtPs.setVisible(true);
					textField_name.setVisible(false);
					textField_lastname.setVisible(false);
				}
				else if(combo.equals("CustomerName")){
					mode=2;
					lblCustomerId.setVisible(false);
					lblLastName.setVisible(true);
					lblName.setVisible(true);

					txtPs.setVisible(false);
					textField_name.setVisible(true);
					textField_lastname.setVisible(true);

				}

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnReceivePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(mode == 1){		
					
					
					int indexCus = store.searchCustomerByCustomerID(memberList, txtPs.getText());
					int indexCon = store.searchConcertByIndex(concertList, Integer.parseInt((String)conID.getSelectedItem())-1);
					
					if(indexCon!=-1&&indexCus!=-1&&store.receivePayment(concertList.get(indexCon),memberList.get(indexCus),billList)!=-1){
						textArea.setText(concertList.get(indexCon).toString()+"\n"+memberList.get(indexCus).toString()+"\n"+memberList.get(indexCus).getTicketListToString());
						showDialog("Success","receivePayment Success!!!!!!");
					}
					else {
						textArea.setText("not found");
						showDialog("Member or Concert not found!!!!!","Error!!!");
					}

				}

				
				
				if(mode == 2){		
			
					int indexCus = store.searchCustomerByName(memberList,textField_name.getText(),textField_lastname.getText());
					int indexCon = store.searchConcertByIndex(concertList, Integer.parseInt((String)conID.getSelectedItem()));
					
					
					if(indexCon!=-1&&indexCus!=-1&&store.receivePayment(concertList.get(indexCon),memberList.get(indexCus),billList)!=-1){
						textArea.setText(concertList.get(indexCon).toString()+"\n"+memberList.get(indexCus).toString()+"\n"+memberList.get(indexCus).getTicketListToString());
						showDialog("Success","receivePayment Success!!!!!!");
					}
					else {
						textArea.setText("not found");
						showDialog("Member or Concert not found!!!!!","Error!!!");
						System.out.print(memberList.get(indexCus).getName());
					}

				}



			}
		});

	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
