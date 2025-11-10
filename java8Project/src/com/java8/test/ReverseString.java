package com.java8.test;

import java.util.Arrays;
import java.util.stream.Collectors;

// Reverse a string by preserving word position
public class ReverseString {
public static void main(String[] args) {
	String sentence = "Java is a powerful Language";
	
	String revSent = Arrays.stream(sentence.split("\\s+"))
			               .map(word -> new StringBuilder(word).reverse().toString())
			               .collect(Collectors.joining(" "));
	System.out.println(revSent);
}
}
