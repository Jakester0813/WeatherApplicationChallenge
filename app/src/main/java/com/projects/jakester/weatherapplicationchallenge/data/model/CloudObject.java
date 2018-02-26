package com.projects.jakester.weatherapplicationchallenge.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 2/22/2018.
 */

public class CloudObject {

    @SerializedName("all")
    long all;

    public long getAll(){
        return all;
    }

}
