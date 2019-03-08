package com.wang.annotations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStudent {
	Student s;
	@Before
	public void setUp() throws Exception {
		s = new Student();
	}

	@Test
	public void test() {
		String name = "John Wang";
//		assertTrue(18==s.getAge());
		assertEquals(name, s.getName());
	}

}
