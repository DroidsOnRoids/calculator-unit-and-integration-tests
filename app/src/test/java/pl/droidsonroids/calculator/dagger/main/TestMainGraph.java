package pl.droidsonroids.calculator.dagger.main;

import dagger.Component;
import pl.droidsonroids.calculator.ActivityScope;
import pl.droidsonroids.calculator.dagger.AppGraph;
import pl.droidsonroids.calculator.dagger.TestAppGraph;
import pl.droidsonroids.calculator.main.MainActivityTest;

@ActivityScope
@Component(modules = TestMainModule.class, dependencies = TestAppGraph.class)
public interface TestMainGraph extends MainGraph {

    void inject(MainActivityTest activityTest);

    final class Initializer {
        public static TestMainGraph init(AppGraph testAppGraph) {
            return DaggerTestMainGraph.builder()
                    .testAppGraph((TestAppGraph) testAppGraph)
                    .build();
        }
    }
}
