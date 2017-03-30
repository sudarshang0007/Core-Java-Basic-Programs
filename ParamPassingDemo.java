
public class ParamPassingDemo {


	public void Modify(int n) {
		System.out.println("Inside Modify: ");
		n=10;
		System.out.println("Value of n in modify :"+n);
	}

	public void Modify(Number num) {
		System.out.println("Inside Modify: ");
		num.n=10;
		System.out.println("Value of n in modify :"+num.n);
	}

	public void Modify(String num) {
		System.out.println("Inside Modify: ");
		num="10";
		System.out.println("Value of n in modify :"+num);
	}
	public static void main(String[] args) {
		ParamPassingDemo demo=new ParamPassingDemo();
		System.out.println();

		int n=5;
		System.out.println("Value of n before calling modifier: "+n);	
		demo.Modify(n);
		System.out.println("Value on n after calling modify: "+n);

		//part II
		Number num=new Number();
		num.n=5;
		System.out.println("Value of num.n before calling modifier: "+num.n);	
		demo.Modify(num);
		System.out.println("Value on num.n after calling modify: "+num.n);

		//partIII
		String str="5";
		System.out.println("Value of str before calling modifier: "+str);	
		demo.Modify(str);
		System.out.println("Value on str after calling modify: "+str);
	}

}

class Number
{
	int n;
}