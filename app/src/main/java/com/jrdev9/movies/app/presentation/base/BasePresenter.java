package com.jrdev9.movies.app.presentation.base;


import android.support.annotation.NonNull;

import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjector;

public abstract class BasePresenter<V> {

    private final AppViewInjector appViewInjector;
    private V view;

    public BasePresenter(AppViewInjector appViewInjector) {
        this.appViewInjector = appViewInjector;
    }

    public void attachView(@NonNull V view) {
        this.view = appViewInjector.injectView(view);
        onViewAttached();
    }

    public void detachView() {
        this.view = appViewInjector.nullObjectPatternView(view);
    }

    public V getView() {
        return view;
    }

    protected abstract void onViewAttached();
}