package pl.droidsonroids.calculator.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.calculator.data.Calculator;

import static org.mockito.Mockito.mock;

@Module
public class TestAppModule {

	@Provides
	@Singleton
	public Calculator provideCalculator() {
		return mock(Calculator.class);
	}
}
