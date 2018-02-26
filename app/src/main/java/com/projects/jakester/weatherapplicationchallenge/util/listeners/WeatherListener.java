package com.projects.jakester.weatherapplicationchallenge.util.listeners;

import com.projects.jakester.weatherapplicationchallenge.data.model.WeatherResponse;

/**
 * Created by Jakester on 2/22/2017.
 */

public interface WeatherListener {
    void onError(String message);

    void onResponse(WeatherResponse response);
}
