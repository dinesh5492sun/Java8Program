package com.java8.comprable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompratorDemo {

	public static void main(String[] args) {
		
		Comparator<Integer> com=new Comparator<Integer>()
		{
			public int compare(Integer i,Integer j){
				if(i%10 > j%10)
					return 1;
				else
					return -1;
			}
		};
		
		List<Integer> nums=new ArrayList<>();
		nums.add(43);
		nums.add(31);
		nums.add(72);
		nums.add(43);
		nums.add(39);
		
		List<Integer> numsResult=nums.stream().sorted((a,b)-> (a%10 > b%10)?1:-1).collect(Collectors.toList());
		System.out.println("Result ::"+numsResult);
		Collections.sort(nums);
		System.out.println(nums);
		Collections.sort(nums,com);
		System.out.println(nums);
		
		
		
	}
}
