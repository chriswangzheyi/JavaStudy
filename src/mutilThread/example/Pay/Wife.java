package mutilThread.example.Pay;


public class Wife {
	private Family family;
	
	public Wife(Family family){
		this.family = family;
		this.family.setWife(this);
	}
	
	/**
	 * Familiy的getAccount和setAccount方法应保证在一个锁定代码块中，不能允许其它线程插入
	 * @param money
	 */
	public void payShopping(Double money){
		//锁family对象，因为family对象包括了father,wife,son三个子对象
		synchronized(family){
			double account = family.getAccount();
			System.out.println("wife消费前账户金额:" + account);
			if(account<money){
				System.out.println("账户余额不足，暂停wife消费???????");
			}else{
				try {				
					account -= money;
					family.setAccount(account);
					System.out.println("wife消费了" + money + "元，消费后账户金额:" + this.family.getAccount() + "###");
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}			
		}		
	}

}
