package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group words by their length. 
//List<String> words = List.of("one", "two", "three", "four", "five"); 
public class GroupWordsByLength {
 public static void main(String[] args) {
	List<String> words = Arrays.asList("one", "two", "three", "four", "five");
	
	Map<Integer,List<String>> group = words.stream().collect(Collectors.groupingBy(String::length));
	
	System.out.println(group);
}
}
