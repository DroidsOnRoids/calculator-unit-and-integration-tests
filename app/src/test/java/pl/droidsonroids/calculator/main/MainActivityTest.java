package pl.droidsonroids.calculator.main;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import pl.droidsonroids.calculator.BuildConfig;
import pl.droidsonroids.calculator.R;
import pl.droidsonroids.calculator.TestCalculatorApplication;
import pl.droidsonroids.calculator.data.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCalculatorApplication.class)
public class MainActivityTest {

	private MainActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = Robolectric.setupActivity(MainActivity.class);
		verify(activity.presenter).init();
	}

	@Test
	public void testShowingResult() throws Exception {
		EditText result = (EditText) activity.findViewById(R.id.result_editText);
		activity.showResult(12f);
		assertThat(result.getText().toString()).isEqualTo("12.0");
	}

	@Test
	public void testShowingError() throws Exception {
		EditText result = (EditText) activity.findViewById(R.id.result_editText);
		activity.showError();
		assertThat(result.getText().toString()).isEqualTo("Error!");
	}

	@Test
	public void testOnOkButtonClicked() throws Exception {
		activity.onOkButtonClicked();
		verify(activity.presenter).makeCalculation("", "", Calculator.Sign.PLUS);
	}

}
