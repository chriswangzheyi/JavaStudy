package entity.multiThread;

import java.util.Date;

public class Ticket {
	
	private String seatNo;
	private Date startTime;
	private String startLocation;
	
	
	public Ticket(String seatNo, Date startTime, String startLocation) {
		super();
		this.seatNo = seatNo;
		this.startTime = startTime;
		this.startLocation = startLocation;
	}
	
	
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	
	
	

}
