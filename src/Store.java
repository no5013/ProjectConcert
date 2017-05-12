import java.util.ArrayList;


public class Store {
private double revenue,expense;

public Store(){
	revenue=0;
	expense=0;
}

public Store(double revenue,double expense){
	this.revenue = revenue;
	this.expense = expense;
}

public double getRevenue(){
	return revenue;
}

public double getExpense(){
	return expense;
}

public int booking(Concert concert,Customer customer,String selectZone,ArrayList<Ticket> ticketList){
	return concert.booking(customer,selectZone,ticketList);
}

public int cancel(Concert concert,Customer customer){
	return concert.cancel(customer);
}

public int receivePayment(Concert concert,Customer customer,ArrayList<Bill> billList){
	int check = -1;
	int customerIndex = concert.searchCustomer(customer);
	System.out.print(customerIndex);
    int ticketIndex = customer.searchTicket(concert.getConcertInfo());
	System.out.print(ticketIndex);
	
    if(customerIndex!=-1&&ticketIndex!=-1){
    Ticket ticket = customer.getTicketList().get(ticketIndex);
    double price = ticket.getPrice();
    revenue+=price;
    ticket.setPaymentStatus("Paid");
    Bill bill = new Bill(customer,ticket);
    customer.addBill(bill);
    billList.add(bill);
    
    check = 1 ;
    }
    
    return check;
    
}

public void clearConcert(Concert concert){
	expense+=concert.getConcertExpense();
	concert.clear();
}

public void buySouvenir(Customer customer,Souvenir souvenir){
	customer.getSouvenirList().add(souvenir);
	revenue += souvenir.getPrice();
	expense += souvenir.getExpense();
}

public double getProfit(){
	return revenue - expense;
}

public int searchCustomerByName(ArrayList<Customer> memberList,String name,String lastname){
	int search = -1;
	for(int i=0;i<memberList.size();i++){
		String memName = memberList.get(i).getName();
		String memLastname = memberList.get(i).getLastname();
		
		if(memName.equals(name)&&memLastname.equals(lastname))
			search = i;
	}
	return search;
}

public int searchCustomerByCustomerID(ArrayList<Customer> memberList,String customerID){
	int search = -1;
	for(int i=0;i<memberList.size();i++){
		if(memberList.get(i).getCustomerID().equals(customerID))
			search = i;
	}
	return search;
}

public int searchConcertByIndex(ArrayList<Concert> concertList,int index){
	int search = -1;
	if(concertList.size()!=0&&index<concertList.size())
		search = index;
	return search;
}

public int searchConcertByConcertID(ArrayList<Concert> concertList,String concertID ){
	int search = -1;
	for(int i=0;i<concertList.size();i++){
		if(concertList.get(i).getConcertInfo().getConcertID().equals(concertID)){
			search = i;
		}
	}
	
	return search;
}

public int searchBillByNumberOfBill(ArrayList<Bill> billList,int numBill){
	int search = -1;
	for(int i=0;i<billList.size();i++){
		if(billList.get(i).getNumberOfBills()==numBill){
			search = i;
		}
	}
	return search;
}


public String getMemberListToString(ArrayList<Customer> memberList){
	String toString = "";
	for(int i=0; i<memberList.size(); i++){
		toString+=memberList.get(i).toString()+"\n";
	}
	return toString;
}

public String toString(){
	String toString = String.format("Revenue: %.2f, Expense: %.2f", revenue,expense);
	return toString;
}
}
