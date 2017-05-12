
import java.util.ArrayList;
public class Customer extends Person{
	private String customerID;
	private String tel;
	private int memberClass;
	private ArrayList<Ticket> ticketList;
	private ArrayList<Bill> billList;
	private ArrayList<Souvenir> souvenirList;
	private static int numberOfCustomers=0;
	private double discountRate;
	
	public Customer (String ID, String name, String lastname, String gender, String tel, int memberClass){
		super(ID,name,lastname,gender);
		this.tel = tel;
		this.memberClass = memberClass;
		customerID = "PS:"+ ++numberOfCustomers;
		ticketList = new ArrayList<Ticket>();
		billList = new ArrayList<Bill>();
		souvenirList = new ArrayList<Souvenir>();
		setDiscountRate(memberClass);
	}
	
	public Customer (String ID, String name, String lastname, String gender, String tel, int memberClass,String temp){
		super(ID,name,lastname,gender);
		this.tel = tel;
		this.memberClass = memberClass;
		customerID = "PS:"+ numberOfCustomers;
		ticketList = new ArrayList<Ticket>();
		billList = new ArrayList<Bill>();
		souvenirList = new ArrayList<Souvenir>();
		setDiscountRate(memberClass);
	}
	
	public void setDiscountRate(int memberClass){
		switch(memberClass){
		case 0:
			discountRate=0;
			break;
		case 1:
			discountRate=0.1;
			break;
		case 2:
			discountRate=0.2;
			break;
		}
	}
	
	public void addTicket(Ticket ticket){
		ticketList.add(ticket);
	}
	
	public void addBill(Bill bill){
		billList.add(bill);
	}
	
	public int searchTicket(ConcertInfo key){
		int temp = -1;
		if(ticketList.size()!=0){
			for(int i=0; i<ticketList.size(); i++){
				if(ticketList.get(i).getConcertInfo().equals(key)){
					temp = i;
				}
			}
			return temp;
		}
		else{
			return temp;
		}
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public String getTel() {
		return tel;
	}
	
	public int getMemberClass() {
		return memberClass;
	}
	
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}
	
	public ArrayList<Bill> getBillList() {
		return billList;
	}
	
	public ArrayList<Souvenir> getSouvenirList(){
		return souvenirList;
	}
	
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public boolean equals(Customer customer2){
		if(this.getId().equals(customer2.getId())&&this.getLastname().equals(customer2.getLastname())&&this.getGender().equals(customer2.getGender())&&this.tel.equals(customer2.getTel())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getTicketListToString(){
		String list = "";
		for(int i=0; i<ticketList.size(); i++){
			list+=ticketList.get(i).toString()+"\n";
		}
		return list;
	}
	
	public String getBillListToString(){
		String list = "";
		for(int i=0; i<billList.size(); i++){
			list+=billList.get(i).toString()+"\n";
		}
		return list;
	}

	public String getSovenirListToString(){
		String list = "";
		for(int i=0; i<souvenirList.size(); i++){
			list+=souvenirList.get(i).toString()+"\n";
		}
		return list;
	}
	
	public String toString(){
		return String.format("%s: %s ,%s , %d" ,customerID,super.toString(),tel,memberClass);
	}
	
	
	//Peak
	public String writeFile(){
		return String.format("%s %s %d" ,super.writeFile(),tel,memberClass);
	}
	
	public boolean isInconcert(Concert concert){
		boolean check = false;
		for(int i=0;i<ticketList.size();i++){
			if(ticketList.get(i).getConcertInfo().equals(concert.getConcertInfo())){
				check = true;
			}
		}
		return check;
	}
}
