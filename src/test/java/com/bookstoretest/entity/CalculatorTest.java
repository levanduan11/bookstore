package com.bookstoretest.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator=new Calculator();
		int a=1;
		int b=2;
		int res=calculator.add(1,2);
		int expected=3;
		assertEquals(expected,res);
	}

}
