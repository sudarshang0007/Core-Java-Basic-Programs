import com.psl.emp.Employee;


public class TestEmplyee {

	public static void main(String[] args) {
		Employee e1=new Employee(1,"sud","agvanm");
		Employee e2=new Employee(2,"est","aikwad");
		
		System.out.println(e1.getId()+" "+e1.getFname()+" "+e1.getLname());
		System.out.println(e2.getId()+" "+e2.getFname()+" "+e2.getLname());
		
		System.out.println("The no of Employees: "+ Employee.getCounter());
	}

}
