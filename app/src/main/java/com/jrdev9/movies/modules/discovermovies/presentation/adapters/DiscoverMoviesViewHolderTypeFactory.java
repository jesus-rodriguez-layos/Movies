package com.jrdev9.movies.modules.discovermovies.presentation.adapters;


import com.jrdev9.movies.app.presentation.adapter.TypeViewModelFactory;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

public interface DiscoverMoviesViewHolderTypeFactory extends TypeViewModelFactory {

    int type(DiscoverMovieViewModel viewModel);
}
