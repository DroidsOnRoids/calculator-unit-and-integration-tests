package pl.droidsonroids.calculator.dagger.main;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.calculator.data.Calculator;
import pl.droidsonroids.calculator.main.MainPresenter;
import pl.droidsonroids.calculator.main.MainView;

import static org.mockito.Mockito.mock;

@Module
public class TestMainModule {

    @Provides
    MainView provideMainView() {
        return mock(MainView.class);
    }

    @Provides
    MainPresenter provideMainPresenter(Calculator calculator, MainView mainView) {
        return mock(MainPresenter.class);
    }

}
