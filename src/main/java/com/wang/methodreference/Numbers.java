package com.wang.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Numbers {

	public static boolean isMoreThanFifty(int i1, int i2) {
		return i1 + i2 > 50;
	}

	public static List<Integer> findNumbers(List<Integer> l,
			BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		for (Integer i : l) {
			//test to see if the given number + 10 is greater than 50?
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
		Consumer<List> c = Numbers::printList;
		c.accept(list);
		// Using an anonymous class
		List<Integer> newList = findNumbers(list,
				new BiPredicate<Integer, Integer>() {
					public boolean test(Integer i1, Integer i2) {
						return Numbers.isMoreThanFifty(i1, i2);
					}
				});
		c.accept(newList);
		// Using a lambda expression
		newList = findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
		c.accept(newList);
		// Using a method reference
		newList = findNumbers(list, Numbers::isMoreThanFifty);
		c.accept(newList);
	}

	private static void printList(List<Integer> l) {
		for (Integer i : l) {
			System.out.println(i);
		}
		System.out.println();
	}
}
