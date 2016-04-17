package com.yoy.weatherclock.weather;

import android.util.Log;

import com.yoy.weatherclock.bean.Weather;
import com.yoy.weatherclock.utils.OkHttpUtils;
import com.yoy.weatherclock.utils.Service;
import com.yoy.weatherclock.utils.ServiceClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/3/20.
 */
public class WeatherInfoModel implements IWeatherInfoModel {



    @Override
    public void loadWeatherInfo(final OnFinishedListener listener) {
        String url = String.format(OkHttpUtils.BASE_URL,101020100);
        OkHttpUtils.getInstance().get(url, new OkHttpUtils.Callback() {
            @Override
            public void onSuccess(okhttp3.Call call, Weather weather) throws IOException {
                listener.onFinished(weather);

            }

            @Override
            public void onError(okhttp3.Call call, IOException e) {
                listener.onFailuer();

            }


        });
        /*
        Log.i("123","thread id1:"+Thread.currentThread().getId());
        Call<String> call = ServiceClient.getInstance().getWeather("101020100");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Log.i("123","thread id2:"+Thread.currentThread().getId());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("123", "thread id3:" + Thread.currentThread().getId());
                Log.i("123", "msg:" + t.getMessage());
            }
        });*/
    }


}
