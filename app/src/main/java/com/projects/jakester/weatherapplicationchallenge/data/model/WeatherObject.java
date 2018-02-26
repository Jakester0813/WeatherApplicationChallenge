package com.projects.jakester.weatherapplicationchallenge.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 2/22/2018.
 */

public class WeatherObject {

    @SerializedName("id")
    int id;

    @SerializedName("main")
    String main;

    @SerializedName("description")
    String description;

    @SerializedName("icon")
    String icon;

    public int getId(){
        return id;
    }

    public String getMain(){
        return main;
    }

    public String getDescription(){
        return description;
    }

    public String getIcon(){
        return icon;
    }
}
