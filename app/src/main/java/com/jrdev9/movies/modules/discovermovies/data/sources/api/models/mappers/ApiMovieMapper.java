package com.jrdev9.movies.modules.discovermovies.data.sources.api.models.mappers;


import com.jrdev9.movies.app.commons.mappers.Mapper;
import com.jrdev9.movies.modules.discovermovies.data.sources.api.models.ApiMovie;
import com.jrdev9.movies.modules.discovermovies.domain.models.MovieModel;

import javax.inject.Inject;

public class ApiMovieMapper implements Mapper<ApiMovie, MovieModel> {

    @Inject
    public ApiMovieMapper() {

    }

    @Override
    public MovieModel map(ApiMovie apiModel) {
        return new MovieModel(
                apiModel.id,
                apiModel.title,
                apiModel.voteCount,
                apiModel.voteAverage,
                apiModel.originalLanguage,
                apiModel.releaseDate,
                apiModel.overview,
                apiModel.posterPath,
                apiModel.backdropPath
        );
    }
}
