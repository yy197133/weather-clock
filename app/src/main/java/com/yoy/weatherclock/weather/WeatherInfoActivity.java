package com.yoy.weatherclock.weather;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yoy.weatherclock.R;
import com.yoy.weatherclock.base.BaseAcitvity;
import com.yoy.weatherclock.bean.Weather;
import com.yoy.weatherclock.bean.WeatherDay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WeatherInfoActivity extends BaseAcitvity implements IWeatherInfoView {

    private Context mContext;

    private WeatherInfoPresenter mPresenter;
    private ProgressDialog mProgress;

    @Bind(R.id.weather_info_temp)
    TextView mTempTv;

    @Bind(R.id.weather_info_city)
    TextView mCityTv;

    @Bind(R.id.weather_info_forecast)
    LinearLayout mForecastLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        ButterKnife.bind(this);
        mContext = this;

        mProgress = new ProgressDialog(mContext);
        mProgress.setMessage("正在加载中...");

        mPresenter = new WeatherInfoPresenter(this);
        mPresenter.loadWeatherInfo();
    }

    @Override
    public void showProgress() {
        mProgress.show();
    }

    @Override
    public void hideProgress() {
        mProgress.dismiss();
    }

    @Override
    public void showData(Weather weather) {
        mTempTv.setText(String.format(getString(R.string.temperature), weather.getWendu()));
        mCityTv.setText(weather.getCity());

        for(int i=0;i<weather.getForecast().size();i++){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_forecast,null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            view.setLayoutParams(params);
            TextView dayView = (TextView) view.findViewById(R.id.item_forecast_day);
            TextView weatherView = (TextView) view.findViewById(R.id.item_forecast_weather);
            TextView tempView = (TextView) view.findViewById(R.id.item_forecast_temp);
            WeatherDay weatherDay = weather.getForecast().get(i);
            dayView.setText(i==0?"今天":weatherDay.getDate().substring(3));
            weatherView.setText(weatherDay.getDay().getType());
            tempView.setText(weatherDay.getHighTemp().substring(2)+"/"+weatherDay.getLowTemp().substring(2));
            mForecastLinear.addView(view);
        }
    }


    private String getNum(String str){
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return matcher.group();
        }
        return "";
    }
}
