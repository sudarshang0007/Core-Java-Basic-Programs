class Education implements Runnable{

	@Override
	public void run() {
		System.out.println("Education strated...");
		System.out.println("Education is going on");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Education is completed..");
	}

}

class Marriage implements Runnable{

	private Thread t;

	public Marriage(Thread t) {
		this.t=t;
	}
	public void run() {
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Marriage started");
		System.out.println("Married");

	}
}


/// Main 
public class JoiningDemo {

	public static void main(String[] args) {

		Education e=new Education();
		Thread t1=new Thread(e);

		Marriage m=new Marriage(t1);
		Thread t2=new Thread(m);
		
		t1.start();
		t2.start();
		


	}

}
