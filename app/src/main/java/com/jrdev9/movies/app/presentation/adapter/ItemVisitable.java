package com.jrdev9.movies.app.presentation.adapter;


import java.io.Serializable;

public interface ItemVisitable<T extends TypeViewModelFactory> extends Serializable {

    int type(T typeViewModelFactory);
}
