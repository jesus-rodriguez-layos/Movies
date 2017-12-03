package com.jrdev9.movies.modules.discovermovies.domain.models;


import com.jrdev9.movies.app.domain.EntityModel;
import com.jrdev9.movies.app.domain.uniquekey.LongUniqueKey;

public class MovieModel extends EntityModel<LongUniqueKey> {

    private final String title;
    private final long voteCount;
    private final double voteAverage;
    private final String originalLanguage;
    private final String releaseDate;
    private final String overview;
    private final String posterPath;
    private final String backdropPath;

    public MovieModel(long id,
                      String title,
                      long voteCount,
                      double voteAverage,
                      String originalLanguage,
                      String releaseDate,
                      String overview,
                      String posterPath,
                      String backdropPath) {
        super(new LongUniqueKey(id));
        this.title = title;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.originalLanguage = originalLanguage;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
