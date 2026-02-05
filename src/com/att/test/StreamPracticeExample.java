package com.att.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamPracticeExample {

	public static void main(String[] args) {
		//https://www.youtube.com/watch?v=PMhrMDHFFW4
		//https://www.youtube.com/watch?v=b4Atxh-a97M
		//https://www.youtube.com/watch?v=aaokKp87Hoc
		List<String> names=Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		names.forEach(s-> System.out.println(s.length()));
		Map<String, Long> wordCount = names.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(wordCount);
        
        Map<String, Integer> wordCount1 = names.stream().sorted()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum));  // merge function for duplicates
        
       List<String> listOfwords = Arrays.asList("Dinesh","Äccenture","Streams","Attra","Dinesh","Attra");
       Map<String, Integer> wordCount5=listOfwords.stream().collect(Collectors.toMap(words -> words, words -> 1, Integer :: sum));
       
       System.out.println("wordCount5 :: "+wordCount5);
        System.out.println(wordCount1);
        
        List<Employee> empList= Arrays.asList(
        		new Employee("Dinesh", 32, 2000.32, "IT"),
        		new Employee("Dinesh1", 31, 2001.32, "IT"),
        		new Employee("Dinesh2", 30, 2000.32, "IT"),
        		new Employee("Dinesh3", 28, 1900.32, "IT"),
        		new Employee("Dinesh4", 55, 2002.32, "IT"),
        		new Employee("Dinesh5", 45, 2008.32, "IT")
        		);
        
        empList.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
	}
}
 