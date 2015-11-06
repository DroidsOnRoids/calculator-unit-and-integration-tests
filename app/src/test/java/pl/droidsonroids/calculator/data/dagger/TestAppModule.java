package pl.droidsonroids.calculator.data.dagger;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.calculator.data.Calculator;

@Module
public class TestAppModule {

    @Provides
    @Singleton
    public Calculator provideCalculator() {
        return Mockito.mock(Calculator.class);
    }
}
