package com.java.string.stream;

import java.util.List;
import java.util.stream.Collectors;

public class AllNonRepeatedCharacter {

	public static void main(String[] args) {
		String name="Dineshs";

		List<Character> result=name.chars().mapToObj(c ->(char)c)
		.collect(Collectors.groupingBy(c->c,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(c-> c.getValue()==1)
		.map(e -> e.getKey())
		.collect(Collectors.toList());
		
		System.out.println(result);
		
		result.forEach(e -> System.out.println(e));
		
		
		
	}

}
