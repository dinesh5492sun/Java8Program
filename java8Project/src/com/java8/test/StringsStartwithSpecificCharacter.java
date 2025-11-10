package com.java8.test;

import java.util.Arrays;
import java.util.List;

public class StringsStartwithSpecificCharacter {

	public static void main(String[] args) {
		List<String> listofnumber=Arrays.asList("dinesh","mani","dinzy","suryakala","manan","sairam","suresh");
		System.out.println(listofnumber);
		long data=listofnumber.stream().map(a-> a.toUpperCase()).filter(a-> a.startsWith("D")).count();
		System.out.println(data);
		//Arrays.asList("dinesh","mani");
		//long data=listofnumber.stream().map(String::toUpperCase).filter(a-> a.startsWith("D")).count();
		listofnumber.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}
