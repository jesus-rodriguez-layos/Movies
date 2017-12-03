package com.jrdev9.movies.modules.discovermovies.data.sources;


import com.jrdev9.movies.modules.discovermovies.data.sources.api.ApiDiscoverMovies;
import com.jrdev9.movies.modules.discovermovies.domain.gateways.DiscoverMoviesGateway;
import com.jrdev9.movies.modules.discovermovies.domain.models.DiscoverMoviesModel;

import javax.inject.Inject;

public class DiscoverMoviesDataGateway implements DiscoverMoviesGateway {

    private final ApiDiscoverMovies apiDiscoverMovies;

    @Inject
    public DiscoverMoviesDataGateway(ApiDiscoverMovies apiDiscoverMovies) {
        this.apiDiscoverMovies = apiDiscoverMovies;
    }

    @Override
    public DiscoverMoviesModel discoverMovies() throws Exception {
        return apiDiscoverMovies.discoverMovies();
    }
}
