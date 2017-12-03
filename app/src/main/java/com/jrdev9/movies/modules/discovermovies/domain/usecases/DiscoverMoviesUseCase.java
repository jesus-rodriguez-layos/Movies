package com.jrdev9.movies.modules.discovermovies.domain.usecases;


import com.jrdev9.movies.app.domain.usecases.JobResponse;
import com.jrdev9.movies.app.domain.usecases.UseCase;
import com.jrdev9.movies.modules.discovermovies.domain.gateways.DiscoverMoviesGateway;
import com.jrdev9.movies.modules.discovermovies.domain.models.DiscoverMoviesModel;

import javax.inject.Inject;

public class DiscoverMoviesUseCase implements UseCase<JobResponse<DiscoverMoviesModel>> {

    private final DiscoverMoviesGateway gateway;

    @Inject
    public DiscoverMoviesUseCase(DiscoverMoviesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public JobResponse<DiscoverMoviesModel> call() throws Exception {
        DiscoverMoviesModel discoverMoviesModel = gateway.discoverMovies();
        return new JobResponse<>(discoverMoviesModel);
    }
}
