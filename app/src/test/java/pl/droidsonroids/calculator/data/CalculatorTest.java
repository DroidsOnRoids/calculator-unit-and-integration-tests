package pl.droidsonroids.calculator.data;

import org.junit.Before;
import org.junit.Test;

import pl.droidsonroids.calculator.data.Calculator.Sign;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	private static final double DELTA = 0.00001;
	private Calculator mCalculator;

	@Before
	public void setUp() {
		mCalculator = new Calculator();
	}

	@Test
	public void testAddition() {
		assertEquals(5f, mCalculator.makeCalculation(2, 3, Sign.PLUS), DELTA);
	}

	@Test
	public void testSubtraction() {
		assertEquals(18f, mCalculator.makeCalculation(21f, 3f, Sign.MINUS), DELTA);
	}

	@Test
	public void testMultiplication() {
		assertEquals(80f, mCalculator.makeCalculation(10f, 8f, Sign.MULTIPLY), DELTA);
	}

	@Test
	public void testDivision() {
		assertEquals(4f, mCalculator.makeCalculation(20f, 5f, Sign.DIVIDE), DELTA);
	}

	@Test
	public void testInfinity() {
		assertEquals(Float.POSITIVE_INFINITY, mCalculator.makeCalculation(12f, 0f, Sign.DIVIDE), DELTA);
	}

	@Test
	public void testNaN() {
		assertEquals(Float.NaN, mCalculator.makeCalculation(0f, 0f, Sign.DIVIDE), DELTA);
	}
}
