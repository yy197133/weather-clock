package com.yoy.weatherclock.alarms;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yoy.weatherclock.R;
import com.yoy.weatherclock.weather.WeatherInfoActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/3/23.
 */
public class AlarmsActivity extends AppCompatActivity {


    @Bind(R.id.alarms_weather_layout)
    RelativeLayout mWeatherLayout;

    @Bind(R.id.alarms_temperature)
    TextView mTempTv;

    @Bind(R.id.alarms_city)
    TextView mCityTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.alarms_weather_layout)
    void onWeatherLayoutClick(){
        Intent intent = new Intent(this, WeatherInfoActivity.class);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(
                    AlarmsActivity.this,mTempTv,"temperature").toBundle());
    }
}
