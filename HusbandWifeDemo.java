
class Account{
	int balance=100;

	public void withdraw(int amt){
		balance=balance-amt;
	}
}




public class HusbandWifeDemo implements Runnable {

	public Account acct;
	public Object obj=new Object();

	public HusbandWifeDemo(Account acct) {
		this.acct=acct;
	}

	public void run() {

		makeWithdrawl(75);

		if(acct.balance<0){
			System.out.println("A BIG problem ocurred");
		}
	}

	public /*synchronized*/ void  makeWithdrawl(int amount) {  // here "this" reference to current object
		String name=Thread.currentThread().getName();
		System.out.println(name+" has entered in withdrawl");
		System.out.println(name+" is going to check balance");

		synchronized(this){
			if(amount<acct.balance){
				System.out.println(name+" has entered in withdrawl");
				System.out.println(name+" is going to check balance");

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				acct.withdraw(amount);
				System.out.println(name+" is actually to withdrawl balance");
			}
			else{
				System.out.println("not sufficient balance");
			}
		}
	}
	public static void main(String[] args) {

		Account acct=new Account();
		HusbandWifeDemo demo=new HusbandWifeDemo(acct);

		Thread t1=new Thread(demo);
		t1.setName("Husband");

		Thread t2=new Thread(demo);
		t2.setName("Wife");

		t2.start();
		t1.start();
	}

}
