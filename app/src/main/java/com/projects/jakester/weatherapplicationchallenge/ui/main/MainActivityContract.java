package com.projects.jakester.weatherapplicationchallenge.ui.main;

import com.projects.jakester.weatherapplicationchallenge.data.model.WeatherResponse;
import com.projects.jakester.weatherapplicationchallenge.ui.base.IBaseView;
import com.projects.jakester.weatherapplicationchallenge.ui.base.MvpPresenter;

/**
 * Created by Jake on 2/21/2018.
 */

public interface MainActivityContract {

    //Presenter interacts with the view via methods listed here
    interface View extends IBaseView{

        void loadImage(String url);

        void setData(WeatherResponse response);

        void showError(String message);
    }

    //view interacts with the presenter via methods listed here
    interface Presenter <V extends IBaseView> extends MvpPresenter<V>{
        void getWeather(String location);

        void getWeatherData();

        boolean checkIfPrefsContainsValue();

        String getWeatherLocationPrefs();

        String convertKelvinToFahrenheit(Double kelvin);

        String getTemperature(double temperature);

        String getMinMaxString (double min, double max);

        String getLocation(String location);

        boolean isInputAZipCode(String input);

        boolean isInputACity(String input);

        void unsubscribeRx();
    }
}
