package pl.droidsonroids.calculator.data;

import rx.Observable;

public class Calculator {

	public float makeCalculation(final float firstNumberFloat, final float secondNumberFloat, final String sign) {
		float result = 0f;
		switch (sign) {
			case Sign.PLUS:
				result = firstNumberFloat + secondNumberFloat;
				break;
			case Sign.MINUS:
				result = firstNumberFloat - secondNumberFloat;
				break;
			case Sign.MULTIPLY:
				result = firstNumberFloat * secondNumberFloat;
				break;
			case Sign.DIVIDE:
				result = firstNumberFloat / secondNumberFloat;
		}
		return result;
	}

	public Observable<Float> calculate(final String firstNumber, final String secondNumber, final String sign) {
		return Observable.create(observer -> observer.onNext(makeCalculation(Float.valueOf(firstNumber),
				Float.valueOf(secondNumber),
				sign)));
	}

	public static class Sign {
		public static final String PLUS = "+";
		public static final String MINUS = "-";
		public static final String MULTIPLY = "*";
		public static final String DIVIDE = "/";
	}
}
