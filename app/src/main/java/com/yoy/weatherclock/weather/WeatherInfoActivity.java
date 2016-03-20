package com.yoy.weatherclock.weather;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.yoy.weatherclock.base.BaseAcitvity;
import com.yoy.weatherclock.bean.Weather;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WeatherInfoActivity extends BaseAcitvity implements IWeatherInfoView{


    private WeatherInfoPresenter mPresenter;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgress = new ProgressDialog(getApplicationContext());
        mProgress.setMessage("正在加载中...");

        mPresenter = new WeatherInfoPresenter(this);
        mPresenter.loadWeatherInfo();
    }

    @Override
    public void showProgress() {
        mProgress.show();
    }

    @Override
    public void hideProgress() {
        mProgress.dismiss();
    }

    @Override
    public void showData(Weather weather) {

    }
}
