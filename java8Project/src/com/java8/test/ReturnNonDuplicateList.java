package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Remove numbers that appear more than once (duplicates) and return only the numbers that occur exactly once.
public class ReturnNonDuplicateList {
 public static void main(String[] args) {
	 List<Integer> nums = Arrays.asList(1,2,3,2,3,4,5,3);
	 
     Map<Integer, Long> countnums = nums.stream().collect(Collectors.groupingBy(n ->n , Collectors.counting()));
     
     List<Integer> uniqueNums = nums.stream().filter( n -> countnums.get(n)==1).collect(Collectors.toList());
     
     System.out.println(uniqueNums);
}
}
