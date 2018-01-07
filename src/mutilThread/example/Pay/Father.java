package mutilThread.example.Pay;



public class Father {
	private Family family;
	private String name;
	
	public Father(Family family,String name){
		this.family = family;
		this.name = name;
		this.family.setFather(this);
	}
	
	/**
	 * Familiy的getAccount和setAccount方法应保证在一个锁定代码块中，不能允许其它线程插入
	 * @param money
	 */
	public void earnMoney(Double money){
		//锁family对象，因为family对象包括了father,wife,son三个子对象
		synchronized(family){
			double account = family.getAccount();
			System.out.println("father充值前账户金额:" + account);
			try {				
				account += money;
				family.setAccount(account);
				System.out.println("****father挣了" + money + "元，充值后账户金额:" + account + "***************");
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		
	}

}
