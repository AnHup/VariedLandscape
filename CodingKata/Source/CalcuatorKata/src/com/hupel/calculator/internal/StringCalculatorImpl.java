package com.hupel.calculator.internal;

import com.hupel.calculator.IStringCalculator;

public class StringCalculatorImpl implements IStringCalculator {

	private static final String DOUBLE_COMMA = ",,";
	private static final String COMMA = ",";
	private static final String NEW_LINE = "\n";
	private static final String EMPTY_STRING = "";

	@Override
	public int add(String numbers) {

		if (numbers == EMPTY_STRING) {
			return 0;
		}

		numbers = analyzeInputNumberString(numbers);

		String[] numberParts = numbers.split(COMMA);

		if (numberParts.length > 1) {

			int sum = 0;

			for (int i = 0; i < numberParts.length; i++) {
				sum += convertFromStringToInt(numberParts[i]);
			}
			return sum;
		} else {
			return convertFromStringToInt(numbers.replace(COMMA, EMPTY_STRING));
		}
	}

	/**
	 * Analyze input number string.
	 *
	 * @param numbers the numbers
	 * @return the analyzed string
	 */
	private String analyzeInputNumberString(String numbers) {
		if (numbers.contains(NEW_LINE)) {
			numbers = numbers.replace(NEW_LINE, COMMA);
		}

		if (numbers.contains(DOUBLE_COMMA)) {
			numbers = numbers.replace(DOUBLE_COMMA, COMMA);
		}
		return numbers;
	}

	/**
	 * Convert from string to int.
	 *
	 * @param numberPart the number part
	 * @return the int value of the string
	 */
	private int convertFromStringToInt(String numberPart) {
		return Integer.valueOf(numberPart);
	}
}
