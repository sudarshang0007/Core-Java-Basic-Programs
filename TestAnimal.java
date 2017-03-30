import com.animal.Animal;
import com.animal.Pet;
import com.animal.canine.Dog;
import com.animal.fenine.Cat;


public class TestAnimal {

	public static void main(String[] args) {

		Animal[] anarr=new Animal[4];
		anarr[0]=new Dog("toomy");
		anarr[1]=new Cat("Lucy");
		anarr[2]=new Dog("Rambo");
		anarr[3]=new Cat("Whity");

		for (int i = 0; i < anarr.length; i++) {
			anarr[i].eat();
		}

		Pet[] p=new Pet[4];
		p[0]=new Cat("");
		p[1]=new Dog("");
		p[2]=new Cat("");
		p[3]=new Dog("");

		for (int i = 0; i < p.length; i++) {
			p[i].play();
			
			if(p[i] instanceof Dog)
			{
				Dog d=(Dog)p[i];
				d.bark();
			}
		}
	}

}
