package com.psl.emp;


public class Employee {
	
	private static int counter;
	int id;
	private String fname;
	private String lname;
	private Address add;
	

	public Employee() {
		this(1,"ABC", "XYZ");
		System.out.println("Inside");
		counter++;
	}

	public Employee(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		counter++;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}
	
	public static int getCounter() {
		return counter;
	}

}
