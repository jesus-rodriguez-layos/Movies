package com.jrdev9.movies.app.di.modules;

import android.app.Application;
import android.content.Context;

import com.jrdev9.movies.app.commons.outputs.BackThreadSpec;
import com.jrdev9.movies.app.commons.outputs.MainThreadSpec;
import com.jrdev9.movies.app.commons.outputs.SameThreadSpec;
import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjector;
import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjectorImpl;
import com.jrdev9.movies.app.di.qualifiers.BackThread;
import com.jrdev9.movies.app.di.qualifiers.SameThread;
import com.jrdev9.movies.app.di.qualifiers.UiThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public AppViewInjector provideAppViewInjector() {
        return new AppViewInjectorImpl(new MainThreadSpec());
    }

    @Provides
    @Singleton
    @UiThread
    public ThreadSpec provideMainThread() {
        return new MainThreadSpec();
    }

    @Provides
    @Singleton
    @SameThread
    public ThreadSpec provideSameThread() {
        return new SameThreadSpec();
    }

    @Provides
    @Singleton
    @BackThread
    public ThreadSpec provideBackThread() {
        return new BackThreadSpec();
    }
}
