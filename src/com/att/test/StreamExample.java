package com.att.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	/*
		Features of Streams :

		1)Declarative: Write concise and readable code using functional style.
		2)Lazy Evaluation: Operations are executed only when needed (terminal operation).
		3)Parallel Execution: Supports parallel streams to leverage multi-core processors.
		4)Reusable Operations: Supports chaining of operations like map(), filter(), sorted().
		5)No Storage: Streams don’t store data; they only process it.

	 */
	public static void main(String[] args) {
		/*
					Creation of Streams
			Streams Creation can be done by multiple ways:
		
		From a Collection: Create a stream directly from a List, Set or any Collection using stream()
		From an Array: Use Arrays.stream(array) to convert an array into a stream.
		Using Stream.of(): Create a stream from a fixed set of values using Stream.of().
		Infinite Stream: Generate an unbounded sequence using Stream.iterate() or Stream.generate()
		 */
        // 1. From a Collection
		List<String> list = Arrays.asList("Java", "Python", "C++");
        Stream<String> stream1 = list.stream();
     
        // 2. From an Array
        String[] arr = {"A", "B", "C"};
        Stream<String> stream2 = Arrays.stream(arr);

        // 3. Using Stream.of()
        Stream<String> stream3 = Stream.of("A", "B", "C", "D", "E");
        
        
        List<Integer> numbers = Arrays.asList(5, 10, 20, 10, 30, 40);

        numbers.stream()
               .filter(n -> n > 10)   // keep > 10
               .map(n -> n * 2)       // double them
               .distinct()            // remove duplicates
               .sorted()              // sort ascending
               .forEach(System.out::println);
        
        
        List<String> names = Arrays.asList("Amit", "Riya", "Rohan", "Amit");

        // Collect into Set (removes duplicates)
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        System.out.println(uniqueNames);

        // Count names starting with 'R'
        long count = names.stream().filter(n -> n.startsWith("R")).count();
        System.out.println("Names starting with R: " + count);

        // Reduce (concatenate names)
        String result = names.stream().reduce("", (a, b) -> a + b + " ");
        System.out.println(result);
        
        List<String> names1 = Arrays.asList("A", "B", "C", "D");

        names1.stream()
             .forEach(System.out::println); // Executes sequentially
        
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,6,7,8,9);

        numbers1.parallelStream().forEach(n -> System.out.println(n + " " + Thread.currentThread().getName()));
        
        Stream.iterate(1, n -> n + 1)
        .limit(5)
        .forEach(System.out::println);
	}
}
