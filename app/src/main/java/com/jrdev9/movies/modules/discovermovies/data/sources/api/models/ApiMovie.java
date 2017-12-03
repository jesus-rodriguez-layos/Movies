package com.jrdev9.movies.modules.discovermovies.data.sources.api.models;


import com.google.gson.annotations.SerializedName;

public class ApiMovie {

    @SerializedName("id")
    public long id;

    @SerializedName("title")
    public String title;

    @SerializedName("vote_count")
    public long voteCount;

    @SerializedName("vote_average")
    public double voteAverage;

    @SerializedName("original_language")
    public String originalLanguage;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("overview")
    public String overview;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("backdrop_path")
    public String backdropPath;
}
