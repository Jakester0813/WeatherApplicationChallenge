package com.projects.jakester.weatherapplicationchallenge.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.projects.jakester.weatherapplicationchallenge.util.WeatherConstants;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Jake on 2/21/2018.
 */

public class WeatherPrefsManager {
    SharedPreferences mWeatherPrefs;

    public WeatherPrefsManager(Context context){
        mWeatherPrefs = context.getSharedPreferences(WeatherConstants.PREFS_NAME, MODE_PRIVATE);
    }

    public void setWeatherLocation(String location){
        mWeatherPrefs.edit().putString(WeatherConstants.LOCATION_PREFS, location).commit();
    }

    public boolean getIfPrefsContainsPrefs(){
        return mWeatherPrefs.contains(WeatherConstants.LOCATION_PREFS);
    }

    public String getWeatherLocation(){
        return mWeatherPrefs.getString(WeatherConstants.LOCATION_PREFS,"");
    }
}
