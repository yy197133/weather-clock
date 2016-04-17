package com.yoy.weatherclock.base;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


public abstract class MVPPresenter<T> {

    protected Reference<T> mViewRef;    //view 接口类型的弱引用，防止内存泄露

    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }


    protected T getView(){
        return mViewRef == null ? null : mViewRef.get();
    }

    public boolean isViewAttach(){
        return mViewRef != null && mViewRef.get() != null;
    }


}
