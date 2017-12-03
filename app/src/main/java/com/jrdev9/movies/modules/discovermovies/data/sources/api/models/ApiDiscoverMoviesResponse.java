package com.jrdev9.movies.modules.discovermovies.data.sources.api.models;

import com.google.gson.annotations.SerializedName;
import com.jrdev9.movies.app.data.api.models.ApiResponseModel;

import java.util.List;


public class ApiDiscoverMoviesResponse extends ApiResponseModel {

    @SerializedName("page")
    public long page;

    @SerializedName("total_results")
    public long totalResults;

    @SerializedName("total_movies")
    public long totalMovies;

    @SerializedName("results")
    public List<ApiMovie> movieList;
}
