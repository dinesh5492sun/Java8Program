package com.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Sort a list of strings in descending (reverse alphabetical) order. 
//List<String> fruits = List.of("apple", "banana", "cherry", "date");
public class ReversAlphabeticalOrder {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("appple","banana","cherry","date");
		  List<String> alpFruits = fruits.stream().sorted(Comparator.reverseOrder())
				                                 .collect(Collectors.toList());
		  System.out.println(alpFruits);
	}
 
}
