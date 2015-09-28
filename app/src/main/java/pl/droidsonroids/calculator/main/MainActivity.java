package pl.droidsonroids.calculator.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.calculator.CalculatorApplication;
import pl.droidsonroids.calculator.R;

public class MainActivity extends AppCompatActivity implements MainView {

	@Bind(R.id.first_editText) EditText firstEditText;
	@Bind(R.id.second_editText) EditText secondEditText;
	@Bind(R.id.result_editText) EditText resultEditText;
	@Bind(R.id.spinner) Spinner spinner;

	@Inject MainPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		ButterKnife.bind(this);
		CalculatorApplication.getInstance().getMainGraph(this).inject(this);
		presenter.init();
		initSpinner();
	}

	private void initSpinner() {
		ArrayAdapter<CharSequence> adapter =
				ArrayAdapter.createFromResource(this, R.array.chars, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}

	@Override
	public void showResult(float result) {
		resultEditText.setText(String.valueOf(result));
	}

	@Override
	public void showError() {
		resultEditText.setText("Error!");
	}

	@OnClick(R.id.ok_button)
	public void onOkButtonClicked() {
		presenter.makeCalculation(firstEditText.getText().toString(),
				secondEditText.getText().toString(),
				spinner.getSelectedItem().toString());
	}

	@Override
	protected void onDestroy() {
		presenter.destroy();
		super.onDestroy();
	}
}
