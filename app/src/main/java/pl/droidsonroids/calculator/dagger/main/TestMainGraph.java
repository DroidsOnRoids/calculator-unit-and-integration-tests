package pl.droidsonroids.calculator.dagger.main;

import dagger.Component;
import pl.droidsonroids.calculator.ActivityScope;
import pl.droidsonroids.calculator.dagger.AppGraph;
import pl.droidsonroids.calculator.dagger.TestAppGraph;

@ActivityScope
@Component(modules = TestMainModule.class, dependencies = TestAppGraph.class)
public interface TestMainGraph extends MainGraph {

	final class Initializer {
		public static TestMainGraph init(AppGraph testAppGraph) {
			return DaggerTestMainGraph.builder()
					.testMainModule(new TestMainModule())
					.testAppGraph((TestAppGraph) testAppGraph)
					.build();
		}
	}
}
