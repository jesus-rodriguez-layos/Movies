package com.jrdev9.movies.modules.discovermovies.presentation;

import android.os.Bundle;
import android.widget.Toast;

import com.jrdev9.movies.R;
import com.jrdev9.movies.app.presentation.base.BaseActivity;
import com.jrdev9.movies.app.presentation.base.BasePresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class DiscoverMoviesActivity extends BaseActivity implements DiscoverMoviesView {

    @Inject
    DiscoverMoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_movies);
        presenter.attachView(this);
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
    public void showMsg() {
        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
    }
}
