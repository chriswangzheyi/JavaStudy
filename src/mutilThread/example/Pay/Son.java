package mutilThread.example.Pay;



public class Son {
	private Family family;
	
	public Son(Family family){
		this.family = family;
		this.family.setSon(this);
	}
	
	/**
	 * Familiy的getAccount和setAccount方法应保证在一个锁定代码块中，不能允许其它线程插入
	 * 玩游戏消费
	 */
	public void payGame(Double money){
		//锁family对象，因为family对象包括了father,wife,son三个子对象
		synchronized(family){
			double account = family.getAccount();
			System.out.println("son消费前账户金额:" + account);
			if(account < money){
				System.out.println("账户余额不足，暂停son消费。");
			}else{
				try {				
					account -= money;
					family.setAccount(account);
					System.out.println("+++son花了" + money + "元，消费后账户金额:" + this.family.getAccount() + "+++++");
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}
			
		}
		
	}

}

