package com.java8.test;

import java.util.Comparator;

//  Checkif twostrings/numbers are palindrome
//abcabcbb -->abc
public class Palindrome {
	public static void main(String[] args) {
		 String word ="12321";
		 
		 Boolean isPalindrome = word.equalsIgnoreCase(
				    new StringBuilder(word).reverse().toString()
				 );
		 System.out.println(isPalindrome);
	}

}
