package com.wang.methodreference;
import java.util.function.Consumer;


public class LamabdaExpression {

	public static void main(String[] args) {
		//lambda expression, variable s will be used in the function call of System.out.println();
		Consumer<String> c = s -> System.out.println(s);
//		(args) -> Class.staticMethod(args);
		
		// the Consumer<string> c has a format of
		// c.accept(s); where s is the variable defined on above syntax.
		c.accept("this is my test.");
		
		Product p = new Product(1L, "tv", 200000L);
		// where <Product> define pc is an instance of Product.
		Consumer<Product> productConsumer = pc -> {
			String result = String.format("product name: %s, price: %5.2f", pc.name, pc.price/100.0);
			System.out.println(result);
		};
		
		productConsumer.accept(p);
	}

}

class Product {
	Long id;
	String name;
	long price; // do not use float or double for currency
	
	Product(long id, String name, long price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
}
