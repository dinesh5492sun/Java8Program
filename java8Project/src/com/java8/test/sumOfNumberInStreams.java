package com.java8.test;

import java.util.Arrays;
import java.util.List;

public class sumOfNumberInStreams {

	public static void main(String[] args) {
		//for loop
		//reduce
		List<Integer> listofnumber=Arrays.asList(1,2,3,5,66,7);
		int sumdata=0;
		for(Integer intdata: listofnumber) {
			sumdata = sumdata+intdata;
		}
		System.out.println(sumdata);
		
		int i=listofnumber.get(2).intValue();
		int sum=listofnumber.stream().mapToInt(Integer::intValue).sum();
		int reducesum=listofnumber.stream().reduce(0,(a,b) -> a+b);
		System.out.println(sum);
		System.out.println(reducesum);
		
	}
}
