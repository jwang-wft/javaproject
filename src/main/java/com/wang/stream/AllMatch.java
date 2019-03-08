package com.wang.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllMatch {

	// Driver code
	public static void main(String[] args) {

		// Creating a list of Integers
		List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);

		// Check if all elements of stream
		// are divisible by 3 or not using
		// Stream allMatch(Predicate predicate)
		boolean answer = list.stream().allMatch(n -> n % 3 == 0);

		// Displaying the result
		if (answer) {
			System.out.println("All numbers are divisible by 3");
		} else {
			System.out.println("Not all numbers are divisible by 3");
		}
		list = Arrays.asList(2, 4, 6, 8, 222, 12);
		answer = list.stream().allMatch(AllMatch::isEvenNumber);
		if (answer) {
			System.out.println("All numbers are even number.");
		} else {
			System.out.println("Not all numbers are even number.");
		}
		
		Stream<String> stream = Stream.of("Geeks", "for", "Wang", "Qianjiang", "in");
		answer = stream.allMatch(AllMatch::isLengthGreaterThan2);
		if(answer){
			System.out.println("All string length greater than 2.");
		}else{
			System.out.println("Not all string length greater than 2.");
		}
		stream = Stream.of("Geeks", "For", "Wang", "Qianjiang", "In"); // can be used only once.
		answer = stream.allMatch(str -> Character.isUpperCase(str.charAt(0)));
		if(answer){
			System.out.println("All first letter in all strings are upper case.");
		}else{
			System.out.println("Not all first letter in string are upper case.");
		}
		
        String sample = "王黔江， 你好！"; 
        
        // converting to Ascii 
        IntStream intstreams = sample.chars(); 
  
        // All match to check if all Ascii value greater then 100 
        answer = intstreams.allMatch(c -> c > 100); 
        System.out.println(answer); 
  
        // Need to initialize the stream again 
        // to avoid runtime exception 
        sample = "this is a test.";
        intstreams = sample.chars(); 
        // All match to check if all Ascii value greater then 31 
  
        answer = intstreams.allMatch(c -> c > 31); 
        System.out.println(answer); 
  		
	}

	public static boolean isEvenNumber(int i) {
		return i % 2 == 0;
	}
	
	public static boolean isLengthGreaterThan2(String s){
		return s.length()>2;
	}
}
