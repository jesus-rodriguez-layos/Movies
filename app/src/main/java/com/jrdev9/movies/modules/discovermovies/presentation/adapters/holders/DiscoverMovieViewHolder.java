package com.jrdev9.movies.modules.discovermovies.presentation.adapters.holders;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jrdev9.movies.R;
import com.jrdev9.movies.app.presentation.adapter.BaseViewHolder;
import com.jrdev9.movies.app.presentation.imageloading.ImageTools;
import com.jrdev9.movies.modules.discovermovies.presentation.DiscoverMoviesPresenter;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

import butterknife.BindView;

public class DiscoverMovieViewHolder extends BaseViewHolder<DiscoverMovieViewModel> {

    @BindView(R.id.imgPoster)
    ImageView imgPoster;

    @BindView(R.id.txtTitle)
    TextView txtTitle;

    public static final int LAYOUT = R.layout.item_movie;
    private final DiscoverMoviesPresenter presenter;
    private final ImageTools imageTools;
    private DiscoverMovieViewModel model;

    public DiscoverMovieViewHolder(View itemView, DiscoverMoviesPresenter presenter, ImageTools imageTools) {
        super(itemView);
        this.presenter = presenter;
        this.imageTools = imageTools;
    }

    @Override
    public void bind(DiscoverMovieViewModel model) {
        this.model = model;
        renderPoster();
        renderTitle();
    }

    private void renderPoster() {
        imageTools.with(imgPoster.getContext()).load(getPosterUrl()).into(imgPoster);
    }

    private void renderTitle() {
        txtTitle.setText(model.title);
    }

    public String getPosterUrl() {
        return "http://image.tmdb.org/t/p/w500/" + model.posterPath;
    }
}
