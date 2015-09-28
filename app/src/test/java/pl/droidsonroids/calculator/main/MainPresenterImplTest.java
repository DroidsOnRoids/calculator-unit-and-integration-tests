package pl.droidsonroids.calculator.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.droidsonroids.calculator.data.Calculator;
import pl.droidsonroids.calculator.data.Calculator.Sign;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterImplTest {

	@Mock Calculator calculator;
	@Mock MainView view;
	@Mock Subscription subscription;

	@InjectMocks MainPresenterImpl presenter;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAdditionSuccess() throws Exception {
		when(calculator.calculate("1", "1", Sign.PLUS)).thenReturn(Observable.just(2.0f));
		presenter.makeCalculation("1", "1", Sign.PLUS);
		verify(view).showResult(2.0f);
	}

	@Test (expected = NumberFormatException.class)
	public void testTextInsteadOfNumber() throws Exception {
		when(calculator.calculate("abc", "def", Sign.PLUS)).thenThrow(new NumberFormatException());
		presenter.makeCalculation("abc", "def", Sign.PLUS);
		verify(view).showError();
	}

	@Test
	public void testInitAndDestroy() throws Exception {
		presenter.init();
		presenter.destroy();
		assertEquals(Subscriptions.empty(), presenter.subscription);
	}

}
