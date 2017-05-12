
public class ConcertInfo extends RoundInfo{
	private String venue;
	private String conID;
	private String conName;
	
	public ConcertInfo(String conID,String conName,String info,Date conDate,Time conTime,String venue){
		super(info,conDate,conTime);
		this.conID = conID;
		this.conName = conName;
		this.venue = venue;
	}
	
	public boolean equals(ConcertInfo key){
		boolean check = false;
		if(this.conID.equals(key.getConcertID())&&this.getInfo().equals(key.getInfo())&&this.getVenue().equals(key.getVenue()))
			check = true;
		return check;
	}
	public String getConName(){
		return conName;
	}
	
	public String getConcertID(){
		return conID;
	}
	
	public String getVenue(){
		return venue;
	}
	
	public String toString(){
		return String.format("%s, %s",super.toString(),venue);
	}
	
	public String writeFile() {
		return String.format("%s %s %s %s",conID,conName,super.writeFile(),venue);
	}
	
}
