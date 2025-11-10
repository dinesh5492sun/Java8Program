package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElement {

	public static void main(String[] args) {
		List<Integer> listofnumber=Arrays.asList(1,2,3,5,66,7);
		listofnumber.stream().distinct().forEach(System.out::println);
//		List<Integer> listdata=listofnumber.stream().distinct().collect(Collectors.toList());
		Stream<Integer> streamList=listofnumber.stream().distinct();
		System.out.println(streamList.toString());
	}
}
