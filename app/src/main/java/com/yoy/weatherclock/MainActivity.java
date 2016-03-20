package com.yoy.weatherclock;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yoy.weatherclock.bean.Weather;
import com.yoy.weatherclock.utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Log.i("123", "thread id" + Thread.currentThread().getId());


        int cityKey = 101020100;

        String url = String.format(OkHttpUtils.BASE_URL,cityKey);
        Log.i("123",url);
        OkHttpUtils.getInstance().get(url, new OkHttpUtils.Callback() {
            @Override
            public void onError(Call call, IOException e) {
                Log.i("123", "thread id" + Thread.currentThread().getId());
            }

            @Override
            public void onSuccess(Call call, Weather weather) throws IOException {
                Log.i("123", "thread id" + Thread.currentThread().getId());
                Log.i("123","city:"+weather.getCity()+"\n pm 25:"+weather.getEnvironment().getPm25()+" \n high:"+weather.getForecast().getForecasts().get(1).getHighTemp()+
                        "\n name:"+weather.getZhishus().getZhishus().get(0).getName());
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
