package com.wang.test;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.junit.Test;

public class HashmapFindMax {

	static private HashMap<String, Integer> numbers = new HashMap<String, Integer>();
	static {
		numbers.put("one", 1);
		numbers.put("10", 10);
		numbers.put("9", 9);
		numbers.put("four", 4);
		numbers.put("three", 3);
		numbers.put("five", 5);
		numbers.put("seven", 7);
		numbers.put("two", 2);
		numbers.put("six", 6);
	}

	@Test
	public void findMaxValueInHashmap() {
		Map.Entry<String, Integer> max = null;
		for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
			if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
				max = entry;
			}
		}
		assertEquals(new Integer(10), max.getValue());
	}

	@Test
	public void findMaxValueInHashmapJava8() {
		Comparator<? super Entry<String, Integer>> maxValueComparator = (
				entry1, entry2) -> entry1.getValue().compareTo(
				entry2.getValue());
		Optional<Entry<String, Integer>> maxValue = numbers.entrySet().stream()
				.max(maxValueComparator);

		assertEquals(new Integer(10), maxValue.get().getValue());
	}
}
