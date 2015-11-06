package pl.droidsonroids.calculator;

import pl.droidsonroids.calculator.dagger.TestAppGraph;
import pl.droidsonroids.calculator.dagger.main.TestMainGraph;
import pl.droidsonroids.calculator.main.MainView;

public class TestCalculatorApplication extends CalculatorApplication {

    private static TestCalculatorApplication sInstance;

    public static TestCalculatorApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        appGraph = TestAppGraph.Initializer.init(this);
    }

    @Override
    public TestMainGraph getMainGraph(final MainView view) {
        return TestMainGraph.Initializer.init(appGraph);
    }
}
