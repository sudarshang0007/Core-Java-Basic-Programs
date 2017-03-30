
import static java.lang.Math.*;
public class JDK5 {

	
	public static void main(String... args) {
		JDK5 demo=new JDK5();
		demo.testVarLength();
		demo.testAutoBoxing();
		demo.testStaticImort();
	}


	private void testStaticImort() {
	System.out.println(PI);
		
	}


	private void testAutoBoxing() {
		Integer i=new Integer(45);
		i++;
		int x=i.intValue();
		x++;
		Integer x1=new Integer(45);
		i++;
		
	}

	private void testVarLength() {
		Method1(5);
		Method1(5,10);
	}
	
	public void Method1(int... n){
		for (int i : n) {
			System.out.println(i);
		}
	}

}
