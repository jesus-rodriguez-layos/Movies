package com.jrdev9.movies.app.di.components;

import android.app.Application;

import com.jrdev9.movies.app.di.modules.AppModule;
import com.jrdev9.movies.app.presentation.MoviesApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                AppModule.class
        }
)
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MoviesApplication app);
}
