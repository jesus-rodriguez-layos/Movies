package com.jrdev9.movies.modules.discovermovies.domain.models;


import java.util.List;

public class DiscoverMoviesModel {

    private final long page;
    private final long totalResults;
    private final long totalMovies;
    private final List<MovieModel> movieList;

    public DiscoverMoviesModel(long page,
                               long totalResults,
                               long totalMovies,
                               List<MovieModel> movieList) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalMovies = totalMovies;
        this.movieList = movieList;
    }

    public long getPage() {
        return page;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public long getTotalMovies() {
        return totalMovies;
    }

    public List<MovieModel> getMovieList() {
        return movieList;
    }
}
