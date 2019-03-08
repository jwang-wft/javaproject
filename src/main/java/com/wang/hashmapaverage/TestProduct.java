package com.wang.hashmapaverage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestProduct {
	public static void main(String[] args) {
		Map <String, Integer> fre = calculateFrequency(productList) ;
		fre.entrySet().stream().forEach(System.out::println);
		
		// use productMap.values().stram()
		Map<String, Double> avgMap = calculateAverage();
		System.out.println("Calculate Average from Map:");
		avgMap.entrySet().stream().forEach(System.out::println);
		
		//use Collectors.averagingInt() 
		Map<String, Double> avg = calculateAverage(productList);
		System.out.println("Calculate Average from List:");
		avg.entrySet().stream().forEach(System.out::println);
		
		//average on every product's quantity
		DecimalFormat df = new DecimalFormat("0.##");
		System.out.println("Average = " + df.format(calculateAvgWithNoGroup()));
		
		Map<String, Integer> total = calculateTotal();
		System.out.println("Calculate total grouped by Currency:");
		total.entrySet().stream().forEach(System.out::println);
		
		//use Collectors.summarizingInt() to get statistics such as 
		//USD=IntSummaryStatistics{count=5, sum=256, min=29, average=51.200000, max=131}
		Map<String, IntSummaryStatistics> statistics = calculateStatisticsProductByCurrency();
		statistics.entrySet().stream().forEach(System.out::println);
		
	}

	public static Map <String,Integer> calculateFrequency(List <Product> pList)
    {
        Map <String, Integer> frequency = new HashMap <String, Integer> ();

        for(Product p:pList)
        {
            Integer freq = frequency.get(p.getCurrency());
            if(freq==null) freq=0;
            frequency.put(p.getCurrency(),freq+1);
        }
        return frequency;
    }
	
	//calculate average by using Collectors.averagingInt(Product::getQuantity)
	public static Map<String, Double> calculateAverage(List<Product> pList){
		Map<String, Double> avgProductByCurrency = pList.parallelStream().collect(Collectors.groupingBy(Product::getCurrency,Collectors.averagingInt(Product::getQuantity)));
		return avgProductByCurrency;
	}
	
	public static Map<String, Double> calculateAverage(){
		Map<String, Double> avg = productMap.values().stream().collect(Collectors.groupingBy(Product::getCurrency,Collectors.averagingInt(Product::getQuantity)));
		return avg;
	}
	
	public static Double calculateAvgWithNoGroup(){
		return productList.parallelStream().collect(Collectors.averagingInt(Product::getQuantity));
	}
	
	public static Map<String, Integer> calculateTotal(){
		return productList.parallelStream().collect(Collectors.groupingBy(Product::getCurrency,Collectors.summingInt(Product::getQuantity)));
	}
	
	public static Map<String, IntSummaryStatistics> calculateStatisticsProductByCurrency(){
		Map<String, IntSummaryStatistics> totalProductByCurrency =
			    productList
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			                Product::getCurrency,                      
			                Collectors.summarizingInt(Product::getQuantity)));
		return totalProductByCurrency;
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
