package com.jrdev9.movies.app.presentation;


import android.app.Activity;
import android.app.Application;

import com.jrdev9.movies.app.di.components.AppComponent;
import com.jrdev9.movies.app.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MoviesApplication extends Application implements HasActivityInjector {

    private static MoviesApplication instance;
    protected AppComponent appComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    public static MoviesApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        createComponentDI();
    }

    protected void createComponentDI() {
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
