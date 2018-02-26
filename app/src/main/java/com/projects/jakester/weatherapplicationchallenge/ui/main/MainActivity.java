package com.projects.jakester.weatherapplicationchallenge.ui.main;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.projects.jakester.weatherapplicationchallenge.WeatherApp;
import com.projects.jakester.weatherapplicationchallenge.dagger.component.AppComponent;
import com.projects.jakester.weatherapplicationchallenge.data.model.WeatherResponse;
import com.projects.jakester.weatherapplicationchallenge.ui.base.BaseActivity;
import com.projects.jakester.weatherapplicationchallenge.util.listeners.ImageListener;
import com.projects.jakester.weatherapplicationchallenge.util.listeners.WeatherListener;
import com.projects.jakester.weatherapplicationchallenge.R;
import com.projects.jakester.weatherapplicationchallenge.util.HelperMethods;
import com.projects.jakester.weatherapplicationchallenge.util.WeatherConstants;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainActivityContract.View{

    @BindView(R.id.et_weather)
    EditText mCitySearchEdit;

    @BindView(R.id.rl_progress_view)
    RelativeLayout mLoadingLayout;

    @BindView(R.id.rl_error_view)
    RelativeLayout mErrorLayout;

    @BindView(R.id.rl_weather_layout)
    RelativeLayout mWeatherLayout;

    @BindView(R.id.iv_weather)
    ImageView mWeatherIcon;

    @BindView(R.id.tv_error)
    TextView mErrorText;

    @BindView(R.id.tv_location)
    TextView locationText;

    @BindView(R.id.tv_temperature)
    TextView temperatureNowText;

    @BindView(R.id.tv_main_weather)
    TextView mainWeatherText;

    @BindView(R.id.tv_weather_description)
    TextView weatherDescriptionText;

    @BindView(R.id.tv_max_min)
    TextView minMaxText;

    @Inject
    MainPresenter<MainActivityContract.View> mPresenter;

    AppComponent mAppComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setToobar();
        mCitySearchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String input = v.getText().toString();
                    if(mPresenter.isInputACity(input) || mPresenter.isInputAZipCode(input)) {
                        mPresenter.getWeather(v.getText().toString());
                        loadPreviousCityAndSearch();
                    }
                    else{
                        showError("Your input is invalid. Perhaps enter a 5 digit zipcode or a city?");
                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Once the UI loads up, it's a good time to load up and execute the last search
        loadPreviousCityAndSearch();

    }

    //Sets up the toolbar
    private void setToobar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(myToolbar);
    }


    private void loadPreviousCityAndSearch(){
        if(mPresenter.checkIfPrefsContainsValue()){
            mCitySearchEdit.setText(mPresenter.getWeatherLocationPrefs());
            showLoading();
            mPresenter.getWeatherData();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribeRx();
    }

    @Override
    public void showLoading() {
        mWeatherLayout.setVisibility(View.GONE);
        mErrorLayout.setVisibility(View.GONE);
        mLoadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mWeatherLayout.setVisibility(View.VISIBLE);
        mLoadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        mErrorText.setText(error);
        mLoadingLayout.setVisibility(View.GONE);
        mErrorLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadImage(String url) {
        Glide.with(this).load(url).into(mWeatherIcon);
    }

    @Override
    public void setData(WeatherResponse response) {
        locationText.setText(mPresenter.getLocation(response.getName()));
        temperatureNowText.setText(mPresenter.getTemperature(response.getMain().getTemp()));
        mainWeatherText.setText(response.getWeatherObjects().get(0).getMain());
        weatherDescriptionText.setText(response.getWeatherObjects().get(0).getDescription());
        minMaxText.setText(mPresenter.getMinMaxString(response.getMain().getTempMin(), response.getMain().getTempMax()));
    }
}
