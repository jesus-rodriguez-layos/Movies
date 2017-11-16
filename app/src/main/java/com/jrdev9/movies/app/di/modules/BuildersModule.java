package com.jrdev9.movies.app.di.modules;


import com.jrdev9.movies.app.di.scopes.ActivityScope;
import com.jrdev9.movies.modules.discovermovies.di.DiscoverMoviesModule;
import com.jrdev9.movies.modules.discovermovies.presentation.DiscoverMoviesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {DiscoverMoviesModule.class})
    @ActivityScope
    public abstract DiscoverMoviesActivity contributeDiscoverMoviesActivityInjector();
}
