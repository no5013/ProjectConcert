import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SelectConcert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static ArrayList<Concert> concertList;
	private static ArrayList<Customer> memberList;
	private static ArrayList<Ticket> ticketList;
	
	private int runner = 0;
	private static Store store;
	
	private Concert selectedConcert ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectConcert frame = new SelectConcert(store,concertList, memberList,ticketList);
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
	public SelectConcert(Store store,ArrayList<Concert> concertList,ArrayList<Customer> memberList,ArrayList<Ticket> ticketList) {
		setTitle("Select Concert");
		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.concertList = concertList;
		this.memberList = memberList;
		this.ticketList = ticketList;
		
		ClassLoader loader = this.getClass().getClassLoader();
		selectedConcert = concertList.get(runner) ;
		
		JButton nextB = new JButton("");
		
		
		
		JButton prevB = new JButton("");
		
		prevB.setIcon(new ImageIcon(SelectConcert.class.getResource("/image/prev.png")));
		prevB.setBounds(0, 204, 50, 100);
		contentPane.add(prevB);
		nextB.setIcon(new ImageIcon(SelectConcert.class.getResource("/image/next.png")));
		nextB.setBounds(734, 204, 50, 100);
		contentPane.add(nextB);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(287, 57, 225, 300);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel selectConcert = new JLabel("");
		selectConcert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SelectConcertInfo selectConcertInfo = new SelectConcertInfo(selectedConcert);
				selectConcertInfo.run();
			}
		});
		selectConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(runner).getUrl())));
		panel.add(selectConcert);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(522, 108, 225, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel nextConcert = new JLabel("");
		nextConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(setRunner(runner+1)).getUrl())));
		panel_1.add(nextConcert);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(48, 108, 225, 300);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel previousConcert = new JLabel("");
		previousConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(setRunner(runner-1)).getUrl())));
		panel_2.add(previousConcert);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Gabriola", Font.BOLD, 20));
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectZone selectZonePage = new SelectZone(store,selectedConcert,memberList,ticketList);
				selectZonePage.run();
			}
		});
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSelect.setBounds(355, 488, 108, 32);
		contentPane.add(btnSelect);
		
		JLabel lblConcertName = new JLabel("Concert Name");
		lblConcertName.setForeground(SystemColor.desktop);
		lblConcertName.setBackground(SystemColor.activeCaption);
		lblConcertName.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblConcertName.setBounds(287, 391, 114, 32);
		contentPane.add(lblConcertName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblDate.setBounds(287, 434, 114, 32);
		contentPane.add(lblDate);
		
		textField = new JTextField();
		textField.setFont(new Font("Gabriola", Font.PLAIN, 20));
		textField.setBounds(398, 398, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gabriola", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(398, 441, 114, 20);
		contentPane.add(textField_1);
		
		JLabel lblBG = new JLabel("New label");
		lblBG.setIcon(new ImageIcon(SelectConcert.class.getResource("/image/BG-selectCon3.png")));
		lblBG.setBounds(0, 0, 800, 597);
		contentPane.add(lblBG);
		
		nextB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++runner;
				runner = setRunner(runner);
				selectedConcert = concertList.get(runner);
				selectConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(runner).getUrl())));
				previousConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(setRunner(runner-1)).getUrl())));
				nextConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(setRunner(runner+1)).getUrl())));
				textField.setText(selectedConcert.getConcertInfo().getInfo());
				textField_1.setText(selectedConcert.getConcertInfo().getConDate().toString());
			}
		});
		
		prevB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				--runner;
				runner = setRunner(runner);
				selectedConcert = concertList.get(runner);
				selectConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(runner).getUrl())));
				previousConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(setRunner(runner-1)).getUrl())));
				nextConcert.setIcon(new ImageIcon(loader.getResource(concertList.get(setRunner(runner+1)).getUrl())));
				textField.setText(selectedConcert.getConcertInfo().getInfo());
				textField_1.setText(selectedConcert.getConcertInfo().getConDate().toString());
			}
		});
		
		nextB.setBorder(BorderFactory.createEmptyBorder());
		nextB.setContentAreaFilled(false);
		
		prevB.setBorder(BorderFactory.createEmptyBorder());
		prevB.setContentAreaFilled(false);
		
		
	}
	
	public int setRunner(int runner){
		int setRunner = runner;
		if(runner>concertList.size()-1)
			setRunner = 0;
		
		else if(runner<0)
			setRunner = concertList.size()-1;
		
		return setRunner;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
}
