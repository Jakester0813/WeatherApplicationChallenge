package com.projects.jakester.weatherapplicationchallenge.dagger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.projects.jakester.weatherapplicationchallenge.dagger.ActivityContext;
import com.projects.jakester.weatherapplicationchallenge.dagger.PerActivity;
import com.projects.jakester.weatherapplicationchallenge.data.network.WeatherNetworkService;
import com.projects.jakester.weatherapplicationchallenge.data.network.interfaces.WeatherAPI;
import com.projects.jakester.weatherapplicationchallenge.data.prefs.WeatherPrefsManager;
import com.projects.jakester.weatherapplicationchallenge.ui.main.MainActivityContract;
import com.projects.jakester.weatherapplicationchallenge.ui.main.MainPresenter;
import com.projects.jakester.weatherapplicationchallenge.util.APIUtility;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jake on 2/21/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mCompatActivity;

    public ActivityModule(AppCompatActivity activity) { this.mCompatActivity = activity; }

    /*
     * Given more time, I would have looked for a way to have WeatherPrefsManager, WeatherAPI,
     * and WeatherNetworkService declared and have provide methods declared in AppModule and
     * being able to inject them in Main Presenter, but for the interest of time, I had to put them on here.
     */


    private WeatherPrefsManager mPrefs;

    private WeatherAPI mService;

    private WeatherNetworkService mNetworkService;

    WeatherPrefsManager getPrefsInstance(Context context){
        if(mPrefs == null){
            mPrefs = new WeatherPrefsManager(context);
        }

        return mPrefs;
    }

    WeatherAPI getServiceInstance(){
        if(mService == null){
            mService = APIUtility.getService();
        }
        return mService;
    }

    WeatherNetworkService getNetworkInstance(){
        if(mNetworkService == null){
            mNetworkService = new WeatherNetworkService(getServiceInstance());
        }
        return mNetworkService;
    }

    @Provides
    @ActivityContext
    Context provideContext() { return mCompatActivity; }

    @Provides
    AppCompatActivity provideActivity() { return mCompatActivity; }

    @Provides
    @PerActivity
    WeatherPrefsManager providesWeatherPrefs(AppCompatActivity activity) { return getPrefsInstance(activity.getApplicationContext());}

    @Provides
    @PerActivity
    WeatherNetworkService providesWeatherNetworkService() {
        return getNetworkInstance();
    }

    @Provides
    @PerActivity
    MainActivityContract.Presenter<MainActivityContract.View> provideMainPresneter
            (MainPresenter<MainActivityContract.View> presenter){
        return presenter;
    }
}
