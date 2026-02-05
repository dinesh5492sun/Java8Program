package com.java8.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of sentences, count the frequency of each word (case-insensitive)
public class CountFrequency {
 public static void main(String[] args) {
	List<String> sentences = Arrays.asList("java is Fun", "Streams are fun", "Java is powerful");
	
	Map<String, Long> wordFreq = sentences.stream()
										.flatMap(sentence  ->  Arrays.stream(sentence.toLowerCase().split("\\s+")))
										.collect(Collectors.groupingBy(word -> word,Collectors.counting()));
	System.out.println(wordFreq);
}
}
