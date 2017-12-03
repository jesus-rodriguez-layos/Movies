package com.jrdev9.movies.modules.discovermovies.presentation.adapters;


import android.view.View;

import com.jrdev9.movies.app.di.scopes.ActivityScope;
import com.jrdev9.movies.app.presentation.adapter.BaseViewHolder;
import com.jrdev9.movies.app.presentation.imageloading.ImageTools;
import com.jrdev9.movies.modules.discovermovies.presentation.DiscoverMoviesPresenter;
import com.jrdev9.movies.modules.discovermovies.presentation.adapters.holders.DiscoverMovieViewHolder;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

import javax.inject.Inject;

@ActivityScope
public class DiscoverMoviesViewHolderFactory implements DiscoverMoviesViewHolderTypeFactory {

    private final DiscoverMoviesPresenter presenter;
    private final ImageTools imageTools;

    @Inject
    public DiscoverMoviesViewHolderFactory(DiscoverMoviesPresenter presenter, ImageTools imageTools) {
        this.presenter = presenter;
        this.imageTools = imageTools;
    }

    @Override
    public int type(DiscoverMovieViewModel viewModel) {
        return DiscoverMovieViewHolder.LAYOUT;
    }

    @Override
    public BaseViewHolder holder(View view, int type) {
        return new DiscoverMovieViewHolder(view, presenter, imageTools);
    }
}
