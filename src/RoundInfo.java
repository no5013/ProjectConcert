
public class RoundInfo {
	private String info;
	private Date conDate;
	private Time conTime;
	
	public RoundInfo(String info,Date conDate,Time conTime) {
		this.info = info;
		this.conDate = conDate;
		this.conTime = conTime;
	}
	public String getInfo() {
		return info;
	}
	public Date getConDate () {
		return conDate;
	}
	public Time getConTime() {
		return conTime;
	}

	public String toString() {
		return String.format("%s: %s - %s", this.info,this.conDate,this.conTime);
	}
	public String writeFile(){
		return info+" "+conDate.writeFile()+" "+conTime.writeFile();
	}
}
