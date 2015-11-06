package pl.droidsonroids.calculator.data.dagger.main;

import dagger.Component;
import pl.droidsonroids.calculator.ActivityScope;
import pl.droidsonroids.calculator.dagger.AppGraph;
import pl.droidsonroids.calculator.dagger.main.MainGraph;
import pl.droidsonroids.calculator.data.dagger.TestAppGraph;

@ActivityScope
@Component(modules = TestMainModule.class, dependencies = TestAppGraph.class)
public interface TestMainGraph extends MainGraph {

    final class Initializer {
        public static TestMainGraph init(AppGraph testAppGraph) {
            return DaggerTestMainGraph.builder()
                    .testAppGraph((TestAppGraph) testAppGraph)
                    .build();
        }
    }
}
