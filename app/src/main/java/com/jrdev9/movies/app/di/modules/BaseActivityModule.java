package com.jrdev9.movies.app.di.modules;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;

import com.jrdev9.movies.app.di.qualifiers.ContextActivity;
import com.jrdev9.movies.app.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule<T extends Activity> {

    @Provides
    @ActivityScope
    public FragmentManager provideFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }

    @Provides
    @ActivityScope
    public LayoutInflater provideLayoutInflater(T activity) {
        return LayoutInflater.from(activity);
    }

    @Provides
    @ActivityScope
    @ContextActivity
    public Context provideContext(T activity) {
        return activity;
    }
}