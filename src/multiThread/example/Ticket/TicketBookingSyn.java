package multiThread.example.Ticket;

public class TicketBookingSyn implements Runnable {

	
private Integer tickets = 100;	
	
	@Override
	public void run() {
		while (tickets>0) {
			
			//单位时间内只有一个线程可以进入synchronized代码块
			synchronized (tickets) {
				
				System.out.println("窗口"+Thread.currentThread().getId()+"准备出票");
				tickets =tickets -1;
				System.out.println("窗口"+Thread.currentThread().getId()+"出票成功，剩余"+tickets+"张票");
				
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
		
	}
	
}
