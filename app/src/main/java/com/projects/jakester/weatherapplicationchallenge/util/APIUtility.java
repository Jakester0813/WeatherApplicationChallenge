package com.projects.jakester.weatherapplicationchallenge.util;

import com.projects.jakester.weatherapplicationchallenge.data.network.WeatherClient;
import com.projects.jakester.weatherapplicationchallenge.data.network.interfaces.WeatherAPI;

/**
 * Created by Jake on 2/23/2018.
 */

public class APIUtility {

    public static WeatherAPI getService() {
        return WeatherClient.getClient().create(WeatherAPI.class);
    }

}
