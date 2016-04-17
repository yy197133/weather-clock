package com.yoy.weatherclock.weather;

import com.yoy.weatherclock.base.MVPPresenter;
import com.yoy.weatherclock.bean.Weather;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WeatherInfoPresenter extends MVPPresenter<IWeatherInfoView> implements IWeatherInfoPresenter,IWeatherInfoModel.OnFinishedListener{


    private WeatherInfoModel mModel;


    public WeatherInfoPresenter(){
        mModel = new WeatherInfoModel();
    }



    @Override
    public void loadWeatherInfo() {
        if(isViewAttach()){
            getView().showProgress();
        }
        mModel.loadWeatherInfo(this);
    }

    @Override
    public void onFinished(Weather weather) {
        if(isViewAttach()){
            getView().hideProgress();
            getView().showData(weather);

        }

    }

    @Override
    public void onFailuer() {

    }
}
