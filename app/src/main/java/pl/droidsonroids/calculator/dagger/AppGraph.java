package pl.droidsonroids.calculator.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.droidsonroids.calculator.CalculatorApplication;
import pl.droidsonroids.calculator.data.Calculator;

@Singleton
@Component(modules = AppModule.class)
public interface AppGraph {

	void inject(CalculatorApplication calculatorApplication);
	Calculator getCalculator();

	final class Initializer {
		public static AppGraph init(CalculatorApplication application) {
			AppGraph appGraph = DaggerAppGraph.builder().build();
			appGraph.inject(application);
			return appGraph;
		}
	}

}
