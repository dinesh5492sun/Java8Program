package com.att.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class javaProgrammingQuestion {
//https://www.youtube.com/watch?v=Fy_HyvjqjsI
	public static void main(String[] args) {

		List<Integer> listOfNumber=Arrays.asList(1,4,12,65,12,11,2,9,3,43,76,21,126);
		//Find the maximun number in given list
		System.out.println("1. Find the Maximum number in the given List of integer");
		int maxValue=listOfNumber.stream().mapToInt(Integer::intValue).max().getAsInt();
		System.out.println("Max value in the list :: "+maxValue);
		
		System.out.println("2. Find the Minimum number in the given List of integer");
		int minValue=listOfNumber.stream().mapToInt(Integer::intValue).min().getAsInt();
		System.out.println("Min value in the list :: "+minValue);
		
		System.out.println("3. Find the Average number in the given List of integer");
		Double avgValue=listOfNumber.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println("Avg value in the list :: "+avgValue);
		
		System.out.println("4. Find the Sum number in the given List of integer");
		int sumValue=listOfNumber.stream().mapToInt(Integer::intValue).sum();
		System.out.println("sum value in the list :: "+sumValue);
		
		System.out.println("5. Find the total number in the given List of integer");
		long count=listOfNumber.stream().count();
		System.out.println("total number value in the list :: "+count);
		
		System.out.println("6. Find the max/min/average/count/sum in the given List of integer");
		System.out.println("original List is");
		listOfNumber.stream().forEach(System.out::print);
		IntSummaryStatistics summarystatistics=listOfNumber.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("Max value in the list :: "+summarystatistics.getMax());
		System.out.println("Min value in the list :: "+summarystatistics.getMin());
		System.out.println("Avg value in the list :: "+summarystatistics.getAverage());
		System.out.println("sum value in the list :: "+summarystatistics.getSum());
		System.out.println("total number value in the list :: "+summarystatistics.getCount());
		
		System.out.println("7. sort number in the given List of integer (natural sorting)");
		System.out.println("sorted number value in the list :: ");
		listOfNumber.stream().sorted().forEach(System.out::println);
		
		System.out.println("8. sort number in the given List of integer (decending order)");
		System.out.println("sorted number in decending order value in the list :: ");
		listOfNumber.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("9. even number in the given List of integer ");
		System.out.println("even number in the list :: ");
		listOfNumber.stream().filter(a -> a%2==0).forEach(System.out::println);
		
		System.out.println("10. odd number in the given List of integer ");
		System.out.println("odd number in the list :: ");
		listOfNumber.stream().filter(a -> a%2!=0).forEach(System.out::println);

		System.out.println("11. even and odd number in the given List of integer ");
		Map<Boolean,List<Integer>> oddEven=listOfNumber.stream().collect(Collectors.partitioningBy(n-> n%2==0));
		System.out.println("even and odd number in the list :: "+oddEven);
		oddEven.forEach((key,value) -> {
			if(key == true){
				//value.forEach(System.out::println);
				System.out.println("even "+value);
			}else{
				System.out.println("odd "+value);
			}
		}
				);
		
		
		System.out.println("12. find the square of number in the given List of integer ");
		//listOfNumber.stream().map(a -> a*a).forEach(System.out::println);
		List<Integer> squarList=listOfNumber.stream().map(a -> a*a).collect(Collectors.toList());
		System.out.println(squarList);
		
		
		System.out.println("13. find the number start with 1 in the given List of integer ");
		//listOfNumber.stream().map(a -> a+"").filter(a -> a.startsWith("1")).forEach(System.out::println);
		List<Integer> startWithoneList=listOfNumber.stream().map(a -> a+"").filter(a -> a.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
		System.out.println("start With one"+startWithoneList);
		
		
		System.out.println("14. find the square of odd number in the given List of integer ");
		//listOfNumber.stream().filter(a -> a%2!=0).map( a -> a*a).forEach(System.out::println);
		List<Integer> oddSquare=listOfNumber.stream().filter(a -> a%2!=0).map( a -> a*a).collect(Collectors.toList());
		System.out.println("oddSquare "+oddSquare);
		
		System.out.println("15. find the TOP 3 number in the given List of integer ");
		//listOfNumber.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		List<Integer> top3NumberList=listOfNumber.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println("oddSquare "+top3NumberList);
		
		System.out.println("16. find the second largest number in the given List of integer ");
		List<Integer> secondLargestNumberList=listOfNumber.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).collect(Collectors.toList());
		Integer secondLargestNumber=listOfNumber.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("oddSquare "+secondLargestNumberList);
		System.out.println("oddSquare "+secondLargestNumber);
		
		
		System.out.println("17. find the second smallest number in the given List of integer ");
		List<Integer> secondsmallNumberList=listOfNumber.stream().distinct().sorted().skip(1).limit(1).collect(Collectors.toList());
		Integer secondsmallNumber=listOfNumber.stream().distinct().sorted().skip(1).findFirst().get();
		System.out.println("second  smallest number"+secondsmallNumberList);
		System.out.println("second  smallest number"+secondsmallNumber);
		
		
		System.out.println("18. Remove the duplicate in the given List of integer ");
		listOfNumber.stream().distinct().forEach(System.out::println);
		List<Integer> removingDuplicate=listOfNumber.stream().distinct().collect(Collectors.toList());
		System.out.println("removingDuplicate "+removingDuplicate);

		System.out.println("19. Find the occurence of each number in the given List of integer ");
		Map<Integer, List<Integer>> occurance=listOfNumber.stream().collect(Collectors.groupingBy(Function.identity()));
		System.out.println("without counting"+occurance);
		Map<Integer, Long> occurance1=listOfNumber.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("without counting"+occurance1);
		
		System.out.println("20. Find the duplicate in the given List of integer");
		occurance1.entrySet().stream()
		.filter(entry -> entry.getValue() > 1)
		.map(entry -> entry.getKey())
		.forEach(System.out::println);
		
		
		System.out.println("21. Find the non repeated number(unique) in the given List of integer");
		
		occurance1.entrySet().stream()
		.filter(entry -> entry.getValue() == 1)
		.map(entry -> entry.getKey())
		.forEach(System.out::println);
		
		System.out.println("22. Find the first non repeated number(unique) in the given List of integer");
		Map<Integer, Long> occurance12=listOfNumber.stream()
				.collect(Collectors.groupingBy(Function.identity(),
						LinkedHashMap::new,
						Collectors.counting()));
		
		Integer firstUnique=occurance12.entrySet().stream()
		.filter(entry -> entry.getValue() == 1)
		.map(entry -> entry.getKey())
		.findFirst().get();
		
		System.out.println(firstUnique);
		
		System.out.println("23. Find the first repeated number(unique) in the given List of integer");
		
		
		Integer firstUnique1=occurance12.entrySet().stream()
				.filter(entry -> entry.getValue() >	 1)
				.map(entry -> entry.getKey())
				.findFirst().get();
				
				System.out.println(firstUnique1);
				
		System.out.println("24. Find the most repeated number(unique) in the given List of integer");
		Integer mostRepeated=occurance12.entrySet().stream()
		.max(Map.Entry.comparingByValue())
		.get().getKey();
		
		System.out.println(mostRepeated);
		
		System.out.println("25. find the common elements between the given 2 List  of integer");
		
		System.out.println("26. find the uncommon elements between the given 2 List  of integer");
		
		System.out.println("27. Print first 5 odd numbers");
		
		System.out.println("28. Print first 5 even numbers");
		
		System.out.println("29. Print 10 random numbers");
		
		System.out.println("30. reverse the given List of integer");
		
		
		
	}

}
