package com.wang.hashmapaverage;

public class Product {
	String id;
	String name;
	String currency;
	int quantity;

	public String getName() {
		return name;
	}

	public String getCurrency() {
		return currency;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product(String pName, String pCurrency, int pQty) {
		name = pName;
		currency = pCurrency;
		quantity = pQty;
	}
	

	public Product(String id, String pName, String pCurrency, int pQty) {
		this.id = id;
		name = pName;
		currency = pCurrency;
		quantity = pQty;
	}
	
	public String getId(){
		return id;
	}
	public String toString(){
		return name + ":" + currency + ":" + quantity;
	}
}
