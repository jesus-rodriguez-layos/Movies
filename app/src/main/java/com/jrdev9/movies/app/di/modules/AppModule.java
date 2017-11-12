package com.jrdev9.movies.app.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }
}
