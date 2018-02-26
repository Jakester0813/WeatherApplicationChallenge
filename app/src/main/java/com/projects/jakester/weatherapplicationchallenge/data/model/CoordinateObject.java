package com.projects.jakester.weatherapplicationchallenge.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 2/22/2018.
 */

public class CoordinateObject {

    @SerializedName("lon")
    double lon;

    @SerializedName("lat")
    double lat;

    public double getLon(){
        return lon;
    }

    public double getLat(){
        return lat;
    }

}
