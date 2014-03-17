package com.hupel.calculator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.hupel.calculator.IStringCalculator;
import com.hupel.calculator.internal.StringCalculatorImpl;

public class StringCalculatorImplTest {

	private static final String EMPTY_STRING = "";

	@Test
	public void addReturnNullIfInputStringIsEmpty() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("Empty string: ", stringCalculator.add(EMPTY_STRING),
				is(equalTo(0)));
	}

	@Test
	public void addWithOneNumber() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("String with one number: ", stringCalculator.add("1"),
				is(equalTo(1)));
	}

	@Test
	public void addWithTwoNumbers() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("String with two numbers: ", stringCalculator.add("1,2"),
				is(equalTo(3)));
	}

	@Test
	public void addWithUnknownNumbers() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("String with unknown numbers: ",
				stringCalculator.add("1,2,3,4,5,6,7,8,9,10"), is(equalTo(55)));
	}

	@Test
	public void addWithNewLines() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("String with new lines: ",
				stringCalculator.add("1\n2,3"), is(equalTo(6)));
	}
	
	@Test
	public void addWithNewLines2() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("String with unknown numbers: ",
				stringCalculator.add("1,\n"), is(equalTo(1)));
	}
	
	@Test
	public void addWithNewLines3() {
		IStringCalculator stringCalculator = new StringCalculatorImpl();

		assertThat("String with unknown numbers: ",
				stringCalculator.add("1,\n2,3"), is(equalTo(6)));
	}
}
