package com.wang.hashset;

import java.util.HashSet;

public class HashSetDemo {

	public static void main(String[] args) {
	     HashSet<String> hset = new HashSet<String>();
	     String nullString = null;
	     //add elements to HashSet
	     hset.add("AA");
	     hset.add("BB");
	     hset.add("CC");
	     hset.add("DD");
	     hset.add("AA"); //no duplication in HashSet
	     hset.add(null);
	     hset.add(nullString); // could only have a single null value;
	 
	     // Displaying HashSet elements
	     System.out.println("HashSet contains: ");
	     for(String temp : hset){
	        System.out.println(temp);
	     }
	}

}
