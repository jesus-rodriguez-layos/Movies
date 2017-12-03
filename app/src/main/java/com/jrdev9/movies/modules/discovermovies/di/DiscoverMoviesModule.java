package com.jrdev9.movies.modules.discovermovies.di;


import com.jrdev9.movies.app.di.modules.BaseActivityModule;
import com.jrdev9.movies.app.di.scopes.ActivityScope;
import com.jrdev9.movies.app.presentation.adapter.BaseAdapter;
import com.jrdev9.movies.modules.discovermovies.data.sources.DiscoverMoviesDataGateway;
import com.jrdev9.movies.modules.discovermovies.domain.gateways.DiscoverMoviesGateway;
import com.jrdev9.movies.modules.discovermovies.presentation.DiscoverMoviesActivity;
import com.jrdev9.movies.modules.discovermovies.presentation.adapters.DiscoverMoviesViewHolderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class DiscoverMoviesModule extends BaseActivityModule<DiscoverMoviesActivity> {

    @Provides
    @ActivityScope
    public DiscoverMoviesGateway provideDiscoverMoviesGateway(DiscoverMoviesDataGateway gateway) {
        return gateway;
    }

    @Provides
    @ActivityScope
    public BaseAdapter provideDiscoverMoviesAdapter(DiscoverMoviesViewHolderFactory factory) {
        return new BaseAdapter(factory);
    }
}
