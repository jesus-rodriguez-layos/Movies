package com.jrdev9.movies.app.data.api;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    String BASE_URL = "https://api.themoviedb.org/";
    String VERSION = "3/";

    @GET("discover/movie")
    Call discoverMovies();
}
