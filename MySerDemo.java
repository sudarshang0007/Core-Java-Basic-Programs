import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class mySer implements Serializable
{
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	private int a;
	private int b;
	
	public mySer(int a,int b) {
		this.a=a;
		this.b=b;
	}
	
	public String toString() {
		return this.a+" "+this.b;
	}
}

public class MySerDemo {


	public static void main(String[] args) {
		MySerDemo msd=new MySerDemo();
		msd.doSerialize();
		msd.doDeserialization();
	}
	
	// Serialize Demo
	public void doSerialize() {
		
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		ObjectOutputStream oos=null;
		
		mySer ms=new mySer(21, 12);
		
		
		try {
			fos=new FileOutputStream("c:\\person.ser");
			bos=new BufferedOutputStream(fos);
		    oos=new ObjectOutputStream(bos);
		    oos.writeObject(ms);
		    ms.setA(10);
		    ms.setB(20);
		    oos.writeObject(ms);
		    System.out.println("Write Successful");
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		
	}

	// Deserialize Demo
	public void doDeserialization() {

		mySer ms;

		FileInputStream fos=null;
		BufferedInputStream bos=null;
		ObjectInputStream oos=null;

		try{
			fos=new FileInputStream("c:\\person.ser");
			bos=new BufferedInputStream(fos);
			oos=new ObjectInputStream(bos);
			while (oos!=null) {
				ms=(mySer)oos.readObject();
				System.out.println(ms);
			}
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
