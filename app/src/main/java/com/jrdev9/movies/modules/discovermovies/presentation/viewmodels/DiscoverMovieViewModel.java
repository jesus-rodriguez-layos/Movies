package com.jrdev9.movies.modules.discovermovies.presentation.viewmodels;


import com.jrdev9.movies.app.domain.uniquekey.LongUniqueKey;
import com.jrdev9.movies.app.presentation.adapter.ItemVisitable;
import com.jrdev9.movies.modules.discovermovies.presentation.adapters.DiscoverMoviesViewHolderTypeFactory;

public class DiscoverMovieViewModel implements ItemVisitable<DiscoverMoviesViewHolderTypeFactory> {

    public final LongUniqueKey uniqueKey;
    public final String title;
    public final String posterPath;

    public DiscoverMovieViewModel(LongUniqueKey uniqueKey, String title, String posterPath) {
        this.uniqueKey = uniqueKey;
        this.title = title;
        this.posterPath = posterPath;
    }

    @Override
    public int type(DiscoverMoviesViewHolderTypeFactory typeViewModelFactory) {
        return typeViewModelFactory.type(this);
    }
}
