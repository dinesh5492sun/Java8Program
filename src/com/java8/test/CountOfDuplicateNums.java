package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Remove duplicate integers from a list..
public class CountOfDuplicateNums {
public static void main(String[] args) {
	List<Integer> nums = Arrays.asList(1,2,3,2,3,4,5,3);
	
	List<Integer> filterNums = nums.stream(). distinct().collect(Collectors.toList());
	
	System.out.println(filterNums);
	
}
}
