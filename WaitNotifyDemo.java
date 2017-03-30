class JointAccount
{
	public int balance=0;

	public void withdraw(int amount) {
		balance=balance-amount;
	}

	public void deposite(int amount) {
		balance=balance+amount;
	}
}


//Deposite Money....

class Depositor implements Runnable {

	public JointAccount acct;

	public Depositor(JointAccount acct) {
		this.acct=acct;
	}
	public void run() {

		synchronized (acct) {
			acct.deposite(1000);
			acct.notifyAll();
		}
		
		}
		

}


class Withdrawer implements Runnable{

	public JointAccount acct;

	public Withdrawer(JointAccount acct) {
		this.acct=acct;
	}
	public void run() {

		synchronized (acct) {
			
			try {
				acct.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acct.withdraw(100);
		}

		if(acct.balance<1000){
			System.out.println("BIG PROBLEM..!");
		}
	}

}



public class WaitNotifyDemo {


	public static void main(String[] args) {

		JointAccount acct=new JointAccount();
		Withdrawer withdrawer=new Withdrawer(acct);
		Depositor depositor=new Depositor(acct);


		Thread t1=new Thread(withdrawer);
		t1.setName("Withdrawer");	//t1 created

		Thread t2=new Thread(depositor);
		t2.setName("Depositor");	//t2 created

		t1.start();
		t2.start();

	}

}
