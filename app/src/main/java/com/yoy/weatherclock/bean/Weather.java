package com.yoy.weatherclock.bean;

import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by YoY on 2016/3/11.
 */
@Root
public class Weather {

    private String city;

    private String updateTime;

    private int wendu;

    private String fengli;

    private String shidu;

    private String fengxiang;

    private String sunrise;

    private String sunset;

    private Environment environment;

    private List<WeatherDay> forecast;

    private List<Zhishu> zhishus;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getWendu() {
        return wendu;
    }

    public void setWendu(int wendu) {
        this.wendu = wendu;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public List<WeatherDay> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherDay> forecast) {
        this.forecast = forecast;
    }

    public List<Zhishu> getZhishus() {
        return zhishus;
    }

    public void setZhishus(List<Zhishu> zhishus) {
        this.zhishus = zhishus;
    }
}
