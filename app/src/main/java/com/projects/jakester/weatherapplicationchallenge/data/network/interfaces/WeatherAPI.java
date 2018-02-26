package com.projects.jakester.weatherapplicationchallenge.data.network.interfaces;

import com.projects.jakester.weatherapplicationchallenge.data.model.WeatherResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jake on 2/22/2018.
 */

public interface WeatherAPI {

    @GET("data/2.5/weather")
    Observable<WeatherResponse> getWeather(@Query("q") String query, @Query("APPID") String appId);
}
