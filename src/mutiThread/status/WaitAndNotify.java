package mutiThread.status;


public class WaitAndNotify {
	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		Waiter waiter = new Waiter(restaurant);
		waiter.start();
		Chef chef = new Chef(restaurant,waiter);
		chef.start();
	}
}

//餐厅
class Restaurant {
	public Order order;	
}

//订单
class Order{
	private static int i=0;
	private int m_count;
	//只能取10份食物
	public Order(){
		m_count = i++;
		if(m_count==10){
			System.out.println("没有食物了，结束!");
			System.exit(0);
		}
	}	
}

//服务员
class Waiter extends Thread{
	private Restaurant m_restaurant;
	
	public Waiter(Restaurant r){
		m_restaurant = r;		
	}
	
	public void run() {		
		while(m_restaurant.order == null){			
			synchronized(this){    //当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
				try {
					System.out.println("Waiter线程id=" + Thread.currentThread().getId()+  "  等待中");
					wait();                                     //等待通知，接到通知后才能向下运行
					m_restaurant.order = null;
					System.out.println("Waiter线程id=" + Thread.currentThread().getId()+  " 收到通知，取走订单 \n");
				} catch (Exception e) {
					// TODO: handle exception
				}			   
			}			
		}						
    }
}

class Chef extends Thread{
	private Restaurant m_restaurant; //餐厅
	private Waiter m_waiter; //服务生
	public Chef(Restaurant restaurant,Waiter waiter){ //厨师，包含餐厅和服务生
		m_restaurant = restaurant;
		m_waiter = waiter;				
	}
	public void run(){
		while(true){
			//如果订单为null,创建一个新订单
			if(m_restaurant.order == null){
				m_restaurant.order = new Order();
				System.out.println("厨师线程id=" + Thread.currentThread().getId() + "，接到新订单");
				
				synchronized(m_waiter){
					System.out.println("厨师线程id=" + Thread.currentThread().getId() + "----通知waiter取食物");
					m_waiter.notify();
				}	
				
				//下面的代码移到sychronized上面会出现死锁
				try {					
					Thread.sleep(1000);					
				} catch (Exception e) {
					// TODO: handle exception
				}				
								
				
			}
			
		}				
	}	
}



