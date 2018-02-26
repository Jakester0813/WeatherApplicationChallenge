package com.projects.jakester.weatherapplicationchallenge.dagger.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.projects.jakester.weatherapplicationchallenge.dagger.AppContext;
import com.projects.jakester.weatherapplicationchallenge.data.network.WeatherNetworkService;
import com.projects.jakester.weatherapplicationchallenge.data.network.interfaces.WeatherAPI;
import com.projects.jakester.weatherapplicationchallenge.data.prefs.WeatherPrefsManager;
import com.projects.jakester.weatherapplicationchallenge.util.APIUtility;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jake on 2/21/2018.
 */

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @AppContext
    public Context provideContext(){
        return mApplication.getApplicationContext();
    }

}
