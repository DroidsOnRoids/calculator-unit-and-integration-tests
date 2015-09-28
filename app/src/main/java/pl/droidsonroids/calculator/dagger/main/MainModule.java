package pl.droidsonroids.calculator.dagger.main;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.calculator.data.Calculator;
import pl.droidsonroids.calculator.main.MainPresenter;
import pl.droidsonroids.calculator.main.MainPresenterImpl;
import pl.droidsonroids.calculator.main.MainView;

@Module
public class MainModule {

	private final MainView mainView;

	public MainModule(MainView mainView) {
		this.mainView = mainView;
	}

	@Provides
	MainView provideMainView() {
		return mainView;
	}

	@Provides
	MainPresenter provideMainPresenter(Calculator calculator, MainView mainView) {
		return new MainPresenterImpl(calculator, mainView);
	}
}
