package com.java.string.stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {

		String name="swiss";
		
	Character result=name.chars().mapToObj(c -> (char) c)
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, 
				Collectors.counting()))
		.entrySet()
		.stream()
		.filter(c -> c.getValue()>1)
		.map(x -> x.getKey())
		.findFirst()
		.orElse(null);
		
		System.out.println("First non-repated charater "+ result);
	}

}
