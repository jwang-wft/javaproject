package com.wang.stream;

import java.util.Arrays;
import java.util.List;

public class Reduce {
	static List<Integer> numbers = Arrays.asList(1,2,6,4,7,9,34);
	public static void main(String[] args) {
		int sum = numbers.stream().reduce(0, (x,y) -> x+y);
		sum = numbers.parallelStream().reduce(0, Integer::sum);
		System.out.println("Total = " + sum);
	}

}
