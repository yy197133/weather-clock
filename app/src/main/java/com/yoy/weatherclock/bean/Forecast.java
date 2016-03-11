package com.yoy.weatherclock.bean;

import java.util.List;

/**
 * Created by YoY on 2016/3/11.
 */
public class Forecast {

    private List<WeatherDay> forecasts;

    public List<WeatherDay> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<WeatherDay> forecasts) {
        this.forecasts = forecasts;
    }
}
