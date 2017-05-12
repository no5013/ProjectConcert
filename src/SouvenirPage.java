import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class SouvenirPage extends JFrame {

	private JPanel contentPane;
	private Souvenir selectSouvenir;
	private static Store store;
	private static ArrayList<Customer> memberList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SouvenirPage frame = new SouvenirPage(store,memberList);
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
	public SouvenirPage(Store store,ArrayList<Customer> memberList) {
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.store = store;
		
		
		Souvenir pro1 = new Souvenir("Lightsticks",50,20,new ImageIcon(SouvenirPage.class.getResource("/image/product1.png")));
		Souvenir pro2 = new Souvenir("Pauloakenfold File",220,80,new ImageIcon(SouvenirPage.class.getResource("/image/product2.png")));
		Souvenir pro3 = new Souvenir("One Direction Bag",750,520,new ImageIcon(SouvenirPage.class.getResource("/image/product3.png")));
		Souvenir pro4 = new Souvenir("T-shirt",350,160,new ImageIcon(SouvenirPage.class.getResource("/image/product4.png")));
		Souvenir pro5 = new Souvenir("Overcoal Bag",100,70,new ImageIcon(SouvenirPage.class.getResource("/image/product5.png")));
		
		JLabel lblPic1 = new JLabel("pic1");
		lblPic1.setIcon(new ImageIcon(SouvenirPage.class.getResource("/image/product1.png")));
		lblPic1.setBounds(28, 134, 150, 200);
		contentPane.add(lblPic1);
		
		JLabel lblPic2 = new JLabel("pic2");
		lblPic2.setIcon(new ImageIcon(SouvenirPage.class.getResource("/image/product2.png")));
		lblPic2.setBounds(187, 134, 150, 200);
		contentPane.add(lblPic2);
		
		JLabel lblPic3 = new JLabel("pic3");
		lblPic3.setIcon(new ImageIcon(SouvenirPage.class.getResource("/image/product3.png")));
		lblPic3.setBounds(344, 134, 150, 200);
		contentPane.add(lblPic3);
		
		JLabel lblPic4 = new JLabel("pic4");
		lblPic4.setIcon(new ImageIcon(SouvenirPage.class.getResource("/image/product4.png")));
		lblPic4.setBounds(501, 134, 150, 200);
		contentPane.add(lblPic4);
		
		JLabel lblPic5 = new JLabel("pic5");
		lblPic5.setIcon(new ImageIcon(SouvenirPage.class.getResource("/image/product5.png")));
		lblPic5.setBounds(663, 134, 150, 200);
		contentPane.add(lblPic5);
		
		JLabel lblNewLabel = new JLabel("Lightsticks");
		lblNewLabel.setBounds(28, 347, 150, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price : 50 THB");
		lblPrice.setBounds(28, 410, 150, 50);
		contentPane.add(lblPrice);
		
		JLabel lblPauloakenfoldFile = new JLabel("Pauloakenfold File");
		lblPauloakenfoldFile.setBounds(187, 347, 150, 50);
		contentPane.add(lblPauloakenfoldFile);
		
		JLabel lblPrice_2 = new JLabel("Price : 220 THB");
		lblPrice_2.setBounds(187, 410, 150, 50);
		contentPane.add(lblPrice_2);
		
		JLabel lblOneDirectionBag = new JLabel("One Direction Bag");
		lblOneDirectionBag.setBounds(344, 347, 150, 50);
		contentPane.add(lblOneDirectionBag);
		
		JLabel lblPrice_1 = new JLabel("Price : 750 THB");
		lblPrice_1.setBounds(344, 410, 150, 50);
		contentPane.add(lblPrice_1);
		
		JLabel lblTshirt = new JLabel("T-shirt ");
		lblTshirt.setBounds(501, 347, 150, 50);
		contentPane.add(lblTshirt);
		
		JLabel lblPrice_3 = new JLabel("Price : 350 THB");
		lblPrice_3.setBounds(501, 410, 150, 50);
		contentPane.add(lblPrice_3);
		
		JLabel lblOvercoalBag = new JLabel("Overcoal Bag");
		lblOvercoalBag.setBounds(663, 347, 150, 50);
		contentPane.add(lblOvercoalBag);
		
		JLabel lblPrice_4 = new JLabel("Price : 100 THB");
		lblPrice_4.setBounds(663, 410, 150, 50);
		contentPane.add(lblPrice_4);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SouvenirPopUp page1 = new SouvenirPopUp(store, pro1, memberList);
				page1.run();
			}
		});
		btnNewButton.setBounds(56, 473, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Buy");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SouvenirPopUp page2 = new SouvenirPopUp(store, pro2, memberList);
				page2.run();
			}
		});
		button.setBounds(210, 473, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Buy");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SouvenirPopUp page3 = new SouvenirPopUp(store, pro3, memberList);
				page3.run();
			}
		});
		button_1.setBounds(371, 473, 97, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Buy");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SouvenirPopUp page4 = new SouvenirPopUp(store, pro4, memberList);
				page4.run();
			}
		});
		button_2.setBounds(536, 473, 97, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Buy");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SouvenirPopUp page5 = new SouvenirPopUp(store, pro5, memberList);
				page5.run();
			}
		});
		button_3.setBounds(700, 473, 97, 25);
		contentPane.add(button_3);
		
		
		
	}

	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
