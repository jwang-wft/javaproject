package com.wang.scanner;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many numbers you want to use? ");
		int s = sc.nextInt();
		HashMap<Integer, Float> hm = new HashMap<Integer, Float>();
		for (int i = 0; i < s; i++) {
			System.out.print("enter first integer: ");
			int first = sc.nextInt();
			System.out.print("enter next float: ");
			float second = sc.nextFloat();
			hm.put(first, second);
		}
		System.out.println("The average is " + display(hm));
		sc.close();
	}

	public static String display(HashMap<Integer, Float> hm) {
		float sum = 0;
		int count = 0;
		DecimalFormat df = new DecimalFormat("#.00");
		Iterator<Integer> it = hm.keySet().iterator();
		//Only sum up when the key value is even number
		while (it.hasNext()) {
			int y = it.next();
			if (y % 2 == 0) {
				sum = (float) (sum + hm.get(y));
				count++;
			}
		}
		System.out.println("Total is: " + sum);
		System.out.println("counts: " + count);
		float d = sum / count;
		return df.format(d);
	}
}
