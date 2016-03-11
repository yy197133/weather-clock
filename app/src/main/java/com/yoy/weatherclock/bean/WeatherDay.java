package com.yoy.weatherclock.bean;

/**
 * Created by YoY on 2016/3/11.
 */
public class WeatherDay {

    private String date;

    private String highTemp;

    private String lowTemp;

    private DayNight day;

    private DayNight night;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public DayNight getDay() {
        return day;
    }

    public void setDay(DayNight day) {
        this.day = day;
    }

    public DayNight getNight() {
        return night;
    }

    public void setNight(DayNight night) {
        this.night = night;
    }
}
