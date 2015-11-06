package pl.droidsonroids.calculator.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.droidsonroids.calculator.TestCalculatorApplication;

@Singleton
@Component(modules = TestAppModule.class)
public interface TestAppGraph extends AppGraph {

    void inject(TestCalculatorApplication calculatorApplication);

    final class Initializer {
        public static TestAppGraph init(TestCalculatorApplication application) {
            TestAppGraph appGraph = DaggerTestAppGraph.builder().build();
            appGraph.inject(application);
            return appGraph;
        }
    }
}
