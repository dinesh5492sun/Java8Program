package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOfEvenNumber {

	public static void main(String[] args) {
		List<Integer> listofnumber=Arrays.asList(1,2,3,5,66,7,11,12,14,15);
		listofnumber.stream().filter(a-> a%2==0).forEach(System.out::println);
		List<Integer> evenNumber=listofnumber.stream().filter(a-> a%2==1).collect(Collectors.toList());
		System.out.println(evenNumber);
		System.out.println(listofnumber.stream().filter(a-> a%2==1).count());
	}
}
