package com.animal.canine;

import com.animal.Animal;
import com.animal.Pet;

public class Dog extends Animal  implements Pet  {

	public Dog(String dogname) {
		super(dogname);
		System.out.println(name);
	}
	public void run() {
		System.out.println("Running dog");
	}
	public void eat() {

		System.out.println("Dog is eating");
	}
	@Override
	public void play() {
		System.out.println("Dog is playing");
	}

	@Override
	public void beFriendly() {
		System.out.println("");	
	}
	
	public void bark() {
		System.out.println("Dog is barking");
	}
}
