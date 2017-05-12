
public class Time {
	private int hour;
	private int minute;
	private int second;


	public Time(int hour, int minute, int second) {
		this.hour = hour%24;
		this.minute = minute%60;
		this.second = second%60;
	}
	public Time (int duration) {
		this.hour = duration/3600;
		this.minute = (duration%3600) / 60;
		this.second = duration%60;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getDuration() {
		return (this.hour*3600)+(this.minute*60)+this.second;
	}
	public Time add(Time other) {
		int newhour = this.hour+other.hour;
		int newMinute = this.minute+other.minute;
		int newSec = this.second+other.second;
		Time newTime = new Time(newhour,newMinute,newSec) ;
		return newTime;
	}
	public int subtract(Time other) {
		int subTime ;
		if(other.getDuration()>this.getDuration()) {
			subTime = (24*3600)-(other.getDuration() -this.getDuration());
		}
		else {
			subTime = this.getDuration() - other.getDuration();
		}
		return subTime;
	}
	public boolean equals(Time other) {
		boolean checkTime = false;
		if(this.getDuration()==other.getDuration()) {
			checkTime = true;
		}
		return checkTime;
	}
	public String toString() {
		String timeS = String.format("%02d:%02d", hour,minute);
		return timeS;
	}
	
	public String writeFile() {
		return hour+" "+minute+" "+second;
	}
}