
public class MystackTest {

	public static void main(String args[]) {
		
		MyStack<String> myStack=new MyStack<String>();
		
		myStack.push("suda");
		System.out.println(myStack.pop());
		myStack.push("sudd");
		myStack.push("zxcvx");
		myStack.push("cxvxcv");
		myStack.push("xcv");
		System.out.println(myStack.pop());
		
		
		MyStack<Integer> my=new MyStack<Integer>();
		my.push(5);
		System.out.println(my.pop());
		
	}
}
