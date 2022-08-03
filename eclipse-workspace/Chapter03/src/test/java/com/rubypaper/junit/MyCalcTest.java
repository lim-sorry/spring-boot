package com.rubypaper.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCalcTest {

	private MyCalc calc;
	
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		System.out.println("===> setUpBeforeClass()");
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		System.out.println("===> tearDownAfterClass()");
//	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("---> setUp()");
		calc = new MyCalc(10, 3);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("---> tearDown()");
		calc = null;
	}

	@Test
	void testPlus() {
		System.out.println("===> testPlus()");
		assertEquals(13, calc.plus());
	}

	@Test
	void testMinus() {
		System.out.println("===> testMinus()");
		assertEquals(7, calc.minus());
	}

}
