package com.java8.test;

import java.util.Arrays;
import java.util.List;

//Count how many strings start with "A".
//List<String> names = List.of("Alice", "Arnold", "Bob", "Charlie", 
//"Andrew");
public class CountStrings {
 public static void main(String[] args) {
	List<String> names = Arrays.asList("Praveena","Manikanta","Manasvi","Priyansh","Varsha");
	
    long countOfStrings = names.stream().filter(name -> name.startsWith("P")).count();
    
    System.out.println(countOfStrings);
}
}
