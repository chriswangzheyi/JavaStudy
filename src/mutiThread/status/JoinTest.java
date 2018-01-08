package mutiThread.status;

/**
 * thinking in java p597
 */


public class JoinTest{		
		
	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper();
		sleeper.start();
		
		Joiner joiner = new Joiner(sleeper);
		joiner.start();								
	}
}
	

class Sleeper extends Thread
{
	public void run() {
		
		System.out.println("Sleeper线程id=" + Thread.currentThread().getId() +  "   start run");
		try {
			for(int i=0;i<50;i++){
				Thread.sleep(100);
				System.out.println("线程" + Thread.currentThread().getId() + "---i=" + i);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}					
		System.out.println("Sleeper线程id=" + Thread.currentThread().getId()+  "   end");		
    }
}


class Joiner extends Thread
{
	private Sleeper m_sleeper;
	public Joiner(Sleeper sleeper ){
		m_sleeper = sleeper;
	}
	public void run() {		
		System.out.println("线程id=" + Thread.currentThread().getId()+  "  start run");
		
		try {						
			for(int i=0;i<50;i++){
				Thread.sleep(100);				
				System.out.println("线程" + Thread.currentThread().getId() + "---k=" + i);				
				if(i==5){
					System.out.println("sleeper准备加入到当前线程线程" + Thread.currentThread().getId());
					m_sleeper.join();			//sleeper加入到当前线程,当前线程被阻塞，等待sleeper运行结束后这个线程才继续运行
				}					
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}			
		System.out.println("线程id=" + Thread.currentThread().getId()+  "  end");		
    }
}

