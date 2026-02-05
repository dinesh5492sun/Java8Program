package com.java8.test;

import java.util.Arrays;
import java.util.List;

public class AverageFloatingNumbers {

	public static void main(String[] args) {

		List<Double> floatnums=Arrays.asList(1.1,1.2,2.2,1.2,3.1,1.4);
		double avg=floatnums.stream().mapToDouble(a->a.doubleValue()).average().getAsDouble();
		System.out.println(avg);
	}

}
