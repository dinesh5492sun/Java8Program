package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SampleProgram {
	//int , long, double,
	public static void main(String[] args) {
	
		List<Integer> numbers=Arrays.asList(1,2,3,5);	
		Stream<Integer> streamFromList=numbers.stream();
		System.out.println(streamFromList.toArray());
		//System.out.println(streamFromList.count());
		//System.out.println(streamFromList.toArray());
		
		int[]  intArray= {1,2,3,4,5};
		IntStream streamFromArray=Arrays.stream(intArray);
		System.out.println(streamFromList);
		
		double[]  doubleArray= {1.0,2.0,3.0,4.1,5.2};
		DoubleStream streamFromdoubleArray=Arrays.stream(doubleArray);
		System.out.println(streamFromdoubleArray);

		System.out.println("test");
	}

}
