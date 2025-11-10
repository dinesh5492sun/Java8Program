package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConcatenate {

	public static void main(String[] args) {

		List<String> listofstring=Arrays.asList("dinesh","mani","dinzy","suryakala","manan","sairam","suresh");
		String concatvalue=listofstring.stream().reduce("",(a,b)-> a+"::".concat(b)).toString();
		System.out.println(concatvalue);
		String concatdata=listofstring.stream().collect(Collectors.joining("::"));
		System.out.println(concatdata);
	}

}
