package com.java.string.stream;

import java.util.stream.Collectors;

public class SortCharacterAlphabetically {

	public static void main(String[] args) {
		String input = "programming";

		String sorted = input.chars()
		        .sorted()
		        .mapToObj(c -> String.valueOf((char) c))
		        .collect(Collectors.joining());

		System.out.println(sorted);


	}

}
