package com.animal.fenine;

import com.animal.Animal;
import com.animal.Pet;

public class Cat extends Animal implements Pet {

	public Cat(String Catname) {
		super(Catname);
		System.out.println("Inside Constructor of cat");
	}

	public void eat() {
		System.out.println("Cat is eating");
	}

	
	@Override
	public void play() {
		System.out.println("Cat is playing");
	}

	@Override
	public void beFriendly() {
		System.out.println("");	
	}
}
