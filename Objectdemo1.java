class student{
	public int rollno;
	public String name;

	student(int rollno,String name){
		this.rollno=rollno;
		this.name=name;	
	}
	@Override
	public String toString() {
		return "rollno:"+this.rollno+"Name: "+this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("inside Equals ");
		if(obj instanceof student)
		{
			student s2=(student)obj;
			if(this.rollno==s2.rollno)
				 return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("Inside hashcode");
		return 12;
	}
	@Override
	public void finalize() throws Throwable {
	System.out.println("Inside Finalize");
	}
	
	
}

public class Objectdemo1 {

	public void method1() {
		while (true) {
			student s1=new student(10, "sudarshan");
			student s2=new student(10, "sudarshn");
			s2=null;
			s2=null;
		}
	}
	public static void main(String[] args) throws Throwable {
		Objectdemo1 objectdemo=new Objectdemo1();
		student s1=new student(10, "sudarshan");
		student s2=new student(10, "sudarshn");
		
		Objectdemo1 objectdemo2=new Objectdemo1();
		
		System.gc();
		objectdemo2.method1();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (s1.equals(s2)) {
			System.out.println("equal");	
		} else {
			System.out.println("not equal");
		}
		
		
	}
}
