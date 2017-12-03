package com.jrdev9.movies.modules.discovermovies.presentation.mappers;


import com.jrdev9.movies.app.commons.mappers.Mapper;
import com.jrdev9.movies.modules.discovermovies.domain.models.MovieModel;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

import javax.inject.Inject;

public class DiscoverViewModelMapper implements Mapper<MovieModel, DiscoverMovieViewModel> {

    @Inject
    public DiscoverViewModelMapper() {

    }

    @Override
    public DiscoverMovieViewModel map(MovieModel model) {
        return new DiscoverMovieViewModel(
                model.getUniqueKey(),
                model.getTitle(),
                model.getPosterPath()
        );
    }
}
