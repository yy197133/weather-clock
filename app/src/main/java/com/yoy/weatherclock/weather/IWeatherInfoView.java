package com.yoy.weatherclock.weather;

import com.yoy.weatherclock.bean.Weather;

/**
 * Created by Administrator on 2016/3/20.
 */
public interface IWeatherInfoView {

    void showProgress();

    void hideProgress();

    void showData(Weather weather);
}
