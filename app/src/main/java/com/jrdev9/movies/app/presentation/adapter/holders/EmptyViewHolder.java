package com.jrdev9.movies.app.presentation.adapter.holders;


import android.view.View;

import com.jrdev9.movies.app.presentation.adapter.BaseViewHolder;

public class EmptyViewHolder extends BaseViewHolder<Void> {

    public EmptyViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Void viewModel) {

    }
}

