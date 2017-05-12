import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;


public class AddNewCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textCustomerID;
	private String selectedButton = "";
	private JComboBox comboBox;
	private static ArrayList<Customer> memberList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewCustomer frame = new AddNewCustomer(memberList);
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
	public AddNewCustomer(ArrayList<Customer> memberList) {
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.memberList = memberList;
		
		JLabel lblAddNewCustomer = new JLabel("Add new customer");
		lblAddNewCustomer.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblAddNewCustomer.setBounds(308, 9, 222, 33);
		contentPane.add(lblAddNewCustomer);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblId.setBounds(28, 120, 185, 33);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblName.setBounds(28, 178, 185, 33);
		contentPane.add(lblName);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblLastname.setBounds(28, 243, 185, 29);
		contentPane.add(lblLastname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblGender.setBounds(28, 362, 131, 27);
		contentPane.add(lblGender);
		
		JLabel lblMemberclass = new JLabel("MemberClass");
		lblMemberclass.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblMemberclass.setBounds(28, 298, 185, 33);
		contentPane.add(lblMemberclass);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblTel.setBounds(28, 425, 185, 26);
		contentPane.add(lblTel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Gabriola", Font.BOLD, 30));
		btnSave.setBounds(319, 499, 157, 41);
		contentPane.add(btnSave);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField.setBounds(224, 123, 196, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_1.setBounds(224, 181, 196, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_2.setBounds(224, 243, 196, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textField_5.setBounds(224, 422, 196, 29);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCustomerid = new JLabel("CustomerID");
		lblCustomerid.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblCustomerid.setBounds(28, 64, 185, 32);
		contentPane.add(lblCustomerid);
		
		textCustomerID = new JTextField();
		textCustomerID.setFont(new Font("Gabriola", Font.PLAIN, 25));
		textCustomerID.setEditable(false);
		if(memberList.size()!=0)
			textCustomerID.setText("PS:"+(memberList.get(memberList.size()-1).getNumberOfCustomers()+1));
		else
			textCustomerID.setText("PS:0");
			
		
		textCustomerID.setBounds(224, 69, 196, 32);
		contentPane.add(textCustomerID);
		textCustomerID.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Gabriola", Font.PLAIN, 25));
		rdbtnMale.setBounds(224, 301, 91, 29);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Gabriola", Font.PLAIN, 25));
		rdbtnFemale.setBounds(319, 302, 101, 29);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup buttonGroup = new ButtonGroup();

		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		
		
		List<String> list = new ArrayList<String>();
		for(int i=0; i<=2; i++) list.add(i+"");
		comboBox = 	new JComboBox(list.toArray());
		comboBox.setFont(new Font("Gabriola", Font.PLAIN, 25));
		comboBox.setBounds(224, 362, 74, 29);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Gabriola", Font.PLAIN, 20));
		textArea.setBounds(444, 55, 312, 418);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddNewCustomer.class.getResource("/image/BGNewCus2.png")));
		lblNewLabel.setBounds(0, 0, 782, 563);
		contentPane.add(lblNewLabel);
		
		
		btnSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				if (rdbtnMale.isSelected()) {
				    selectedButton = "Male";
				}
				else if (rdbtnFemale.isSelected()) {
				    selectedButton = "Female";
				}
				//String customerID =
				String ID = textField.getText();
				String name = textField_1.getText();
				String lastname = textField_2.getText();
				String gender = selectedButton;
				int memberClass = Integer.parseInt((String)comboBox.getSelectedItem());
				String tel = textField_5.getText();
				Customer customer = new Customer(ID,name,lastname,gender,tel,memberClass);
				textArea.setText(customer.toString());
				memberList.add(customer);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_5.setText("");
				if(memberList.size()!=0)
					textCustomerID.setText("PS:"+(memberList.get(memberList.size()-1).getNumberOfCustomers()+1));
				else
					textCustomerID.setText("PS:0");
				showDialog();
			}
		});
	}
	private void showDialog(){
		JOptionPane.showMessageDialog(null,"Successful","DialogBox",JOptionPane.PLAIN_MESSAGE);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
