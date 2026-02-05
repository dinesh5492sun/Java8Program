package com.java.string.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestWordFromString {

	public static void main(String[] args) {
		String input = "Java streams make programming very powerful";

		String longestWord = Arrays.stream(input.split(" "))
		        .max(Comparator.comparingInt(String::length))
		        .orElse("");

		System.out.println(longestWord);

		//second solution
		
		int maxLen = Arrays.stream(input.split(" "))
		        .mapToInt(String::length)
		        .max()
		        .orElse(0);

		List<String> longestWords = Arrays.stream(input.split(" "))
		        .filter(w -> w.length() == maxLen)
		        .collect(Collectors.toList());

		System.out.println(longestWords);


	}

}
