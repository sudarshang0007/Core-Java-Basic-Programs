import java.io.FileInputStream;
import java.io.FileNotFoundException;

class BankAccount{
	public int balance=100;


	public void withdraw(int amt) throws InsufficientfEundException
	{
		assert amt<balance:"balance not Sufficient" ; //use of assert

		if(amt>balance){
			InsufficientfEundException ife=new InsufficientfEundException("Not Enough Balance");
			throw ife;
		}
		else{
			balance=balance-amt;
		}
	}

}

public class ExceptionDemo {

	public static void main(String[] args) {

		ExceptionDemo demo=new ExceptionDemo();

		System.out.println("Inside main");
		System.out.println("Before calling method 1");
		int n =2;

		demo.method1(n);
		try{
			demo.method2();
		}catch(FileNotFoundException e){
			System.out.println("File  not found");
		}

		System.out.println("I am back in main");
		System.out.println("Exitning from main");

		demo.method3();
	}

	public void method1(int n) {
		System.out.println("Inside method1");
		try{
			int x=10/n;
		}
		catch(ArithmeticException e){
			System.out.println("Devide by Zero Error occured..");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Inside ");
		}finally{
			System.out.println("Finally Always Executes");
		}
		System.out.println("Exitintg from method 1...");


	}

	public void method2()throws FileNotFoundException {
		System.out.println("Inside method 2");
		FileInputStream fis=new FileInputStream("C:\\ABC.txt");
	}

	public void method3() {
		BankAccount acct=new BankAccount();

		try {
			acct.withdraw(400);
		} catch (InsufficientfEundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}


