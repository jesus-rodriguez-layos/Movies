package com.jrdev9.movies.modules.discovermovies.domain.gateways;


import com.jrdev9.movies.modules.discovermovies.domain.models.DiscoverMoviesModel;

public interface DiscoverMoviesGateway {

    DiscoverMoviesModel discoverMovies() throws Exception;
}
