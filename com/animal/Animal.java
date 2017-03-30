package com.animal;

public abstract class Animal {

	protected String name;

	public abstract void eat();
	public abstract void play();
	// {
//		System.out.println("Animal is eating");
//	}
	public void run() {
		System.out.println("Running");
	}
	public Animal(String name) {
		super();
		System.out.println("Inside constructor Animal");
	}	
}
