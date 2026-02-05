package com.java8.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of strings, group them by anagram sets.
public class AnagramSets {
 public static void main(String[] args) {
	List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", 
			"tar", "art");
	Map<String, List<String>> sets = words.stream().
			                          collect(Collectors.groupingBy(
			                        		  word -> {
			                        			  char[] chars = word.toCharArray();
			                        			  Arrays.sort(chars);
			                        			  return new String(chars);
			                        		  }));
	sets.values().forEach(System.out:: println);
} 
}
