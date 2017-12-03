package com.jrdev9.movies.modules.discovermovies.data.sources.api;


import com.jrdev9.movies.app.data.api.ApiTheMovieDatabaseEndPoint;
import com.jrdev9.movies.app.data.api.BaseApiService;
import com.jrdev9.movies.modules.discovermovies.data.sources.api.models.ApiDiscoverMoviesResponse;
import com.jrdev9.movies.modules.discovermovies.data.sources.api.models.mappers.ApiDiscoverMoviesResponseMapper;
import com.jrdev9.movies.modules.discovermovies.domain.models.DiscoverMoviesModel;

import javax.inject.Inject;

import retrofit2.Call;

public class ApiDiscoverMovies extends BaseApiService {

    private final ApiTheMovieDatabaseEndPoint api;
    private final ApiDiscoverMoviesResponseMapper mapper;

    @Inject
    public ApiDiscoverMovies(ApiTheMovieDatabaseEndPoint api,
                             ApiDiscoverMoviesResponseMapper mapper) {
        this.api = api;
        this.mapper = mapper;
    }

    public DiscoverMoviesModel discoverMovies() throws Exception {
        Call<ApiDiscoverMoviesResponse> callService = api.discoverMovies(ApiTheMovieDatabaseEndPoint.API_KEY);
        ApiDiscoverMoviesResponse apiResponse = execute(callService);
        return mapper.map(apiResponse);
    }
}
