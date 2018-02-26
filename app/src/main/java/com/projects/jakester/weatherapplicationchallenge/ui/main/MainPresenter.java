package com.projects.jakester.weatherapplicationchallenge.ui.main;

import android.net.Uri;

import com.projects.jakester.weatherapplicationchallenge.data.model.WeatherResponse;
import com.projects.jakester.weatherapplicationchallenge.data.network.WeatherNetworkService;
import com.projects.jakester.weatherapplicationchallenge.data.prefs.WeatherPrefsManager;
import com.projects.jakester.weatherapplicationchallenge.ui.base.BasePresenter;
import com.projects.jakester.weatherapplicationchallenge.ui.base.MvpPresenter;
import com.projects.jakester.weatherapplicationchallenge.util.WeatherConstants;
import com.projects.jakester.weatherapplicationchallenge.util.listeners.WeatherListener;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;

/**
 * Created by Jake on 2/22/2018.
 */

public class MainPresenter<V extends MainActivityContract.View> extends BasePresenter<V>
             implements MainActivityContract.Presenter<V>{


    WeatherPrefsManager mPrefs;
    WeatherNetworkService mService;

    @Inject
    MainPresenter(WeatherPrefsManager pPrefs, WeatherNetworkService pService){
        mPrefs = pPrefs;
        mService = pService;
    }


    @Override
    public void getWeather(String location) {
        mPrefs.setWeatherLocation(location);
    }

    @Override
    public void getWeatherData() {

        mService.getWeatherDetails(mPrefs.getWeatherLocation(), new WeatherListener() {
            @Override
            public void onError(String message) {
                if(message.contains("404")){
                    message = WeatherConstants.LOCATION_NOT_FOUND;
                }
                else if(message.contains("408")){
                    message = WeatherConstants.TIMED_OUT;
                }
                mView.showError(message);
            }

            @Override
            public void onResponse(WeatherResponse response) {
                mView.setData(response);
                mView.hideLoading();
                StringBuilder imageUrl = new StringBuilder(WeatherConstants.IMAGE_URL)
                        .append(response.getWeatherObjects().get(0).getIcon())
                        .append(WeatherConstants.PNG_EXTENSION);
                mView.loadImage(imageUrl.toString());
            }
        });

    }


    @Override
    public boolean checkIfPrefsContainsValue() {
        return mPrefs.getIfPrefsContainsPrefs();
    }

    @Override
    public String getWeatherLocationPrefs() {
        return mPrefs.getWeatherLocation();
    }

    @Override
    public String convertKelvinToFahrenheit(Double kelvin) {
        return Long.toString(Math.round((9/5) * (kelvin-273) + 32));
    }

    @Override
    public String getTemperature(double temperature) {
        StringBuilder temperatureString = new StringBuilder();
        temperatureString.append(convertKelvinToFahrenheit(temperature)).append("°F");
        return temperatureString.toString();
    }

    @Override
    public String getMinMaxString(double min, double max) {
        StringBuilder minMaxTempString = new StringBuilder();
        minMaxTempString.append(convertKelvinToFahrenheit(max)).append("°F")
                .append("/").append(convertKelvinToFahrenheit(min)).append("°F");
        return minMaxTempString.toString();
    }

    @Override
    public String getLocation(String location) {

        StringBuilder dayLocationString = new StringBuilder();
        dayLocationString.append(WeatherConstants.TODAY_WEATHER).append(location);
        return dayLocationString.toString();
    }

    @Override
    public boolean isInputAZipCode(String input) {
        return isParsableAsInt(input) && input.length() == 5;
    }

    @Override
    public boolean isInputACity(String input) {
        return input.matches("[ a-zA-Z]+");
    }

    private boolean isParsableAsInt(String input){
        try{
            Integer.valueOf(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public void unsubscribeRx() {
        mService.unsubscribe();
    }

}
