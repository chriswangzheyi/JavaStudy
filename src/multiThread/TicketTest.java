package multiThread;

public class TicketTest {
	
	/*A方法中，三个线程没有共享一个方法，所以各买各的票。*/	
	public static void bookMethodA() {

		new Thread(new TicketBooking()).start();
		new Thread(new TicketBooking()).start();
		new Thread(new TicketBooking()).start();

	}
	
	/*B方法中，三个线程共享一个run对象。有时间差，可能会出错*/	
	public static void bookMethodB() {
		TicketBooking tb = new TicketBooking();
		new Thread(tb).start();
		new Thread(tb).start();
		new Thread(tb).start();
	}
	
	
	/*C方法中，三个线程共享一个run对象。加锁*/	
	public static void bookMethodC() {
		TicketBookingSyn tb = new TicketBookingSyn();
		new Thread(tb).start();
		new Thread(tb).start();
		new Thread(tb).start();
	}
	
	public static void main(String[] args) {
		//bookMethodA();
		//bookMethodB();
		bookMethodC();
	}
	

}
