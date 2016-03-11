package com.yoy.weatherclock.utils;

import android.util.Xml;

import com.yoy.weatherclock.bean.DayNight;
import com.yoy.weatherclock.bean.Environment;
import com.yoy.weatherclock.bean.Forecast;
import com.yoy.weatherclock.bean.Weather;
import com.yoy.weatherclock.bean.WeatherDay;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoY on 2016/3/11.
 */
public class XmlPullPaserUtils {

    private Weather weather = null;

    public  Weather paser(InputStream inputStream){

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(inputStream,"UTF-8");

            int type = parser.getEventType();
            while (type != XmlPullParser.END_DOCUMENT){
                switch (parser.getEventType()){
                    case XmlPullParser.START_DOCUMENT:
                        weather = new Weather();
                        break;
                    case XmlPullParser.START_TAG:
                        read(parser);
                        break;
                    default:
                        break;

                }
                type = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return weather;
    }

    private void read(XmlPullParser parser) throws IOException, XmlPullParserException {
        String name = parser.getName();
        switch (name) {
            case "city":
                weather.setCity(parser.nextText());
                break;
            case "updatetime":
                weather.setUpdateTime(parser.nextText());
                break;
            case "wendu":
                weather.setWendu(Integer.parseInt(parser.nextText()));
                break;
            case "fengli":
                weather.setFengli(parser.nextText());
                break;
            case "shidu":
                weather.setShidu(parser.nextText());
                break;
            case "fengxiang":
                weather.setFengxiang(parser.nextText());
                break;
            case "sunrise":
                weather.setSunrise(parser.nextText());
                break;
            case "sunset":
                weather.setSunset(parser.nextText());
                break;
            case "environment":
                weather.setEnvironment(readEnvironment(parser));
                break;
            case "forecast":
                weather.setForecast(readForecast(parser));
                break;
            case "zhishus":

                break;
            default:
                break;

        }
    }

    private Environment readEnvironment(XmlPullParser parser) throws IOException, XmlPullParserException {
        Environment environment = new Environment();
        while (parser.nextTag() != XmlPullParser.END_TAG) {
            String text = parser.nextText();
            switch (parser.getName()) {
                case "aqi":
                    environment.setAqi(Integer.parseInt(text));
                    break;
                case "pm25":
                    environment.setPm25(Integer.parseInt(text));
                    break;
                case "suggest":
                    environment.setSuggest(text);
                    break;
                case "quality":
                    environment.setQuality(text);
                    break;
                case "MajorPollutants":
                    environment.setMajorPollutants(text);
                    break;
                case "o3":
                    environment.setO3(Integer.parseInt(text));
                    break;
                case "co":
                    environment.setCo(Integer.parseInt(text));
                    break;
                case "pm10":
                    environment.setPm10(Integer.parseInt(text));
                    break;
                case "so2":
                    environment.setSo2(Integer.parseInt(text));
                    break;
                case "no2":
                    environment.setNo2(Integer.parseInt(text));
                    break;
                case "time":
                    environment.setTime(text);
                    break;
                default:
                    break;
            }
        }
            return environment;
    }

    private Forecast readForecast(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG,null,"forecast");
        Forecast forecast = new Forecast();
        List<WeatherDay> weatherDays = new ArrayList();
        while (parser.nextTag() != XmlPullParser.END_TAG){
            weatherDays.add(readWeatherDay(parser));
        }
        parser.require(XmlPullParser.END_TAG,null,"forecast");
        forecast.setForecasts(weatherDays);
        return null;
    }

    private WeatherDay readWeatherDay(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG,null,"weather");
        WeatherDay weatherDay = new WeatherDay();
        while (parser.nextTag() != XmlPullParser.END_TAG){
            String name = parser.getName();
            switch (name){
                case "date":
                    weatherDay.setDate(parser.nextText());
                    break;
                case "high":
                    weatherDay.setHighTemp(parser.nextText());
                    break;
                case "low":
                    weatherDay.setLowTemp(parser.nextText());
                    break;
                case "day":
                    weatherDay.setDay(readDayNight(parser));
                    break;
                case "night":
                    weatherDay.setNight(readDayNight(parser));
                    break;
                default:
                    break;
            }

        }
        parser.require(XmlPullParser.END_TAG,null,"weather");
        return weatherDay;

    }

    private DayNight readDayNight(XmlPullParser parser) throws IOException, XmlPullParserException {
        DayNight dayNight = new DayNight();
        while (parser.nextTag() != XmlPullParser.END_TAG){
            String text = parser.nextText();
            switch (parser.getName()){
                case "type":
                    dayNight.setType(text);
                    break;
                case "fengxiang":
                    dayNight.setFengxiang(text);
                    break;
                case "fengli":
                    dayNight.setFengli(text);
            }
        }
        return dayNight;
    }
}
