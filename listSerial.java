import java.util.ArrayList;
import java.util.List;


public class listSerial  {

	public int roll;
	public String name;
	
	public listSerial(int roll,String name) {
		this.roll=roll;
		this.name=name;
	}
	
	public static void main(String[] args) {
		List<listSerial> list=new ArrayList<listSerial>();
		
		list.add(new listSerial(1, "Sudarshan"));
		list.add(new listSerial(1, "Sudarshan"));
		list.add(new listSerial(1, "Sudarshan"));
		list.add(new listSerial(1, "Sudarshan"));
		list.add(new listSerial(1, "Sudarshan"));
		list.add(new listSerial(1, "Sudarshan"));
		
		System.out.println(list);
	}

	public List<listSerial> Serialize(List<listSerial> list){
		return list;
	}
}
