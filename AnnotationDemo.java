import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test{
	String info();
}

public class AnnotationDemo {
	
	public static void main(String args[]) {
		AnnotationProcessr ansp=new AnnotationProcessr();
		ansp.parse(Annotated.class);
	}

}


class Annotated{
	
	@Test(info="disabled")
	public void foo(String msg) {
		System.out.println("Foo is called : "+msg);
	}
	@Test(info="enable")
	public void zoo(String msg) {
		System.out.println("Zoo is called :"+msg);
	}
}

class AnnotationProcessr{
	
	public void parse(Class clas) {
		Method[] method= clas.getMethods();
		
		for (Method method2 : method) {
			if (method2.isAnnotationPresent(Test.class)) {
			Test test=method2.getAnnotation(Test.class);
				String info=test.info();
				
				if ("enable".equals(info)) {
					try {
						method2.invoke(Annotated.class.newInstance(), " Hey gapp bass.");
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		//	System.out.println(method2);
		}
	}
}