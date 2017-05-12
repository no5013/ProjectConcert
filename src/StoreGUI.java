import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


public class StoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblExpense;
	private JTextField textField_1;
	private JLabel lblProfit;
	private JTextField textField_2;
	private JLabel lblStore;
	private static Store store;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreGUI frame = new StoreGUI(store);
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
	public StoreGUI(Store store) {
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.store =store;
		
		JLabel lblRevenue = new JLabel("Revenue");
		lblRevenue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRevenue.setBounds(288, 158, 78, 30);
		contentPane.add(lblRevenue);
		
		textField = new JTextField(store.getRevenue()+"");
		textField.setBounds(376, 161, 153, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblExpense = new JLabel("Expense");
		lblExpense.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblExpense.setBounds(288, 226, 78, 30);
		contentPane.add(lblExpense);
		
		textField_1 = new JTextField(store.getExpense()+"");
		textField_1.setColumns(10);
		textField_1.setBounds(376, 229, 153, 30);
		contentPane.add(textField_1);
		
		lblProfit = new JLabel("Profit");
		lblProfit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProfit.setBounds(288, 297, 78, 30);
		contentPane.add(lblProfit);
		
		textField_2 = new JTextField(store.getProfit()+"");
		textField_2.setColumns(10);
		textField_2.setBounds(376, 300, 153, 30);
		contentPane.add(textField_2);
		
		lblStore = new JLabel("STORE");
		lblStore.setFont(new Font("Tahoma", Font.PLAIN, 54));
		lblStore.setBounds(313, 36, 184, 86);
		contentPane.add(lblStore);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
