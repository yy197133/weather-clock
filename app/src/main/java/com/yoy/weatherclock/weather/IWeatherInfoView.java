package com.yoy.weatherclock.weather;

import com.yoy.weatherclock.base.IMVPView;
import com.yoy.weatherclock.bean.Weather;

/**
 * Created by Administrator on 2016/3/20.
 */
public interface IWeatherInfoView extends IMVPView{

    void showProgress();

    void hideProgress();

    void showData(Weather weather);
}
