package com.wang.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamModify {

	public static void main(String[] args) {
		List<String> list = new ArrayList(Arrays.asList("One", "Two"));
		Stream<String> steam = list.stream();
		list.add("three");
		String s = steam.collect(Collectors.joining("::"));
		System.out.println(s);
	}

}
