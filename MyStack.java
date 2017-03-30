
public class MyStack<E> {

	private int x=0;
	private E[] data= (E[]) new Object[10];

	public void push(E obj) {
		data[x]=obj;
		x++;
	}

	public E pop() {
		x--;
		return data[x];
	}
}
