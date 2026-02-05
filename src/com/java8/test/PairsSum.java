package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//From a list, find all pairs that sum to a given number (e.g., 10)
public class PairsSum {
 public static void main(String[] args) {
	List<Integer> nums = Arrays.asList(1,2,3,7,5,8,6,4);
	
	int target =10;
    /*
	List<List<Integer>> pairs = nums.stream() 
			.flatMap(i -> nums.stream() 
			.filter(j -> i < j && i + j == target) 
			.map(j -> Arrays.asList(i, j))) 
			.collect(Collectors.toList()); 
			System.out.println(pairs);
	*/
}
}
