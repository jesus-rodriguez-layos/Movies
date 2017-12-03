package com.jrdev9.movies.modules.discovermovies.presentation;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jrdev9.movies.R;
import com.jrdev9.movies.app.presentation.adapter.BaseAdapter;
import com.jrdev9.movies.app.presentation.base.BaseActivity;
import com.jrdev9.movies.app.presentation.base.BasePresenter;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class DiscoverMoviesActivity extends BaseActivity implements DiscoverMoviesView {

    @Inject
    DiscoverMoviesPresenter presenter;

    @Inject
    BaseAdapter adapter;

    @BindView(R.id.recyclerMovies)
    RecyclerView recyclerMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);
        setup();
    }

    private void setup() {
        setupRecycler();
    }

    private void setupRecycler() {
        recyclerMovies.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerMovies.setLayoutManager(layoutManager);
        recyclerMovies.setAdapter(adapter);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_discover_movies;
    }

    @Override
    protected void setupInjection() {
        AndroidInjection.inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showDiscoverMovies(List<DiscoverMovieViewModel> movieList) {
        ((BaseAdapter) recyclerMovies.getAdapter()).setItems(new ArrayList<>(movieList));
    }
}
