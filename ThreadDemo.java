
public class ThreadDemo extends Thread{

	public static void main(String[] args) {
		
		ThreadDemo demo=new ThreadDemo();
		Thread t=new Thread(demo);
		t.setName("Thread...");
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		demo.method1();
		
	}
	
	public void run()
	{
		method2();
	}

	public void method2() {
		System.out.println("Inside Method2 ");
		String name=Thread.currentThread().getName();
		
		for (int i = 1000; i < 2000; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test"+i+"Name :"+name);
			
		}
	}

	public void method1() {
		System.out.println("Inside Method 1");
		String name=Thread.currentThread().getName();
		for (int i = 0; i <1000; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("First: "+i+"Name :"+name);	
		}
	}

}
