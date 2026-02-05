package com.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class MaximumElementStream {

	public static void main(String[] args) {
		List<Integer> listofnumber=Arrays.asList(1,2,3,5,66,7);
		
		int maxvalue=listofnumber.stream().reduce(0,(a,b)-> a>b? a:b);
		System.out.println(maxvalue);
		int maxvalue1=listofnumber.stream().mapToInt(Integer::intValue).max().getAsInt();
		int maxvalue2=listofnumber.stream().max(Comparator.naturalOrder()).get();
		System.out.println(maxvalue1);
		System.out.println(maxvalue2);
	}
}
