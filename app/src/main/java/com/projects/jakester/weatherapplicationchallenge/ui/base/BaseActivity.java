package com.projects.jakester.weatherapplicationchallenge.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.projects.jakester.weatherapplicationchallenge.WeatherApp;
import com.projects.jakester.weatherapplicationchallenge.dagger.component.ActivityComponent;
import com.projects.jakester.weatherapplicationchallenge.dagger.component.DaggerActivityComponent;
import com.projects.jakester.weatherapplicationchallenge.dagger.component.DaggerAppComponent;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.ActivityModule;

/**
 * Created by Jake on 2/25/2018.
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {

    public ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((WeatherApp)getApplication()).getAppComponent())
                .build();
        //mActivityComponent.inject(this);
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
