package com.wang.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wang.hashmapaverage.Product;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		long t1, t2;
		List<Employee> eList = new ArrayList<Employee>();
		for (int i = 0; i < 100; i++) {
			eList.add(new Employee("A", 20000));
			eList.add(new Employee("B", 3000));
			eList.add(new Employee("C", 1500));
			eList.add(new Employee("D", 7856));
			eList.add(new Employee("E", 200));
			eList.add(new Employee("F", 50000));
		}

		/***** Here We Are Creating A 'Sequential Stream' & Displaying The Result *****/
		t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream Count?= " + eList.stream().filter(e -> e.getSalary() > 15000).count());

		t2 = System.currentTimeMillis();
		System.out.println("Sequential Stream Time Taken?= " + (t2 - t1) + "\n");

		/***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
		t1 = System.currentTimeMillis();
		System.out.println("Parallel Stream Count?= " + eList.parallelStream().filter(e -> e.getSalary() > 15000).count());
		t2 = System.currentTimeMillis();
		//calculate Average
		System.out.println("Parallel Stream average?= " + eList.parallelStream().collect(Collectors.averagingLong(Employee::getSalary)));
		
		System.out.println("Parallel Stream Time Taken?= " + (t2 - t1));
	}

}

class Employee {
	String name;
	long salary;

	Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public long getSalary() {
		return salary;
	}

}