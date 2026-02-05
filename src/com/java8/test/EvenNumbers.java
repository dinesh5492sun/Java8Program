package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
   public static void main(String[] args) {
	List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
//	List<Integer> nums1 = List.of(1,2,3,4,5,6);
	
	 List<Integer> evenNums = nums.stream()
			                      .filter( x -> x%2==0)
			                      .collect(Collectors.toList());
	 System.out.println(evenNums);
			                 
}
}
