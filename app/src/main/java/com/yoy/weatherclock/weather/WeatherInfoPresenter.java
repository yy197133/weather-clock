package com.yoy.weatherclock.weather;

import com.yoy.weatherclock.bean.Weather;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WeatherInfoPresenter implements IWeatherInfoPresenter,IWeatherInfoModel.OnFinishedListener{


    private IWeatherInfoView mView;
    private WeatherInfoModel mModel;


    public WeatherInfoPresenter(IWeatherInfoView view){
        this.mView = view;
        mModel = new WeatherInfoModel();
    }



    @Override
    public void loadWeatherInfo() {
        if(mView != null){
            mView.showProgress();
        }
        mModel.loadWeatherInfo(this);
    }

    @Override
    public void onFinished(Weather weather) {
        if(mView != null){
            mView.hideProgress();
            mView.showData(weather);
        }

    }

    @Override
    public void onFailuer() {

    }
}
