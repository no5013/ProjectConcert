import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class SouvenirPopUp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldcustomerID;
	private static Souvenir selectSou;
	private static Store store;
	private static ArrayList<Customer> memberList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SouvenirPopUp frame = new SouvenirPopUp(store,selectSou,memberList);
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
	public SouvenirPopUp(Store store,Souvenir souvenir,ArrayList<Customer> memberList) {
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.selectSou = souvenir;
		this.store = store;
		
		JLabel lblCustomerid = new JLabel("CustomerID");
		lblCustomerid.setBounds(131, 102, 167, 54);
		contentPane.add(lblCustomerid);
		
		textFieldcustomerID = new JTextField();
		textFieldcustomerID.setBounds(309, 103, 267, 56);
		contentPane.add(textFieldcustomerID);
		textFieldcustomerID.setColumns(10);
		
		JTextArea txtrInfobuy = new JTextArea();
		txtrInfobuy.setBounds(51, 257, 674, 232);
		contentPane.add(txtrInfobuy);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexC = store.searchCustomerByCustomerID(memberList, textFieldcustomerID.getText());
				Customer customer = memberList.get(indexC);
				if(indexC==-1) {
					txtrInfobuy.setText("not found");
				}
				else {
					store.buySouvenir(customer, selectSou);
					txtrInfobuy.setText("buying successful");
				}
			}
		});
		btnBuy.setBounds(286, 184, 178, 41);
		contentPane.add(btnBuy);

	}

	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
