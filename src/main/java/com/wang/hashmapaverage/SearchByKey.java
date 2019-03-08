package com.wang.hashmapaverage;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchByKey {
	//best way to calculate average from HashMap
	public static Double calculateAvg(){
		return numbers.entrySet().parallelStream().collect(Collectors.averagingInt(Entry::getValue));
	}
	
	public static void main(String[] args) {
		Double avg = calculateAvg();
		System.out.println("Average = " + new DecimalFormat("0.00").format(avg));
		Integer i = numbers.get("three");
		System.out.println("three::" + i);
		i = numbers.get("six");
		System.out.println("six::" + i);

		Function<SearchByKey, Integer> c = SearchByKey::findMax;
		Integer d = c.apply(new SearchByKey());
		System.out.println("Loop through all values, max = " + d);
		c = SearchByKey::findMaxEntrySet;
		d = c.apply(new SearchByKey());
		System.out.println("Loop through EntrySet, max = " + d);
		c = SearchByKey::findMinJava8;
		d = c.apply(new SearchByKey());
		System.out.println("Lambda Expresion EntrySet.stream.min(), min = " + d);
		c = SearchByKey::findMaxMethodRef;
		d = c.apply(new SearchByKey());
		System.out.println("EntrySet.stream.max with method reference, max = "
				+ d);
		double dbl = findAvgWithoutLoop();
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(String.format("Average = %s", df.format(dbl)));
	}

	//Collectors.summingInt()
	public static Double findAvgWithoutLoop() {
		int total = numbers.entrySet().stream().collect(Collectors.summingInt(Entry::getValue));
		long count = numbers.entrySet().stream().count();
		Double avg = (double) total / count;
		return avg;
	}

	public Integer findMax() {
		Integer max = null;
		for (int i : numbers.values()) {
			if (max == null) {
				max = i;
			}
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	public Integer findMaxEntrySet() {
		Map.Entry<String, Integer> max = null;
		for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
			if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
				max = entry;
			}
		}
		return max.getValue();
	}

	public Integer findMinJava8() {
		Comparator<? super Entry<String, Integer>> maxValueComparator = (
				entry1, entry2) -> entry1.getValue().compareTo(
				entry2.getValue());
		Optional<Entry<String, Integer>> maxValue = numbers.entrySet().stream().min(maxValueComparator);
		return maxValue.get().getValue();
	}

	public Integer findMaxMethodRef() {
		Optional<Entry<String, Integer>> maxValue = numbers.entrySet().stream().max(SearchByKey::compareByValue);
		return maxValue.get().getValue();
	}

	public static int compareByValue(Entry<String, Integer> e1,
			Entry<String, Integer> e2) {
		return e1.getValue().compareTo(e2.getValue());
	}


	public static HashMap<String, Integer> numbers = new HashMap<String, Integer>();
	static {
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("five", 5);
		numbers.put("six", 6);
		numbers.put("seven", 7);
		numbers.put("nine", 9);
		numbers.put("ten", 10);
		numbers.put("three", 3);
		numbers.put("four", 4);
		numbers.put("eight", 8);
	}
}
