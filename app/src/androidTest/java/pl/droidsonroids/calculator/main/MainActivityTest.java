package pl.droidsonroids.calculator.main;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import org.mockito.Mock;

import pl.droidsonroids.calculator.R;
import pl.droidsonroids.calculator.data.Calculator;
import pl.droidsonroids.calculator.data.Calculator.Sign;
import pl.droidsonroids.calculator.main.MainActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getActivity();
	}

	public void testAdditionSuccess() {
		onView(ViewMatchers.withId(R.id.first_editText)).perform(typeText("1"));
		onView(withId(R.id.second_editText)).perform(typeText("1"));
		onView(withId(R.id.spinner)).perform(click());
		onData(allOf(is(instanceOf(String.class)), is(Sign.PLUS))).perform(click());
		onView(withId(R.id.ok_button)).perform(click());

		onView(withId(R.id.result_editText)).check(matches(withText("2.0")));
	}

	public void testInfinity() {
		onView(withId(R.id.first_editText)).perform(typeText("12"));
		onView(withId(R.id.second_editText)).perform(typeText("0"));
		onView(withId(R.id.spinner)).perform(click());
		onData(allOf(is(instanceOf(String.class)), is(Sign.DIVIDE))).perform(click());
		onView(withId(R.id.ok_button)).perform(click());

		onView(withId(R.id.result_editText)).check(matches(withText(String.valueOf(Float.POSITIVE_INFINITY))));
	}

	public void testNotANumber() {
		onView(withId(R.id.first_editText)).perform(typeText("0"));
		onView(withId(R.id.second_editText)).perform(typeText("0"));
		onView(withId(R.id.spinner)).perform(click());
		onData(allOf(is(instanceOf(String.class)), is(Sign.DIVIDE))).perform(click());
		onView(withId(R.id.ok_button)).perform(click());

		onView(withId(R.id.result_editText)).check(matches(withText(String.valueOf(Float.NaN))));

	}
}
