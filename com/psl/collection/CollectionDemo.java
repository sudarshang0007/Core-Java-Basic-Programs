package com.psl.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class ScienceStudent extends Student{
	
}

class Student implements Comparator<Student>{
	public int rollno;
	public String name;

	public Student(int rollno,String name) {
		this.rollno=rollno;
		this.name=name;
	}

	public Student() {

	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}

	public int hashCode() {
			System.out.println("Inside hashcode Method");
		return this.rollno;
	}

	public boolean equals(Object obj) {
		System.out.println("Inside equals");
		if( obj instanceof Student){
			Student s=(Student) obj;
			if(s.rollno==this.rollno)
				return true;
			return false;
		}
		return false;
	}

	//	public int compareTo(Object o) {
	//		System.out.println("Inside Comparator");
	//		int i = 0;
	//		if (o instanceof Student) {
	//			Student s=(Student)o;		
	//			i= s.name.compareTo(this.name);
	//		}
	//		if(i==0)
	//			return 0;
	//		return 1;
	//	}

	@Override
	public int compare(Student s1, Student s2) {
	
			if(s1.rollno<s2.rollno)
				return -1;
			else if (s1.rollno>s2.rollno) 
				return 1;
		return 0;
	}

}

public class CollectionDemo {
	
	public static void main(String[] args) {
		
		CollectionDemo demo=new CollectionDemo();
		//	demo.testSets();
			demo.testLists();
		//  demo.testMaps();
		//  demo.testQueue();
	}

	/*
	 * test Queue Data Structure
	 */
	private void testQueue() {
		Queue que=new PriorityQueue(10, new Student());
		
		Student s1=new Student(9, "Sudarshan");
		Student s2=new Student(11, "Sud");
		Student s3=new Student(12, "Dr. Sud");
		Student s4=new Student(8, "Hagvane");
		
		que.offer(s1);
		que.offer(s2);
		que.offer(s3);
		que.offer(s4);
		
		System.out.println(que.size());
		System.out.println(que.peek());
		System.out.println(que.size());
		System.out.println(que.poll());
		System.out.println(que.size());
	}

	private void testMaps() {

		Map map=new TreeMap(new Comparator() {
			
			public int compare(Object ob1, Object ob2) {
				Student s1=(Student)ob1;
				Student s2=(Student)ob2;
				return 1;
				// develope
			}
		});

		Student s1=new Student(9, "Sudarshan");
		Student s2=new Student(11, "Sud");
		Student s3=new Student(10, "Sudarshan");
		Student s4=new Student(10, "Sudarshan");

		if(map.containsKey(s2)){
			Object ob=map.get(s2);
		}
		
		map.put(s1,"sudarshan");
		map.put(s2,"Hagavane");
		map.put(s3,"lkajfkl");
		map.put(s4,"lkajfkl");

		Set set=map.keySet();
		Iterator iter=set.iterator();
		while (iter.hasNext()) {
			Object in = iter.next();
			System.out.println(map.get(in));
		}
	}

	public void testSets() {
		Student s1=new Student(9, "Sudarshan");
		Student s2=new Student(11, "Sud");
		Student s3=new Student(10, "Sudarshan");

		Set set=new TreeSet(new Student());

		set.add(s1);
		set.add(s2);
		set.add(s3);

		Iterator iter=set.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());

		}

	}
	
	/* List interface Example */
	public void testLists() {
		
		Student s1=new Student(9, "Sudarshan");
		Student s2=new Student(11, "Sud");
		Student s3=new Student(10, "Sudarshan");
		
		List<Student> list=new Vector<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);

//		for(int i=0;i<list.size();i++)
//			System.out.println(" "+list.get(i));
//
//		Iterator iter=list.iterator();
//		while (iter.hasNext()) {
//			System.out.println(" "+iter.next());
//		}
//
//		for(Student ob: list){
//			System.out.println(ob);
//		}

		PrintCollection(list);
	}

	public void PrintCollection(List<? extends Student> list) {
//		for(Student s:list){
//			System.out.println(s);
//		}
	}
}
