package test.multiThread.Pay;

import mutilThread.example.Pay.Family;
import mutilThread.example.Pay.Father;
import mutilThread.example.Pay.Son;
import mutilThread.example.Pay.Wife;

public class PayTest {

	public static void testFamilyAccount() {
		// 初始化
		Family family = new Family();
		Father father = new Father(family, "张三");
		Wife wife = new Wife(family);
		Son son = new Son(family);

		// 启动三个线程
		new Thread(new SonThread(son)).start();
		new Thread(new WifeThread(wife)).start();
		new Thread(new FatherThread(father)).start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayTest.testFamilyAccount();
	}

}

//father 线程
class FatherThread implements Runnable {
	private Father father;

	public FatherThread(Father father) {
		this.father = father;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				father.earnMoney(10d); // 父亲每次存10元
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}

//wife 线程
class WifeThread implements Runnable {
	private Wife wife;

	public WifeThread(Wife wife) {
		this.wife = wife;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				wife.payShopping(7d); // 妻子每次花7元
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}

//son 线程
class SonThread implements Runnable {
	private Son son;

	public SonThread(Son son) {
		this.son = son;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				son.payGame(6d); // 儿子每次花5元
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}
