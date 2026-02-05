package com.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//Find the maximum number in a list. 
//List<Integer> numbers = List.of(10, 20, 5, 80, 30);
public class MaxNumber {
 public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(10,20,30,40,50);
	Optional<Integer> maxNum1 = numbers.stream().max(Integer:: compare);
	Optional<Integer> maxNum = numbers.stream().sorted(Comparator.reverseOrder()).findFirst();
	System.out.println(maxNum);
	System.out.println(maxNum1);
}
}
