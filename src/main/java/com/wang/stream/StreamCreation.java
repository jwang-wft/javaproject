package com.wang.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.wang.hashmapaverage.SearchByKey;
/*
 * 
 */
public class StreamCreation {
	static HashMap<String, Integer> numbers = SearchByKey.numbers;

	static List<Product> productList = Arrays.asList(new Product(14, "orange"),
			new Product(23, "potatoes"), new Product(13, "lemon"), new Product(
					34, "bread"), new Product(11, "sugar"));
	private static Consumer<String> productConsumer = System.out::println;

	public static int compareByName(String s1, String s2) {
		return s1.compareTo(s2);
	}

	public static void main(String[] args) {
		List<String> productNames = productList.stream().map(Product::getName).collect(Collectors.toList());
		productNames.stream().forEach(productConsumer);
		//sorted in order
		System.out.println("\nSorted in order");
		productNames.stream().sorted().forEach(productConsumer);;
		System.out.println("\nSorted in order");
		productNames.stream().sorted(StreamCreation::compareByName).forEach(productConsumer);;
		System.out.println("\nin creation order");
		productNames.stream().forEach(System.out::println);
		System.out.println("\nin reverse order");
		productNames.stream().sorted(Comparator.reverseOrder()).forEach(productConsumer);;
	}

}

class Product {
	int id;
	String name;

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}