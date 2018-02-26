package com.projects.jakester.weatherapplicationchallenge.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 2/22/2018.
 */

public class SysObject {

    @SerializedName("message")
    double message;

    @SerializedName("country")
    String country;

    @SerializedName("sunrise")
    long sunrise;

    @SerializedName("sunset")
    long sunset;

    public double getMessage(){
        return message;
    }

    public String getCountry(){
        return country;
    }

    public long getSunrise(){
        return sunrise;
    }

    public long getSunset(){
        return sunset;
    }
}
