package com.wang.annotations;

public class Student {
	private String name;
	private int age;
	private String stream;
	private String address;

	@MyStudentAnnotation(name = "John Wang", address = "Sugar Land, TX")
	public Student() {
	}

	public Student(String name, int age, String stream, String address) {
		super();
		this.name = name;
		this.age = age;
		this.stream = stream;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
