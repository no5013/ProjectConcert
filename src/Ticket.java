
public class Ticket {
	private Customer customer;
	private ConcertInfo concertInfo;
	private double price;
	private String paymentStatus;
	private String zone;
	
	public Ticket(Customer customer,ConcertInfo concertInfo,String zone,double price){
		this.customer = customer;
		this.concertInfo = concertInfo;
		this.zone = zone;
		this.price = price;
		this.setPaymentStatus("Charged");
		this.applyDiscount();
	}
	public Customer getCustomer(){
		return customer;
	}
	public ConcertInfo getConcertInfo() {
		return concertInfo;
	}
	public double getPrice(){
		return price;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public String getZone() {
		return zone;
	}
	public void applyDiscount() {
		this.price -= price*customer.getDiscountRate();
	}
	public void setPaymentStatus(String newStatus) {
		this.paymentStatus = newStatus;
	}
	public boolean equals(Ticket key) {
		boolean isEquals = false;
		if(customer.equals(key.getCustomer())&&concertInfo.equals(key.getConcertInfo())) {
			isEquals = true;
		}
		return isEquals;
	}
	public String toString() {
		return String.format("%s, %.2f, %s", concertInfo.toString(), price, paymentStatus);
	}
	
	public String writeFile() {
		return customer.writeFile()+" "+concertInfo.writeFile()+" "+zone+" "+price+" "+paymentStatus;
	}
}
