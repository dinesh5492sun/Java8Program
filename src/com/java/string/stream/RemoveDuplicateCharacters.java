package com.java.string.stream;

import java.util.stream.Collectors;

public class RemoveDuplicateCharacters {

	/*
	 Input : "programming"
	 Output: "progamin"
	 */
	public static void main(String[] args) {
		String input = "programming";

		String output = input.chars()
		        .mapToObj(c -> (char) c)
		        .distinct()
		        .map(String::valueOf)
		        .collect(Collectors.joining());
		
		System.out.println(output);


	}

}
/*

String output = input.chars()
.mapToObj(c -> (char) c)
.collect(Collectors.toCollection(LinkedHashSet::new))
.stream()
.map(String::valueOf)
.collect(Collectors.joining());

System.out.println(output);

*/