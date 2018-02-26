package com.projects.jakester.weatherapplicationchallenge.dagger.component;

import android.app.Application;

import com.projects.jakester.weatherapplicationchallenge.WeatherApp;
import com.projects.jakester.weatherapplicationchallenge.dagger.AppContext;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.ActivityModule;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.AppModule;
import com.projects.jakester.weatherapplicationchallenge.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Jake on 2/21/2018.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject (WeatherApp app);
}
