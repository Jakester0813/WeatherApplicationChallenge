package com.projects.jakester.weatherapplicationchallenge.ui.base;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by Jake on 2/22/2018.
 */

public class BasePresenter<V extends IBaseView> implements MvpPresenter<V> {

    public V mView;
    public Context context;

    @Inject
    public BasePresenter(){

    }

    @Override
    public void onAttach(V mvpView) {
        mView = mvpView;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext(){
        return context;
    }
}
