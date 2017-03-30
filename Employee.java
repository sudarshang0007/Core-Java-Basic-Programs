import com.psl.emp.Address;


public class Employee {

	private int id;
	private String fname;
	private String lname;
	private String role;
	private Address addr;
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @return the addr
	 */
	public Address getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public static void main(String[] args) {
		

	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname
				+ ", role=" + role + ", addr=" + addr + "]";
	}

	

	
}
