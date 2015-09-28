package pl.droidsonroids.calculator;

import android.app.Application;

import pl.droidsonroids.calculator.dagger.AppGraph;
import pl.droidsonroids.calculator.dagger.TestAppGraph;
import pl.droidsonroids.calculator.dagger.main.MainGraph;
import pl.droidsonroids.calculator.dagger.main.TestMainGraph;
import pl.droidsonroids.calculator.main.MainView;

public class CalculatorApplication extends Application {

	private static CalculatorApplication sInstance;
	private AppGraph appGraph;

	private boolean isTestMode = false;

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;
		appGraph = AppGraph.Initializer.init(this);
	}

	public void initTestMode() {
		appGraph = TestAppGraph.Initializer.init(this);
		isTestMode = true;
	}

	public static CalculatorApplication getInstance() {
		return sInstance;
	}


	public MainGraph getMainGraph(MainView view) {
		if (isTestMode)
			return TestMainGraph.Initializer.init(appGraph);
		else
			return MainGraph.Initializer.init(appGraph, view);
	}
}