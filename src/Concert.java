import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Concert {
	private int[] numSeats;
	private ConcertInfo concertInfo;
	private double concertExpense;
	private ArrayList<Customer> CustomerList;
	private int[] numBookings;
	private double[] zonePrice;
	private String url;

	public Concert (String url,int[] numSeats,ConcertInfo concertInfo,double concertExpense,double[] zonePrice) {
		CustomerList = new ArrayList<Customer>();
		numBookings = new int[5];
		this.url = url;
		this.numSeats = numSeats;
		this.concertInfo = concertInfo;
		this.concertExpense = concertExpense;
		this.zonePrice = zonePrice;
	}
	public int[] getNumSeats () {
		return numSeats;
	}
	public ConcertInfo getConcertInfo() {
		return concertInfo;
	}
	public double getConcertExpense () {
		return concertExpense;
	}
	public ArrayList<Customer> getCustomerList() {
		return CustomerList;
	}
	public int[] getNumBookings() {
		return numBookings;
	}
	public double[] getZonePrice() {
		return zonePrice;
	}
	public String getUrl(){
		return url;
	}
	public void setNumSeats(int[] numSeats) {
		this.numSeats = numSeats;
	}
	public void setConcertInfo(ConcertInfo concertInfo) {
		this.concertInfo = concertInfo;
	}
	public void setConcertExpense(double concertExpense) {
		this.concertExpense = concertExpense;
	}
	public void setCustomerList(ArrayList<Customer> CustomerList) {
		this.CustomerList = CustomerList;
	}
	public void setNumbooking(int[] numBookings) {
		this.numBookings = numBookings;
	}
	public void setTicketPrice(double[] zonePrice) {
		this.zonePrice = zonePrice;
	}
	public int booking(Customer customer,String zone,ArrayList<Ticket> ticketList) {
		int booking =-1;

		if(zone.equals("A")){
			if(this.numBookings[0]<this.numSeats[0]) {
				CustomerList.add(customer);
				this.numBookings[0]++;
				double price = zonePrice[0];
				Ticket newTicket = new Ticket(customer,concertInfo,zone,price);
				customer.addTicket(newTicket);
				ticketList.add(newTicket);
				booking = 1;
			}
		}
		else if(zone.equals("B")){
			if(this.numBookings[1]<this.numSeats[1]) {
				CustomerList.add(customer);
				this.numBookings[1]++;
				double price = zonePrice[1];
				Ticket newTicket = new Ticket(customer,concertInfo,zone,price);
				customer.addTicket(newTicket);
				ticketList.add(newTicket);
				booking = 1;
			}
		}
		else if(zone.equals("C")){
			if(this.numBookings[2]<this.numSeats[2]) {
				CustomerList.add(customer);
				this.numBookings[2]++;
				double price = zonePrice[2];
				Ticket newTicket = new Ticket(customer,concertInfo,zone,price);
				customer.addTicket(newTicket);
				ticketList.add(newTicket);
				booking = 1;
			}
		}
		else if(zone.equals("D")){
			if(this.numBookings[3]<this.numSeats[3]) {
				CustomerList.add(customer);
				this.numBookings[2]++;
				double price = zonePrice[2];
				Ticket newTicket = new Ticket(customer,concertInfo,zone,price);
				customer.addTicket(newTicket);
				ticketList.add(newTicket);
				booking = 1;
			}
		}
		else if(zone.equals("E")){
			if(this.numBookings[4]<this.numSeats[4]) {
				CustomerList.add(customer);
				this.numBookings[2]++;
				double price = zonePrice[2];
				Ticket newTicket = new Ticket(customer,concertInfo,zone,price);
				customer.addTicket(newTicket);
				ticketList.add(newTicket);
				booking = 1;
			}
		}
		return booking;
	}
	public int searchCustomer(Customer customer){
		int indexOfP = -1;
		for(int i=0;i<CustomerList.size();i++){
			if(CustomerList.get(i).equals(customer)) {
				indexOfP = i;
			}
		}
		return indexOfP;
	}
	public int cancel(Customer customer) {
		int cancel=-1;
		if(this.searchCustomer(customer)!= -1){
			if(customer.getTicketList().size()!=0&&(CustomerList.size()!=0)){
				customer.getTicketList().remove(customer.searchTicket(concertInfo));
				CustomerList.remove(this.searchCustomer(customer));
				cancel = 1;
			}
		}
		return cancel;
	}
	public void clear() {
		for(int j=0;j<CustomerList.size();j++){
			CustomerList.get(j).getTicketList().remove(CustomerList.get(j).searchTicket(concertInfo));
		}
		CustomerList = new ArrayList<Customer>();

		for(int i=0;i<numBookings.length;i++){
			numBookings[i] = 0;
		}
	}
	public String toString() {
		String temp = "";
		temp += concertInfo.toString() + "\n";
		if (numBookings[0] > 0 || numBookings[1] > 0 ||numBookings[2] > 0) {
			for ( int i = 0; i < CustomerList.size(); i++ ) {
				temp += String.format("%d, %s\n", i+1, CustomerList.get(i).toString());
			}
		} else {
			temp += "No booking\n";
		}
		return temp;
	}
	
	public String getCustomerListToString(){
		String temp = "";
		for(int i=0; i<CustomerList.size(); i++){
			temp+=CustomerList.get(i).toString()+"\n";
		}
		return temp;
	}
	
	public String writeFile(){
		String numSeatsS = "";
		for(int i=0;i<numSeats.length;i++){
			numSeatsS += numSeats[i]+" ";
		}
		
		String zonePriceS = "";
		for(int i=0;i<zonePrice.length;i++){
			zonePriceS += zonePrice[i]+" ";
		}
		
		String numBookingsS = "";
		for(int i=0;i<numBookings.length;i++){
			numBookingsS += numBookings[i]+" ";
		}
		
		
		//String url,int[] numSeats,ConcertInfo concertInfo,double concertExpense,double[] zonePrice
		
		
		return String.format("%s %s %s %f %s %s",url,numSeatsS,concertInfo.writeFile(),concertExpense,zonePriceS,numBookingsS);
	}

}
