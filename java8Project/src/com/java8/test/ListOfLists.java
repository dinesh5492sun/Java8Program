package com.java8.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//Convert a list of lists into a single list.
public class ListOfLists {
 public static void main(String[] args) {
	 List<List<String>> nestedList = Arrays.asList( 
			 Arrays.asList("a", "b"), 
			 Arrays.asList("c", "d"), 
			 Arrays.asList("e", "f"));
	 
	 List<String> singleList =  nestedList.stream().flatMap(Collection :: stream) 
			                      .collect(Collectors.toList());
	 System.out.println(singleList);
}
}
