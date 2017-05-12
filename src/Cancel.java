import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Cancel extends JFrame {

	private JPanel contentPane;
	private JTextField txtcustomerid;
	private JTextField txtconcertid;
	private JTextField textField_2;
	private static ArrayList<Concert> concertList;
	private static ArrayList<Customer> memberList;
	private static ArrayList<Ticket> ticketList;
	private static Store store;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancel frame = new Cancel(store,concertList,memberList,ticketList);
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
	public Cancel(Store store,ArrayList<Concert> concertList,ArrayList<Customer> memberList,ArrayList<Ticket> ticketList) {
		setTitle("Cancel / Clear");
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCancel.setBounds(20, 31, 121, 17);
		contentPane.add(lblCancel);
		
		JLabel lblCustimerid = new JLabel("CustimerID");
		lblCustimerid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustimerid.setBounds(20, 72, 92, 14);
		contentPane.add(lblCustimerid);
		
		txtcustomerid = new JTextField();
		txtcustomerid.setBounds(100, 71, 107, 20);
		contentPane.add(txtcustomerid);
		txtcustomerid.setColumns(10);
		
		JLabel lblConcertid = new JLabel("ConcertID");
		lblConcertid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConcertid.setBounds(236, 72, 89, 14);
		contentPane.add(lblConcertid);
		
		txtconcertid = new JTextField();
		txtconcertid.setBounds(314, 71, 121, 20);
		contentPane.add(txtconcertid);
		txtconcertid.setColumns(10);
		
		JTextArea txtcancel = new JTextArea();
		txtcancel.setBounds(20, 97, 754, 128);
		contentPane.add(txtcancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 282, 754, 11);
		contentPane.add(separator);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClear.setBounds(20, 304, 72, 20);
		contentPane.add(lblClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseListener() {

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
				
				//int indexCon = MainPage.store.searchConcertByConcertID(concertList,txtconcertid.getText());
				int indexCus = store.searchCustomerByCustomerID(memberList, txtcustomerid.getText());
				int indexCon = store.searchConcertByIndex(concertList, Integer.parseInt(txtconcertid.getText()));
				
				
				if(indexCon!=-1&&indexCus!=-1&&store.cancel(concertList.get(indexCon),memberList.get(indexCus))!=-1){
					txtcancel.setText(concertList.get(indexCon).toString()+"\n"+memberList.get(indexCus).toString()+"\n"+memberList.get(indexCus).getTicketListToString());
					store.cancel(concertList.get(indexCon), memberList.get(indexCus));
					showDialog("Success","Cancel Success!!!!!!");
				}
				else {
					txtcancel.setText("not found");
					showDialog("Member or Concert not found!!!!!","Error!!!");
				}

			}
		});
			
				
		btnCancel.setBounds(323, 236, 150, 35);
		contentPane.add(btnCancel);
		
		JLabel lblConcertid_1 = new JLabel("ConcertID");
		lblConcertid_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConcertid_1.setBounds(20, 349, 89, 17);
		contentPane.add(lblConcertid_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 349, 129, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(20, 377, 754, 128);
		contentPane.add(textArea_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(323, 516, 150, 35);
		contentPane.add(btnClear);
		
		btnClear.addMouseListener(new MouseListener() {

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
				
				//int indexCon = MainPage.store.searchConcertByConcertID(concertList,txtconcertid.getText());
				int indexCon = store.searchConcertByIndex(concertList, Integer.parseInt(txtconcertid.getText()));
				
				store.clearConcert(concertList.get(indexCon));
				

			}
		});
	}
	
	private void showDialog(String dialogBox,String dialogHead){
		JOptionPane.showMessageDialog(this,dialogBox,dialogHead,JOptionPane.PLAIN_MESSAGE);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
