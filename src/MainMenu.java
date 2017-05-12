import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;


public class MainMenu extends JFrame {

	private JPanel contentPane;
	protected static Store store;
	private static ArrayList<Concert> concertList;
	private static ArrayList<Customer> memberList;
	private static ArrayList<Bill> billList;
	private static ArrayList<Ticket> ticketList;

	private File customerFile;
	private File ticketFile;
	private File billFile;
	private File concertFile;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MainMenu() throws IOException {
		setTitle("Main Menu");
		setBounds(new Rectangle(0, 0, 800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Store store = new Store();
		concertList = new ArrayList<Concert>();
		memberList = new ArrayList<Customer>();
		billList = new ArrayList<Bill>();
		ticketList = new ArrayList<Ticket>();

		customerFile = new File("customerFile.txt");
		ticketFile = new File("ticketFile.txt");
		billFile = new File("billFile.txt");
		concertFile = new File("concertFile.txt");

		this.database();
		this.fileReader();
		this.TicketandBillYutter();
		ClassLoader loader = this.getClass().getClassLoader();
		ImageIcon head = new ImageIcon(loader.getResource("image/HEAD.jpg"));
		ImageIcon body = new ImageIcon(loader.getResource("image/bg.jpg"));
		ImageIcon b1 = new ImageIcon(loader.getResource("image/b1.jpg"));
		ImageIcon b2 = new ImageIcon(loader.getResource("image/b2.jpg"));
		ImageIcon b3 = new ImageIcon(loader.getResource("image/b3.jpg"));
		ImageIcon b4 = new ImageIcon(loader.getResource("image/b4.jpg"));
		ImageIcon b5 = new ImageIcon(loader.getResource("image/b5.jpg"));
		ImageIcon b6 = new ImageIcon(loader.getResource("image/b6.jpg"));

		JLabel headL = new JLabel("headL");
		headL.setIcon(head);
		headL.setBounds(53, 11, 724, 60);
		contentPane.add(headL);

		JLabel bodyL = new JLabel("bodyL");
		bodyL.setIcon(body);
		bodyL.setBounds(10, 85, 814, 400);
		contentPane.add(bodyL);

		JButton concertB = new JButton("Concert");
		concertB.setIcon(new ImageIcon(MainMenu.class.getResource("/image/iconCon.png")));
		concertB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ConcertPopUp popUp = new ConcertPopUp(store,concertList,memberList,ticketList);
				popUp.run();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				bodyL.setIcon(b1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bodyL.setIcon(body);
			}
		});
		concertB.setBounds(53, 496, 100, 100);
		contentPane.add(concertB);

		JButton ManagememtB = new JButton("Management");
		ManagememtB.setIcon(new ImageIcon(MainMenu.class.getResource("/image/iconManage.png")));
		ManagememtB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManagementPopUp popUp = new ManagementPopUp(store,concertList,memberList,billList);
				popUp.run();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				bodyL.setIcon(b2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bodyL.setIcon(body);
			}
		});
		ManagememtB.setBounds(177, 496, 100, 100);
		contentPane.add(ManagememtB);

		JButton memberB = new JButton("Member");
		memberB.setIcon(new ImageIcon(MainMenu.class.getResource("/image/iconCus3.png")));
		memberB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MemberPopUp popUp = new MemberPopUp(store,memberList);
				popUp.run();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				bodyL.setIcon(b3);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bodyL.setIcon(body);
			}
		});
		memberB.setBounds(302, 496, 100, 100);
		contentPane.add(memberB);

		JButton searchB = new JButton("Search");
		searchB.setIcon(new ImageIcon(MainMenu.class.getResource("/image/iconSearch.png")));
		searchB.setBounds(427, 496, 100, 100);
		contentPane.add(searchB);
		searchB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SearchPopUp popUp = new SearchPopUp(store,concertList,memberList,billList);
				popUp.run();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				bodyL.setIcon(b4);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bodyL.setIcon(body);
			}
		});


		JButton btnShop = new JButton("Shop");
		btnShop.setIcon(new ImageIcon(MainMenu.class.getResource("/image/iconShop.png")));
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SouvenirPage souPage = new SouvenirPage(store,memberList);
				souPage.run();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				bodyL.setIcon(b5);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bodyL.setIcon(body);
			}	
		});
		btnShop.setBounds(552, 496, 100, 100);
		contentPane.add(btnShop);



		JButton exitB = new JButton("Exit");
		exitB.setIcon(new ImageIcon(MainMenu.class.getResource("/image/iconExit.png")));
		exitB.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				//read customer
				try{
					FileWriter fw = new FileWriter(customerFile);
					PrintWriter pw = new PrintWriter(fw);
					for(int i=0;i<memberList.size();i++){
						pw.println(memberList.get(i).writeFile());
						System.out.println("CustomerW");
					}
					pw.close();
					fw.close();
				} catch (Exception e1){
					System.out.println(e1);
				}

				//read ticket
				try{
					FileWriter fw = new FileWriter(ticketFile);
					PrintWriter pw = new PrintWriter(fw);
					for(int i=0;i<ticketList.size();i++){
						pw.println(ticketList.get(i).writeFile());
						System.out.println("TicketW");
					}
					pw.close();
					fw.close();
				} catch (Exception e1){
					System.out.println(e1);
				}

				//read bill
				try{
					FileWriter fw = new FileWriter(billFile);
					PrintWriter pw = new PrintWriter(fw);
					for(int i=0;i<billList.size();i++){
						pw.println(billList.get(i).writeFile());
						System.out.println("billW");
					}
					pw.close();
					fw.close();
				} catch (Exception e1){
					System.out.println(e1);
				}

				//read concert
				try{
					FileWriter fw = new FileWriter(concertFile);
					PrintWriter pw = new PrintWriter(fw);
					for(int i=0;i<concertList.size();i++){
						pw.println(concertList.get(i).writeFile());
						System.out.println("concertW");
					}
					pw.close();
					fw.close();
				} catch (Exception e1){
					System.out.println(e1);
				}

				System.exit(EXIT_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				bodyL.setIcon(b6);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bodyL.setIcon(body);
			}	
		});
		exitB.setBounds(677, 496, 100, 100);
		contentPane.add(exitB);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/image/BGMain2.png")));
		lblNewLabel.setBounds(0, 0, 850, 650);
		contentPane.add(lblNewLabel);

		concertB.setBorder(BorderFactory.createEmptyBorder());
		concertB.setContentAreaFilled(false);

		ManagememtB.setBorder(BorderFactory.createEmptyBorder());
		ManagememtB.setContentAreaFilled(false);

		memberB.setBorder(BorderFactory.createEmptyBorder());
		memberB.setContentAreaFilled(false);

		searchB.setBorder(BorderFactory.createEmptyBorder());
		searchB.setContentAreaFilled(false);

		btnShop.setBorder(BorderFactory.createEmptyBorder());
		btnShop.setContentAreaFilled(false);

		exitB.setBorder(BorderFactory.createEmptyBorder());
		exitB.setContentAreaFilled(false);



	}


	public void database(){
		ClassLoader loader = this.getClass().getClassLoader();

		ConcertInfo con1Info = new ConcertInfo("1","conGG1","con01",new Date(2,1,2557),new Time(18,0,0),"chaingmai");
		Concert con1 = new Concert("image/C1.jpg",new int[]{10,10,10,10,10},con1Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con2Info = new ConcertInfo("2","conGG2","con02",new Date(3,1,2557),new Time(18,0,0),"chaingrai");
		Concert con2 = new Concert("image/C2.jpg",new int[]{10,10,10,10,10},con2Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con3Info = new ConcertInfo("3","conGG3","con03",new Date(4,1,2557),new Time(18,0,0),"chaingkan");
		Concert con3 = new Concert("image/C3.jpg",new int[]{10,10,10,10,10},con3Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con4Info = new ConcertInfo("4","conGG4","con04",new Date(5,1,2557),new Time(18,0,0),"chaingmai");
		Concert con4 = new Concert("image/C4.jpg",new int[]{10,10,10,10,10},con4Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con5Info = new ConcertInfo("5","conGG5","con05",new Date(6,1,2557),new Time(18,0,0),"chaingmai");
		Concert con5 = new Concert("image/C5.jpg",new int[]{10,10,10,10,10},con5Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con6Info = new ConcertInfo("6","conGG6","con06",new Date(7,1,2557),new Time(18,0,0),"chaingmai");
		Concert con6 = new Concert("image/C6.jpg",new int[]{10,10,10,10,10},con6Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con7Info = new ConcertInfo("7","conGG7","con07",new Date(8,1,2557),new Time(18,0,0),"chaingmai");
		Concert con7 = new Concert("image/C7.jpg",new int[]{10,10,10,10,10},con7Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con8Info = new ConcertInfo("8","conGG8","con08",new Date(9,1,2557),new Time(18,0,0),"chaingmai");
		Concert con8 = new Concert("image/C8.jpg",new int[]{10,10,10,10,10},con8Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con9Info = new ConcertInfo("9","conGG9","con09",new Date(10,1,2557),new Time(18,0,0),"chaingmai");
		Concert con9 = new Concert("image/C9.jpg",new int[]{10,10,10,10,10},con9Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con10Info = new ConcertInfo("10","conGG10","con10",new Date(12,1,2557),new Time(18,0,0),"chaingmai");
		Concert con10 = new Concert("image/C10.jpg",new int[]{10,10,10,10,10},con10Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con11Info = new ConcertInfo("11","conGG11","con11",new Date(13,1,2557),new Time(18,0,0),"chaingmai");
		Concert con11 = new Concert("image/C11.jpg",new int[]{10,10,10,10,10},con11Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con12Info = new ConcertInfo("12","conGG12","con12",new Date(14,1,2557),new Time(18,0,0),"chaingmai");
		Concert con12 = new Concert("image/C12.jpg",new int[]{10,10,10,10,10},con12Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con13Info = new ConcertInfo("13","conGG13","con13",new Date(15,1,2557),new Time(18,0,0),"chaingmai");
		Concert con13 = new Concert("image/C13.jpg",new int[]{10,10,10,10,10},con13Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con14Info = new ConcertInfo("14","conGG14","con14",new Date(16,1,2557),new Time(18,0,0),"chaingmai");
		Concert con14 = new Concert("image/C14.jpg",new int[]{10,10,10,10,10},con14Info,50000,new double[]{500,1000,2000,2500,5000});

		ConcertInfo con15Info = new ConcertInfo("15","conGG15","con15",new Date(17,1,2557),new Time(18,0,0),"chaingmai");
		Concert con15 = new Concert("image/C15.jpg",new int[]{10,10,10,10,10},con15Info,50000,new double[]{500,1000,2000,2500,5000});

		/*Customer cus01 = new Customer("1001","peaky","otomo","Male","0922506745",0);
		Customer cus02 = new Customer("1002","momo","mingming","Female","0877011501",0);
		Customer cus03 = new Customer("1003","tan","baka","Male","0833006307",1);
		Customer cus04 = new Customer("1004","pipe","popo","Female","0879897207",2);*/

		concertList.add(con1);
		concertList.add(con2);
		concertList.add(con3);
		concertList.add(con4);
		concertList.add(con5);
		concertList.add(con6);
		concertList.add(con7);
		concertList.add(con8);
		concertList.add(con9);
		concertList.add(con10);
		concertList.add(con11);
		concertList.add(con12);
		concertList.add(con13);
		concertList.add(con14);
		concertList.add(con15);

	}

	public void fileReader(){
		try{
			if(customerFile.exists()){
				Scanner input = new Scanner(customerFile);
				while(input.hasNext()){
					String ID = input.next();
					String firstname = input.next();
					String lastname = input.next();
					String gender = input.next();
					String tel = input.next();
					int memberClass = input.nextInt();
					Customer addCustomer = new Customer(ID,firstname,lastname,gender,tel,memberClass);
					memberList.add(addCustomer);
					System.out.println("CustomerR");
				}

				input.close();
			}
		} 
		catch (Exception e){
			System.out.println(e);
		}


		try{
			if(ticketFile.exists()){
				Scanner input = new Scanner(ticketFile);
				while(input.hasNext()){
					String ID = input.next();
					String firstname = input.next();
					String lastname = input.next();
					String gender = input.next();
					String tel = input.next();
					int memberClass = input.nextInt();
					Customer addCustomer = new Customer(ID,firstname,lastname,gender,tel,memberClass,"temp");

					String conID = input.next();
					String conName = input.next();
					String conInfo = input.next();
					int day = input.nextInt();
					int month = input.nextInt();
					int year = input.nextInt();
					Date addDate = new Date(day,month,year);	
					int hour = input.nextInt();
					int minute = input.nextInt();
					int second = input.nextInt();
					Time addTime = new Time(hour,minute,second);	
					String venue = input.next();
					ConcertInfo addConcert= new ConcertInfo(conID,conName,conInfo,addDate,addTime,venue);

					String zone = input.next();
					Double price = input.nextDouble();
					String status = input.next();

					Ticket addTicket = new Ticket(addCustomer,addConcert,zone,price);
					addTicket.setPaymentStatus(status);
					ticketList.add(addTicket);

					System.out.println("TicketR");
				}

				input.close();
			}


		} 
		catch (Exception e){
			System.out.println(e);
		}

		try{
			if(billFile.exists()){
				Scanner input = new Scanner(billFile);
				while(input.hasNext()){
					String ID = input.next();
					String firstname = input.next();
					String lastname = input.next();
					String gender = input.next();
					String tel = input.next();
					int memberClass = input.nextInt();
					Customer addCustomer = new Customer(ID,firstname,lastname,gender,tel,memberClass,"temp");

					String conID = input.next();
					String conName = input.next();
					String conInfo = input.next();
					int day = input.nextInt();
					int month = input.nextInt();
					int year = input.nextInt();
					Date addDate = new Date(day,month,year);	
					int hour = input.nextInt();
					int minute = input.nextInt();
					int second = input.nextInt();
					Time addTime = new Time(hour,minute,second);	
					String venue = input.next();
					ConcertInfo addConcertInfo= new ConcertInfo(conID,conName,conInfo,addDate,addTime,venue);

					String zone = input.next();
					Double price = input.nextDouble();

					Ticket addTicket = new Ticket(addCustomer,addConcertInfo,zone,price);
					Bill addBill = new Bill(addCustomer,addTicket);
					billList.add(addBill);
					//1 conGG1 con01 2 1 2557 18 0 0 chaingmai A 500.0

					System.out.println("TicketR");
				}

				input.close();
			}


		} 
		catch (Exception e){
			System.out.println(e);
		}


		try{
			if(concertFile.exists()){
				Scanner input = new Scanner(customerFile);
				while(input.hasNext()){
					String url = input.next();
					int numSeats1 = input.nextInt();
					int numSeats2 = input.nextInt();
					int numSeats3 = input.nextInt();
					int numSeats4 = input.nextInt();
					int numSeats5 = input.nextInt();
					int[] numSeats = {numSeats1,numSeats2,numSeats3,numSeats4,numSeats5};

					String conID = input.next();
					String conName = input.next();
					String conInfo = input.next();
					int day = input.nextInt();
					int month = input.nextInt();
					int year = input.nextInt();
					Date addDate = new Date(day,month,year);	
					int hour = input.nextInt();
					int minute = input.nextInt();
					int second = input.nextInt();
					Time addTime = new Time(hour,minute,second);	
					String venue = input.next();
					ConcertInfo addConcertInfo= new ConcertInfo(conID,conName,conInfo,addDate,addTime,venue);

					double expense = input.nextDouble();
					double zonePrice1 = input.nextDouble();
					double zonePrice2 = input.nextDouble();
					double zonePrice3 = input.nextDouble();
					double zonePrice4 = input.nextDouble();
					double zonePrice5 = input.nextDouble();
					double[] zonePrice = {zonePrice1,zonePrice2,zonePrice3,zonePrice4,zonePrice5};

					int numBookings1 = input.nextInt();
					int numBookings2 = input.nextInt();
					int numBookings3 = input.nextInt();
					int numBookings4 = input.nextInt();
					int numBookings5 = input.nextInt();
					int[]  numBookings = { numBookings1, numBookings2, numBookings3, numBookings4, numBookings5};

					Concert addConcert = new Concert(url,numSeats,addConcertInfo,expense,zonePrice);
					addConcert.setNumbooking(numBookings);

					//image/C1.jpg 10 10 10 10 10  1 conGG1 con01 2 1 2557 18 0 0 chaingmai 50000.000000 500.0 1000.0 2000.0 2500.0 5000.0  0 0 0 0 0 
					//	public Concert (String url,int[] numSeats,ConcertInfo concertInfo,double concertExpense,double[] zonePrice) {
				}

				input.close();
			}
		} 
		catch (Exception e){
			System.out.println(e);
		}

	}



	public void TicketandBillYutter(){
		for(int i=0;i<ticketList.size();i++){
			for(int j=0;j<memberList.size();j++){
				Ticket ticket = ticketList.get(i);
				Customer member = memberList.get(j);
				System.out.println(ticket.getCustomer().toString());
				System.out.println(member.toString());
				
				if(ticket.getCustomer().equals(member)){
					member.addTicket(ticket);
					System.out.println("YutTicket Successful");
				}
				else{
					System.out.println("YutTicket unSuccessful");
				}
			}
		}

		for(int i=0;i<billList.size();i++){
			for(int j=0;j<memberList.size();j++){
				Bill bill = billList.get(i);
				Customer member = memberList.get(j);
				if(bill.getPayer().equals(member)){
					member.addBill(bill);
					System.out.println("YutBill Successful");
				}
				else{
					System.out.println("YutBill unSuccessful");
				}
			}
		}
		
		for(int i=0;i<concertList.size();i++){
			for(int j=0;j<memberList.size();j++){
				Concert concert = concertList.get(i);
				Customer member = memberList.get(j);
				if(member.isInconcert(concert)){
					concert.getCustomerList().add(member);
					System.out.println("YutCustomer Successful");
				}
				else{
					System.out.println("YutCustomer unSuccessful");
				}
			}
		}
	}


}
