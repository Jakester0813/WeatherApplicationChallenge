package com.projects.jakester.weatherapplicationchallenge.dagger.component;

import com.projects.jakester.weatherapplicationchallenge.dagger.PerActivity;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.ActivityModule;
import com.projects.jakester.weatherapplicationchallenge.dagger.module.AppModule;
import com.projects.jakester.weatherapplicationchallenge.ui.base.BaseActivity;
import com.projects.jakester.weatherapplicationchallenge.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jake on 2/25/2018.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
