package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Find the first string that starts with letter "M". 
//List<String> names = List.of("Alice", "Bob", "Charlie", "David"); 
public class StartsWithLetter {
 public static void main(String[] args) {
	List<String> names = Arrays.asList("Alice", "Bob","Charle", "Manasvi", "Manikanta","manu");
	Optional<String> startNames = names.stream().filter( name -> name.startsWith("M"))
			.findFirst();
	System.out.println(startNames);
	
}
}
