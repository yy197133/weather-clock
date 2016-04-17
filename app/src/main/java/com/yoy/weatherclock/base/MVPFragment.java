package com.yoy.weatherclock.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/17.
 */
public abstract class MVPFragment<V extends IMVPView,P extends MVPPresenter<V>> extends Fragment{

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    public abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }
}
