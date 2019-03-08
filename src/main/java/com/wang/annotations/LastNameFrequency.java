package com.wang.annotations;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class LastNameFrequency {

	static String[] nameArray = {"Scott james", "mike scott", "tim james", "venkat naidu", "ashwin kumar", "partha reddy"};
	static Hashtable<String, Integer> buffer = new Hashtable<String, Integer>();
	public static void main(String[] args) {
		for (int i = 0; i < nameArray.length; i++) {
			String name = nameArray[i];
			StringTokenizer st = new StringTokenizer(name, " ");
			st.nextElement();
			String lastname = st.nextToken();
			Integer tmp = buffer.get(lastname);
			if (tmp == null) {
				buffer.put(lastname, 1);
			} else {
				buffer.put(lastname, ++tmp);
			}
		}
		Enumeration<String> e = buffer.keys();
		while (e.hasMoreElements()) {
			String lastname = e.nextElement();
			System.out.printf("%d \"%s\" in the array.\n", buffer.get(lastname), lastname);
		}
	}

}
