package com.java8.test;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {
   public static void main(String[] args) {
	   List<Integer> nums = Arrays.asList(2,4,6,10,23);
	   
	   boolean isEven=nums.stream().allMatch(num -> num %2 ==0);
	   
	   System.out.println(isEven);
   }
}
