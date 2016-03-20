package com.yoy.weatherclock.weather;

import com.yoy.weatherclock.bean.Weather;

/**
 * Created by Administrator on 2016/3/20.
 */
public interface IWeatherInfoModel {

    void loadWeatherInfo(OnFinishedListener listener);

    interface OnFinishedListener{
        void onFinished(Weather weather);

        void onFailuer();
    }
}
