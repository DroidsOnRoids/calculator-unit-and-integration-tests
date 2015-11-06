package pl.droidsonroids.calculator;

import pl.droidsonroids.calculator.dagger.main.MainGraph;
import pl.droidsonroids.calculator.data.dagger.TestAppGraph;
import pl.droidsonroids.calculator.data.dagger.main.TestMainGraph;
import pl.droidsonroids.calculator.main.MainView;

public class TestCalculatorApplication extends CalculatorApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        appGraph = TestAppGraph.Initializer.init(this);
    }

    @Override
    public MainGraph getMainGraph(final MainView view) {
        return TestMainGraph.Initializer.init(appGraph);
    }
}
