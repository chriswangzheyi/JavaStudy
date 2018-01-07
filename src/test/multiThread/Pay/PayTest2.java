package test.multiThread.Pay;


public class PayTest2 {

	/**
	 * @param args
	 */
	public static Integer totalMoney = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new MyThread("father").start();
         new MyThread("mother").start();
         new MyThread("son").start();
	}

}
class MyThread extends Thread{
	String person;
	public MyThread(String person){
		this.person = person;
	}
	public void run(){
		if(person.equals("father")){
			while(true){
				try{
					Thread.sleep(100); 
				 }catch(Exception e){
					 
				 }
			synchronized(PayTest2.totalMoney){
			System.out.println("+++++++爸爸充费前金额是："+PayTest2.totalMoney);
			PayTest2.totalMoney += 10;
			System.out.println("+++++++爸爸充费后金额是："+PayTest2.totalMoney);
			}
			}
		}else if(person.equals("mother")){
			while(true){
				try{
					Thread.sleep(100); 
				 }catch(Exception e){
					 
				 }
				synchronized(PayTest2.totalMoney){
			System.out.println("*******妈妈消费前金额是："+PayTest2.totalMoney);
			if((PayTest2.totalMoney-7)<0){
				System.out.println("余额不足，请充值！");
			}else{
				PayTest2.totalMoney -= 7;
				System.out.println("*******妈妈消费后金额是："+PayTest2.totalMoney);
			}
			}
			}
			
		}else if(person.equals("son")){
			while(true){
				try{
					Thread.sleep(100); 
				 }catch(Exception e){
					 
				 }
				synchronized(PayTest2.totalMoney){
			System.out.println("#######儿子消费前金额是："+PayTest2.totalMoney);
			if((PayTest2.totalMoney-5)<0){
				System.out.println("余额不足，请充值！");
			}else{
				PayTest2.totalMoney -= 5;
				System.out.println("#######儿子消费后金额是："+PayTest2.totalMoney);
			}
		}
		}
		}
	}
}
