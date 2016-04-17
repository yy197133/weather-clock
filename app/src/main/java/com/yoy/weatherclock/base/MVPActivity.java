package com.yoy.weatherclock.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2016/4/17.
 */
public abstract class MVPActivity<V,T extends MVPPresenter> extends BaseActivity {


    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    @NonNull
    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
