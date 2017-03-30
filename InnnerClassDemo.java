class OuterClass{
	static private int x=5;


	public void outerMethod() {
		
		System.out.println(x);
		final int a=10;
		
	
		class MethodLocalInnnerClass{
			private int z=9;
			
			public void innermostclass() {
				System.out.println(a);
			}
		}
		
		MethodLocalInnnerClass class1=new MethodLocalInnnerClass();
		class1.innermostclass();
	}


	static class InnerClass{
		private int y=7;
		public void InnnerMethod() {
			System.out.println(x);

		}
	}
}


public class InnnerClassDemo {

	public static void main(String[] args) {
		OuterClass out=new OuterClass();
		//OuterClass.InnerClass in=out.new InnerClass();

		OuterClass.InnerClass in=new OuterClass.InnerClass();
		in.InnnerMethod();
	}

}
