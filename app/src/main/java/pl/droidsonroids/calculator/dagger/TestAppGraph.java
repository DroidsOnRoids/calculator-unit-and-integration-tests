package pl.droidsonroids.calculator.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.droidsonroids.calculator.CalculatorApplication;

@Singleton
@Component(modules = TestAppModule.class)
public interface TestAppGraph extends AppGraph {

	final class Initializer {
		public static TestAppGraph init(CalculatorApplication application) {
			TestAppGraph appGraph = DaggerTestAppGraph.builder().build();
			appGraph.inject(application);
			return appGraph;
		}
	}
}
