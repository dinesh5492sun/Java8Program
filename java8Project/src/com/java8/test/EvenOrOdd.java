package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, return a list of strings "even" or "odd" depending on 
//whether the number is even or odd.
public class EvenOrOdd {
public static void main(String[] args) {
	List<Integer> nums = Arrays.asList(1,2,3,4,5);
	List<String> strings = nums.stream().map(num -> num%2==0 ? "Even" : "Odd")
			.collect(Collectors.toList());
	System.out.println(strings);
}
}
