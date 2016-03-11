package com.yoy.weatherclock.utils;

import android.os.Handler;
import android.os.Looper;

import com.yoy.weatherclock.bean.Weather;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by YoY on 2016/3/10.
 */
public class OkHttpUtils {

    public static final String BASE_URL = "http://wthrcdn.etouch.cn/WeatherApi?citykey=%s";

    //饿汉单例
    private static OkHttpUtils mInstance = new OkHttpUtils();
    private OkHttpClient mClient;
    private Handler mHandler;

    private OkHttpUtils(){
        mClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpUtils getInstance(){
        return mInstance;
    }


    public void get(String url, final Callback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();

        mClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callback.onError(call,e);
//                    }
//                });
            }

            @Override
            public void onResponse(final Call call, final Response response) {
                XmlPullPaserUtils paserUtils = new XmlPullPaserUtils();
                Weather weather = paserUtils.paser(response.body().byteStream());
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            callback.onSuccess(call,response);
//                        } catch (IOException e) {
//                            callback.onError(call,e);
//                            e.printStackTrace();
//                        }
//                    }
//                });
            }
        });
    }


    public interface Callback {
        void onSuccess(Call call,Response response) throws IOException;
        void onError(Call call, IOException e);
    }



}
