package com.projects.jakester.weatherapplicationchallenge.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 2/22/2018.
 */

public class WindObject {

    @SerializedName("speed")
    double speed;

    @SerializedName("deg")
    double deg;

    public double getSpeed(){
        return speed;
    }

    public double getDeg(){
        return deg;
    }

}
