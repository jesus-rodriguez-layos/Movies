package com.jrdev9.movies.app.presentation.adapter;


import android.view.View;

public interface TypeViewModelFactory {

    BaseViewHolder holder(View view, int type);
}
