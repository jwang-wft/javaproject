package com.wang.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import com.wang.hashmapaverage.Product;

public class Filter {
	public static void main(String[] args) {
		int sum = productList.stream().filter(p -> p.getCurrency().equals("USD")).mapToInt(p ->p.getQuantity()).sum();
		System.out.println("Total sale on USD = " + sum);
		sum = productMap.values().stream().filter(p -> p.getCurrency().equals("CHN")).mapToInt(p ->p.getQuantity()).sum();
		System.out.println("Total sale on CHN = " + sum);
		OptionalDouble avg = productMap.values().stream().filter(p -> p.getCurrency().equals("CHN")).mapToInt(p ->p.getQuantity()).average();
		System.out.println("Average sale on CHN = " + avg.getAsDouble());
		avg = productMap.values().stream().filter(p -> p.getCurrency().equals("USD")).mapToInt(p ->p.getQuantity()).average();
		System.out.println("Average sale on USD = " + avg.getAsDouble());
		avg = productMap.values().stream().mapToInt(p ->p.getQuantity()).average();
		System.out.println("Average all sales = " + avg.getAsDouble());
	}
	
	public static List<Product> productList = new ArrayList<Product>();
	static{
		Product p = new Product("orange", "USD", 29);
		productList.add(p);
		p = new Product("orange", "CHN", 67);
		productList.add(p);
		p = new Product("tomato", "USD", 31);
		productList.add(p);
		p = new Product("watermalon", "USD", 31);
		productList.add(p);
		p = new Product("banana", "USD", 34);
		productList.add(p);
		p = new Product("paper", "USD", 131);
		productList.add(p);
		p = new Product("paper", "CHN", 131);
		productList.add(p);
	}
	public static Map<String, Product> productMap = new HashMap<String, Product>();
	static{
		Product p = new Product("1","orange", "USD", 29);
		productMap.put(p.getId(), p);
		p = new Product("2", "orange", "CHN", 67);
		productMap.put(p.getId(), p);
		p = new Product("3", "tomato", "USD", 31);
		productMap.put(p.getId(), p);
		p = new Product("4", "watermalon", "USD", 31);
		productMap.put(p.getId(), p);
		p = new Product("5", "banana", "USD", 34);
		productMap.put(p.getId(), p);
		p = new Product("6", "paper", "USD", 131);
		productMap.put(p.getId(), p);
		p = new Product("7","paper", "CHN", 131); 
		productMap.put(p.getId(), p);
	}

}
