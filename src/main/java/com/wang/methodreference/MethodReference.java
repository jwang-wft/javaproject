package com.wang.methodreference;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;


public class MethodReference {
// method reference syntax (Object :: methodName)
	public static void main(String[] args) {
		Consumer<String> c = System.out::println;
//		Class::staticMethod;
		c.accept("this is a test.");		
		c = MethodReference::sayHello;
		c.accept("John");
		
		Calendar calendar = Calendar.getInstance();
		Person p = new Person("John Q. Wang", calendar.getTime());
		Consumer<Person> display = Person::display;
		display.accept(p);
		
		//define a function reference, and call directly
		Function<Person, Date> getBirthDay = Person::getBirthday;
		Date birthday = getBirthDay.apply(p);
		System.out.println(birthday);
	}

	public static void sayHello(String name){
		System.out.println("Hello, " + name + "!");
	}
	
	
}
