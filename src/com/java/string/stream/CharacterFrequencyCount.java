package com.java.string.stream;

import java.util.Map;
import java.util.stream.Collectors;

public class CharacterFrequencyCount {

	public static void main(String[] args) {
		String name="Accenture";
		
		Map<Character,Long> result=name.chars().mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(c ->c,Collectors.counting()));
		
		System.out.println(result);
		
		result.forEach((k,v) -> System.out.println(k+" :: "+v));

	}

}
