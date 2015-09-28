package pl.droidsonroids.calculator.main;

import pl.droidsonroids.calculator.data.Calculator;
import rx.Subscription;

import static rx.subscriptions.Subscriptions.empty;

public class MainPresenterImpl implements MainPresenter {

	public final Calculator calculator;
	private final MainView view;

	public Subscription subscription;

	public MainPresenterImpl(Calculator calculator, MainView view) {
		this.calculator = calculator;
		this.view = view;
	}

	@Override
	public void init() {
		subscription = empty();
	}

	@Override
	public void makeCalculation(String firstNumber, String secondNumber, String selectedSign) {
		subscription = calculator.calculate(firstNumber, secondNumber, selectedSign)
				.subscribe(view::showResult, throwable -> view.showError());
	}

	@Override
	public void destroy() {
		subscription.unsubscribe();
	}


}
