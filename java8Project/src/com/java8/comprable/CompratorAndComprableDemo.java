package com.java8.comprable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
	int age;
	String name;
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "student [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Student that) {
		if(this.age > that.age)
			return -1;
		else
			return 1;
	}	
	
}
public class CompratorAndComprableDemo {

	
	public static void main(String[] args) {
		
		Comparator<Student> com=new Comparator<Student>()
				{
					public int compare(Student i,Student j){
						if(i.age > j.age)
							return 1;
						else
							return -1;
					}
				};
				
		List<Student> studentDetails=new ArrayList<Student>();
		studentDetails.add(new Student(21,"dinesh"));
		studentDetails.add(new Student(23,"Santosh"));
		studentDetails.add(new Student(14,"Gowri"));
		studentDetails.add(new Student(10,"prathyusha"));
		studentDetails.add(new Student(56,"simhachalam"));
		//study Collections methods
		Collections.sort(studentDetails,com);
		System.out.println(studentDetails);
		Collections.sort(studentDetails);
		System.out.println(studentDetails);
		
		
		
	}
}
