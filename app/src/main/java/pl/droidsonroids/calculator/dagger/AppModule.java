package pl.droidsonroids.calculator.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.calculator.data.Calculator;

@Module
public class AppModule {

	@Provides
	@Singleton
	public Calculator provideCalculator() {
		return new Calculator();
	}
}
