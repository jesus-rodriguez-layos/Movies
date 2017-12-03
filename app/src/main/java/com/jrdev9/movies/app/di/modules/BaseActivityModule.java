package com.jrdev9.movies.app.di.modules;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;

import com.jrdev9.movies.app.commons.threads.events.EventJobExecution;
import com.jrdev9.movies.app.di.qualifiers.ContextActivity;
import com.jrdev9.movies.app.di.qualifiers.UiThread;
import com.jrdev9.movies.app.di.scopes.ActivityScope;
import com.jrdev9.movies.app.presentation.base.BaseView;
import com.jrdev9.movies.app.presentation.imageloading.ImageTools;
import com.jrdev9.movies.app.presentation.imageloading.ImageToolsImpl;

import dagger.Module;
import dagger.Provides;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

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

    @Provides
    @ActivityScope
    public EventJobExecution provideEventJobExecution(@ContextActivity Context context, @UiThread ThreadSpec threadSpec) {
        return new EventJobExecution() {
            @Override
            public void beforeExecute() {
                threadSpec.execute(() -> ((BaseView) context).showLoading());
            }

            @Override
            public void afterExecute() {
                threadSpec.execute(() -> ((BaseView) context).hideLoading());
            }
        };
    }

    @Provides
    @ActivityScope
    public ImageTools provideImageLoading(ImageToolsImpl imageLoading) {
        return imageLoading;
    }
}