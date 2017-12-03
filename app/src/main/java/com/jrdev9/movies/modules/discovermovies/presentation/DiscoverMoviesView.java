package com.jrdev9.movies.modules.discovermovies.presentation;

import com.jrdev9.movies.app.presentation.base.BaseView;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

import java.util.List;

import me.panavtec.threaddecoratedview.views.qualifiers.ThreadDecoratedView;

@ThreadDecoratedView
public interface DiscoverMoviesView extends BaseView {

    void showDiscoverMovies(List<DiscoverMovieViewModel> movieList);
}
