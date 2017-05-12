
public class Bill {
	private Customer payer;
	private Ticket ticket;
	private int billID;
	private static int numberOfBills=0;
	
	public Bill(Customer payer,Ticket ticket) {
		this.payer = payer;
		this.ticket = ticket;
		numberOfBills++;
		this.billID = this.numberOfBills;

	}
	public Customer getPayer() {
		return payer;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public int getBillID() {
		return billID;
	}
	public int getNumberOfBills() {
		return numberOfBills;
	}
	public String toString(){
		return String.format("Bill#%d: %s %s, %.2f", this.billID, payer.getName(), payer.getLastname(), ticket.getPrice());
	}
	
	public String writeFile(){
		return ticket.writeFile();
	}
}
