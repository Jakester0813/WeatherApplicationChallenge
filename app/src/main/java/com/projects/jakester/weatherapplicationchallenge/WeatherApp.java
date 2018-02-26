package com.projects.jakester.weatherapplicationchallenge;

import android.app.Application;

import com.projects.jakester.weatherapplicationchallenge.dagger.component.AppComponent;
import com.projects.jakester.weatherapplicationchallenge.dagger.component.DaggerAppComponent;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.ActivityModule;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.AppModule;
import com.projects.jakester.weatherapplicationchallenge.data.network.WeatherNetworkService;
import com.projects.jakester.weatherapplicationchallenge.data.prefs.WeatherPrefsManager;

import javax.inject.Inject;

/**
 * Created by Jake on 2/25/2018.
 */

public class WeatherApp extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() { return mAppComponent; }
}
