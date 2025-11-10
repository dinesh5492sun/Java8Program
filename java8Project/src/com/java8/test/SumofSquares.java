package com.java8.test;

import java.util.Arrays;
import java.util.List;

//Find the sum of squares of numbers in a list. 

public class SumofSquares {
 public static void main(String[] args) {
	 List<Integer> numbers = Arrays.asList(1, 2, 3, 4); 
	 
	 Integer result = numbers.stream()
			                .map(x -> x*x)
			                .reduce(0, Integer:: sum);
	 System.out.println(result);
}
}
