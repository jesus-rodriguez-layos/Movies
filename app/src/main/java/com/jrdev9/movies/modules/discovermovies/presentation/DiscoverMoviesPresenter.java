package com.jrdev9.movies.modules.discovermovies.presentation;

import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjector;
import com.jrdev9.movies.app.di.scopes.ActivityScope;
import com.jrdev9.movies.app.presentation.base.BasePresenter;

import javax.inject.Inject;

@ActivityScope
public class DiscoverMoviesPresenter extends BasePresenter<DiscoverMoviesView> {

    @Inject
    public DiscoverMoviesPresenter(AppViewInjector appViewInjector) {
        super(appViewInjector);
    }

    @Override
    protected void onViewAttached() {

    }
}
