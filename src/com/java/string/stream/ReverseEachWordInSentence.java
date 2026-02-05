package com.java.string.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordInSentence {

	public static void main(String[] args) {

		String input = "Java is very easy";

        StringBuilder result = new StringBuilder();

        for (String word : input.split(" ")) {
            result.append(new StringBuilder(word).reverse())
                  .append(" ");
        }

        System.out.println(result.toString().trim());
        
        //java 8
        
        String output = Arrays.stream(input.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));

        System.out.println(output);

}
}

/*
//Reverse Word Order
//output :: easy very is Java 
 List<String> list = Arrays.stream(input.split(" "))
        .collect(Collectors.toList());

Collections.reverse(list);

String output = list.stream()
        .collect(Collectors.joining(" "));

System.out.println(output);


//Reverse Full Sentence
//ysae yrev si avaJ

String output = input.chars()
        .mapToObj(c -> String.valueOf((char) c))
        .reduce("", (a, b) -> b + a);

System.out.println(output);

//Reverse Alternate Words
//avaJ is yrev easy

AtomicInteger index = new AtomicInteger(0);

String output = Arrays.stream(input.split(" "))
        .map(word -> index.getAndIncrement() % 2 == 0
                ? new StringBuilder(word).reverse().toString()
                : word)
        .collect(Collectors.joining(" "));

System.out.println(output);

    
 */
