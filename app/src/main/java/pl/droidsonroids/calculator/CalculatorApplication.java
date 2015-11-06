package pl.droidsonroids.calculator;

import android.app.Application;

import pl.droidsonroids.calculator.dagger.AppGraph;
import pl.droidsonroids.calculator.dagger.main.MainGraph;
import pl.droidsonroids.calculator.main.MainView;

public class CalculatorApplication extends Application {

    private static CalculatorApplication sInstance;
    protected AppGraph appGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        appGraph = AppGraph.Initializer.init(this);
    }

    public static CalculatorApplication getInstance() {
        return sInstance;
    }


    public MainGraph getMainGraph(MainView view) {
        return MainGraph.Initializer.init(appGraph, view);
    }
}