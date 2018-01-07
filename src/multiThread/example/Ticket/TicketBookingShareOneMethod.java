package multiThread.example.Ticket;

import java.util.LinkedList;

import entity.multiThread.Ticket;

public class TicketBookingShareOneMethod extends Thread {
	
	LinkedList<Ticket> allTicket;
	
	public TicketBookingShareOneMethod(LinkedList<Ticket> allTicket) {
		
		this.allTicket = allTicket;
		
	}
	

	@Override
	public void run() {
		while (allTicket.size()>0) {

			//单位时间内只有一个线程可以进入synchronized代码块
			synchronized (allTicket) {
				if (allTicket.size()>0) {
					
					System.out.println("窗口"+Thread.currentThread().getId()+"准备出票");
					allTicket.remove();
					System.out.println("窗口"+Thread.currentThread().getId()+"出票成功，剩余"+allTicket.size()+"张票");
					
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				
				
				
			}
		
		}
		
		
	}

}
