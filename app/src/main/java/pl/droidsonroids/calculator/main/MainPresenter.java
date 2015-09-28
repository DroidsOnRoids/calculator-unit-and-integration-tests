package pl.droidsonroids.calculator.main;

public interface MainPresenter {
	void init();
	void makeCalculation(String firstNumber, String secondNumber, String selectedSign);
	void destroy();
}
