package multiThread.example.Ticket;

/*售票系统，没有锁*/

public class TicketBooking implements Runnable {

	private int tickets = 100;	
	
	@Override
	public void run() {
		while (tickets>0) {
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
