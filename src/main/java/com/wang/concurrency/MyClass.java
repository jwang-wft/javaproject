package com.wang.concurrency;

public class MyClass {
	private int years;
	private int months;
	private volatile int days;
	
    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

	public void update(int years, int months, int days){
		this.years = years;
		this.months = months;
		this.days = days;
	}
}
