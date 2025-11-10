package com.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgramSortObject {
	
	public static void main(String[] args) {
		List<Person> people=Arrays.asList(new Person(21,"dinesh"),
										  new Person(22,"manikanta"),
										  new Person(12,"manan"),
										  new Person(12,"suryakala"),
										  new Person(19,"prasanth"));
		//people.stream().sorted()
		Collections.sort(people,Comparator.comparing(Person::getAge));
		System.out.println(people);
		
		people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).forEach(System.out::println);
		
		people.stream().sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName)).forEach(System.out::println);
		
	}
}

