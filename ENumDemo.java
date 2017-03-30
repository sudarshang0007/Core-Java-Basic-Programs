import java.util.EnumSet;

interface Description{
	public String getDerscription();
}

enum DAYS implements Description {
	MONDAY(1){public int getvalue() {
		return n;
	}public String getDerscription(){
		return "This is for Monday";
	}
	},TUESDAY(2){public int getvalue() {
		return n;
	}public String getDerscription(){
		return "This is for Monday";
	}
	},SATURDAY(6){public String getDerscription(){
		return "Yahooo.! weekend";
	}
	};

	int n;
	DAYS(int x){
		n=x;
	}

	public int getvalue() {
		return n;
	}
}

public class ENumDemo {

	static DAYS dd;


	public static void main(String[] args) {

		dd=DAYS.MONDAY;
		for (DAYS d : DAYS.values()){
			System.out.println(d.getvalue());

			switch (dd.getvalue()) {
			case 1: System.out.println("monday");break;
			case 2: System.out.println("TUeday");break;
			case 3: System.out.println("saturday");break;
			default:
				break;
			}
		}
		EnumSet<DAYS> weekday=EnumSet.<DAYS>of(DAYS.MONDAY);
		System.out.println(weekday);

		EnumSet<DAYS> weekdays=weekday.<DAYS>complementOf(weekday);

		System.out.println(weekdays);


		for (Description days : weekdays) {
			System.out.println(days.getDerscription());
		}
	}

}
