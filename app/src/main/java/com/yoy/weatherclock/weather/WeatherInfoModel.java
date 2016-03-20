package com.yoy.weatherclock.weather;

import com.yoy.weatherclock.bean.Weather;
import com.yoy.weatherclock.utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WeatherInfoModel implements IWeatherInfoModel {



    @Override
    public void loadWeatherInfo(final OnFinishedListener listener) {
        String url = OkHttpUtils.BASE_URL + 101020100;
        OkHttpUtils.getInstance().get(url, new OkHttpUtils.Callback() {
            @Override
            public void onSuccess(Call call, Weather weather) throws IOException {
                listener.onFinished(weather);
            }

            @Override
            public void onError(Call call, IOException e) {
                listener.onFailuer();
            }
        });
    }


}
