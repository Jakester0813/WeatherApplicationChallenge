package com.projects.jakester.weatherapplicationchallenge.util;

import android.app.Activity;
import android.graphics.Bitmap;

import com.projects.jakester.weatherapplicationchallenge.util.listeners.ImageListener;
import com.projects.jakester.weatherapplicationchallenge.util.listeners.WeatherListener;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jakester on 2/18/2017.
 */

public class HelperMethods {

    private static HelperMethods helperInstance;
    //RequestQueue queue;

    private HelperMethods() {
        //queue = Volley.newRequestQueue(activity);
    }

    //Creates the url given the passed in city, region, country
    public static String getLocationUrl(String input) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder(WeatherConstants.WEATHER_URL);
        input = input.replaceAll("\\s","");
        url.append(input);
        url.append(WeatherConstants.APP_ID_QUERY).append(WeatherConstants.API_KEY);
        //Have to encode urls to accomidate spaces
        return url.toString();
    }

    //Convert temperature to farenheit for the sake of inputting the tempurature
    public static int convertKelvinToFahernheit(int tempKelvin){
        int fahernheit = ((tempKelvin - 273) * (9/5)) + 32;
        return fahernheit;
    }

    //Convert temperature to celsius from Kelvin
    public static int convertKelvinToCelsius(int tempKelvin){
        int celsius = tempKelvin - 273;
        return celsius;
    }

    public static String getTodayDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE MM/dd");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        return dayOfTheWeek;
    }

    public static void makeNetworkCall(String url, final WeatherListener listener) {
        /*StringRequest stringRequest = new StringRequest
                (Method.GET, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.toString());
                    }
                }) {

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String jsonString = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers, "UTF-8"));
                    return Response.success(new String(jsonString),
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };

        // Access the RequestQueue through singleton class.
        queue.add(stringRequest);*/
    }

    //Makes the image call using volley
    public static void getImage(String url, final ImageListener listener){
        /*ImageRequest ir = new ImageRequest(url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        listener.onResponse(response);
            }
        }, 0, 0, null, null, null);
        queue.add(ir);*/
    }
}
