package com.wang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.CONSTRUCTOR)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyStudentAnnotation {
	int age() default 18;
	String name();
	String address();
	String stream() default "CSE";
}
