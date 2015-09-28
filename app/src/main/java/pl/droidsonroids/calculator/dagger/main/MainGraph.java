package pl.droidsonroids.calculator.dagger.main;

import dagger.Component;
import pl.droidsonroids.calculator.ActivityScope;
import pl.droidsonroids.calculator.dagger.AppGraph;
import pl.droidsonroids.calculator.main.MainActivity;
import pl.droidsonroids.calculator.main.MainPresenter;
import pl.droidsonroids.calculator.main.MainView;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppGraph.class)
public interface MainGraph {

	void inject(MainActivity mainActivity);
	MainPresenter getMainPresenter();

	final class Initializer {
		public static MainGraph init(AppGraph appGraph, MainView mainView) {
			return DaggerMainGraph.builder()
					.mainModule(new MainModule(mainView))
					.appGraph(appGraph)
					.build();
		}
	}

}
