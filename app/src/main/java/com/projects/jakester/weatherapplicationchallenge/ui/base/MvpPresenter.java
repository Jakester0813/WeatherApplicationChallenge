package com.projects.jakester.weatherapplicationchallenge.ui.base;

/**
 * Created by Jake on 2/21/2018.
 */

public interface MvpPresenter<V extends IBaseView> {

    void onAttach(V mvpView);

    void onDetach();
}
