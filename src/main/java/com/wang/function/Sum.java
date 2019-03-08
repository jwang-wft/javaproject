package com.wang.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Sum {
	static List<Number> array = Arrays.asList(new Number("one", 1),
			new Number("two", 2), new Number("three", 3), new Number(
					"four", 4), new Number("five", 5), new Number(
					"six", 6), new Number("seven", 7), new Number(
					"eight", 8), new Number("nine", 9), new Number(
					"ten", 10));

	Integer doSum(String s1, String s2) {
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}

	Integer findNumber(String s) {
		Integer returnValue = 0;
		Number num = new Number();
		for (Number n : array) {
			if(n.name.equals(s)){
				returnValue = n.number;
				break;
			}
		}
		return returnValue;
	}

	// Define a function interface with 3 arguments, 2 for input, 1 for return
	// value
	interface TriFunction<T, U, V, R> {
		R apply(T t, U u, V v);
	}

	public static void main(String[] args) {
		TriFunction<Sum, String, String, Integer> anonymous = new TriFunction<Sum, String, String, Integer>() {

			@Override
			public Integer apply(Sum t, String u, String v) {
				return t.doSum(u, v);
			}
		};

		String s1 = "3";
		String s2 = "19";
		int d = anonymous.apply(new Sum(), s1, s2);
		System.out.println(String.format("%s + %s = %d", s1, s2, d));

		TriFunction<Sum, String, String, Integer> lambda = (Sum s, String ss1,
				String ss2) -> s.doSum(s1, s2);
		d = lambda.apply(new Sum(), s1, s2);
		System.out.println(String.format("%s + %s = %d", s1, s2, d));

		TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;
		d = mRef.apply(new Sum(), s1, s2);
		System.out.println(String.format("%s + %s = %d", s1, s2, d));
		
		BiFunction<Sum, String, Integer> f = Sum::findNumber;
		d = f.apply(new Sum(), "five");
		System.out.println(d);
	}

}

class Number {
	String name;
	Integer number;
	
	Number(){}
	
	Number(String name, Integer number) {
		this.name = name;
		this.number = number;
	}
}
