package com.jrdev9.movies.modules.discovermovies.data.sources.api.models.mappers;


import com.jrdev9.movies.app.commons.mappers.ListMapper;
import com.jrdev9.movies.app.commons.mappers.Mapper;
import com.jrdev9.movies.modules.discovermovies.data.sources.api.models.ApiDiscoverMoviesResponse;
import com.jrdev9.movies.modules.discovermovies.data.sources.api.models.ApiMovie;
import com.jrdev9.movies.modules.discovermovies.domain.models.DiscoverMoviesModel;
import com.jrdev9.movies.modules.discovermovies.domain.models.MovieModel;

import javax.inject.Inject;

public class ApiDiscoverMoviesResponseMapper implements Mapper<ApiDiscoverMoviesResponse, DiscoverMoviesModel> {

    private final ListMapper<ApiMovie, MovieModel> listApiMovieMapper;

    @Inject
    public ApiDiscoverMoviesResponseMapper(ApiMovieMapper apiMovieMapper) {
        listApiMovieMapper = new ListMapper<>(apiMovieMapper);
    }

    @Override
    public DiscoverMoviesModel map(ApiDiscoverMoviesResponse response) {
        return new DiscoverMoviesModel(
                response.page,
                response.totalResults,
                response.totalMovies,
                listApiMovieMapper.map(response.movieList)
        );
    }
}
