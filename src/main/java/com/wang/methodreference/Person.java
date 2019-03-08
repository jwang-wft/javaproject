package com.wang.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	Date birthday;
	Sex gender;
	String emailAddress;
	int age;

	public Person(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
		getAge();
	}

	public static List<Person> createRoster() {
		ArrayList<Person> list = new ArrayList<Person>() {
			{
				add(new Person("John", new Date(1953, 11, 22)));
				add(new Person("Ailian", new Date(1959, 5, 11)));
				add(new Person("Charles", new Date(1982,11,22)));
			}
		};
		// throw new UnsupportedOperationException();
		return list;
	}

	public int getAge() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int birthdayYear = birthday.getYear();
		age = thisYear - birthdayYear;
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public void printPerson() {
		System.out.println(toString());
	}
	
	public static boolean display(Person p){
		String s = p.toString();
		System.out.println(s);
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append("::");
		sb.append(age);
		return sb.toString();
	}
}
