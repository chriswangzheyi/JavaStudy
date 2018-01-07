package mutilThread.example.Pay;


public class Family {	
	//家庭成员
	private Father father;
	private Son son;
	private Wife wife;
	private Double account;						//家庭财务账户 
	
	
	public Father getFather() {
		return father;
	}
	public void setFather(Father father) {
		this.father = father;
	}
	public Son getSon() {
		return son;
	}
	public void setSon(Son son) {
		this.son = son;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	public Double getAccount() {
		return account;
	}
	
	//更新账户方法，该方法不需要加锁。
	public void setAccount(Double account) {
		try {
			Thread.sleep(500);					//延时2秒与0.5秒，则效果可能不同
			this.account = account;
		} catch (Exception e) {
			e.printStackTrace();
		}					
	}
	
	//初始账户
	public Family(){
		this.account = 10d;						//初始账户10元
	}	

}
