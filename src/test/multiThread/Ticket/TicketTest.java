package test.multiThread.Ticket;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import entity.multiThread.Ticket;
import multiThread.example.Ticket.TicketBooking;
import multiThread.example.Ticket.TicketBookingShareOneMethod;
import multiThread.example.Ticket.TicketBookingSyn;

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
	
	
	/*D方法中，三个线程共享一个run对象。加锁*/	
	public static void bookMethodD() {
		LinkedList<Ticket> allTicket = new LinkedList<Ticket>();
		
		//模拟有100张票
		for (int i = 0; i < 100; i++) {
			Ticket ticket = new Ticket(String.valueOf(i), new Date(), "CQ");
			allTicket.add(ticket);
		}		
		
		//三个线程，共享一个方法
		Thread t1 = new TicketBookingShareOneMethod(allTicket);
		Thread t2 = new TicketBookingShareOneMethod(allTicket);
		Thread t3 = new TicketBookingShareOneMethod(allTicket);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	
	public static void main(String[] args) {
		//bookMethodA();
		//bookMethodB();
		//bookMethodC();
		bookMethodD();
	}
	

}
