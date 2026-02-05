package com.java.string.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramsCheck {

	/*
	 listen  -> silent   yes
	 race    -> care     yes
	 hello   -> world    no
	 */

	/*
			 | Case                 | Solution                      |
		| -------------------- | ----------------------------- |
		| Case-insensitive     | convert to `toLowerCase()`    |
		| Ignore spaces        | `replaceAll("\\s","")`        |
		| Ignore special chars | `replaceAll("[^a-zA-Z]", "")` |

	 */
	public static void main(String[] args) {
		String s1="listen";
		String s2="silent";

		System.out.println("meothd :: "+AnagramsCheck.isAnagram("race","care"));
	}

	static boolean isAnagram(String s1, String s2) {
	    if (s1.length() != s2.length()) return false;

	    Map<Character, Long> map1 = s1.chars()
	            .mapToObj(c -> (char) c)
	            .collect(Collectors.groupingBy(
	                    c -> c, Collectors.counting()));
	    System.out.println(map1);
	    Map<Character, Long> map2 = s2.chars()
	            .mapToObj(c -> (char) c)
	            .collect(Collectors.groupingBy(
	                    c -> c, Collectors.counting()));
	    System.out.println(map2);
	    return map1.equals(map2);
	}

	 static boolean checkAnagram(String s1, String s2) {
	        if (s1.length() != s2.length()) return false;

	        char[] a1 = s1.toLowerCase().toCharArray();
	        char[] a2 = s2.toLowerCase().toCharArray();

	        Arrays.sort(a1);
	        Arrays.sort(a2);

	        return Arrays.equals(a1, a2);
	    }
}
