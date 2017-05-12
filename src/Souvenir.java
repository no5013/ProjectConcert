import javax.swing.ImageIcon;


public class Souvenir {
	private String souvenirName;
	private double price;
	private double expense;
	private ImageIcon icon;

	public Souvenir(String souvenirName,double price,double expense,ImageIcon icon){
		this.souvenirName = souvenirName;
		this.price = price;
		this.expense = expense;
	}

	public String getSouvenirName(){
		return souvenirName;
	}

	public double getPrice(){
		return price;
	}

	public double getExpense(){
		return expense;
	}

	public ImageIcon getImageIcon(){
		return icon;
	}

	

}
