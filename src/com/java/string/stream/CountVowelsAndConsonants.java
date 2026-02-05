package com.java.string.stream;

public class CountVowelsAndConsonants {

	public static void main(String[] args) {
		String input = "Programming".toLowerCase();

		long vowels = input.chars()
		        .filter(c -> "aeiou".indexOf(c) != -1)
		        .count();

		long consonants = input.chars()
		        .filter(c -> c >= 'a' && c <= 'z')
		        .filter(c -> "aeiou".indexOf(c) == -1)
		        .count();

		System.out.println("Vowels = " + vowels);
		System.out.println("Consonants = " + consonants);
	}

}
