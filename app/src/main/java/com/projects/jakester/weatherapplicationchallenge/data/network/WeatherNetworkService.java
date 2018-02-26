package com.projects.jakester.weatherapplicationchallenge.data.network;

import com.projects.jakester.weatherapplicationchallenge.data.model.WeatherResponse;
import com.projects.jakester.weatherapplicationchallenge.data.network.interfaces.WeatherAPI;
import com.projects.jakester.weatherapplicationchallenge.util.WeatherConstants;
import com.projects.jakester.weatherapplicationchallenge.util.listeners.WeatherListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Jake on 2/23/2018.
 */

public class WeatherNetworkService {

    WeatherAPI mAPIService;

    Subscription subscription;

    public WeatherNetworkService(WeatherAPI apiService){
        this.mAPIService = apiService;
    }

    public void getWeatherDetails(String query, final WeatherListener callback){
        mAPIService.getWeather(query, WeatherConstants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResponse>() {


                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherResponse weatherResponse) {
                        callback.onResponse(weatherResponse);
                    }
                });
    }

    public void unsubscribe(){
        if(subscription!=null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
