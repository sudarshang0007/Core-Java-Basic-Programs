abstract class Animal
{
	public void eat() {
		System.out.println("Animal is eating");
	}
}

class Dog extends Animal
{
	public void eat() {
		System.out.println("dog is eating");
	}
	
}

interface Pet
{
	void play();
}

public class AnonymsInner {

	public static void main(String[] args) {
		AnonymsInner demo=new AnonymsInner();
		
		// Annonymous inner class
		
		demo.method1(new Animal(){
			public void eat() {
				System.out.println("xyz is eating");
			}
		});
		
		demo.method2(new Pet() {

			public void play() {
				System.out.println("Interface Pet");
			}
		});
		//demo.method1(new Dog());
	}
	
	public void method1(Animal a) {
		a.eat();
	}
	
	public void method2(Pet p) {
		
	}
}
