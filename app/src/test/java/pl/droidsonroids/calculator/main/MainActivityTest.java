package pl.droidsonroids.calculator.main;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import pl.droidsonroids.calculator.BuildConfig;
import pl.droidsonroids.calculator.R;
import pl.droidsonroids.calculator.TestCalculatorApplication;
import pl.droidsonroids.calculator.data.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCalculatorApplication.class)
public class MainActivityTest {

	private MainActivity activity;
	private EditText resultEditText;

	@Inject Calculator calculator;

	@Before
	public void setUp() throws Exception {
		activity = Robolectric.setupActivity(MainActivity.class);
		TestCalculatorApplication.getInstance().getMainGraph(null).inject(this);
		resultEditText = (EditText) activity.findViewById(R.id.result_editText);
	}

	@Test
	public void testShowingResult() throws Exception {
		float result = calculator.makeCalculation(13, 21, Calculator.Sign.PLUS);
		activity.showResult(result);
		assertThat(resultEditText.getText().toString()).isEqualTo(String.valueOf(result));
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
		assertThat(resultEditText.getText().toString()).isEqualTo("");
	}

}
