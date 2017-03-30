import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{

	private int ssn;
	private String name;
	
	public Person(int ssn,String name) {
		this.ssn=ssn;
		this.name=name;
		System.out.println("I am in Parameterized");
	}

	public Person() {
		System.out.println("I am in Default");
	}
	
	public String toString() {
		return this.ssn+this.name;

	}
}


//Serialize main
public class SerializationDemo {

	public static void main(String[] args) {

		SerializationDemo demo=new SerializationDemo();
		demo.doSerialization();
	//	demo.doDeserialization();
	}


	public void doSerialization() {

		Person p1=new Person(10,"Sudarshan");
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		ObjectOutputStream oos=null;

		try{
			fos=new FileOutputStream("c:\\person.ser");
			bos=new BufferedOutputStream(fos);
			oos=new ObjectOutputStream(bos);
			
			oos.writeObject(p1);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				fos.close();
				bos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


	public void doDeserialization() {

		Person p1;

		FileInputStream fos=null;
		BufferedInputStream bos=null;
		ObjectInputStream oos=null;

		try{
			fos=new FileInputStream("c:\\person.ser");
			bos=new BufferedInputStream(fos);
			oos=new ObjectInputStream(bos);

			p1=(Person)oos.readObject();

			System.out.println(p1);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				fos.close();
				bos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
