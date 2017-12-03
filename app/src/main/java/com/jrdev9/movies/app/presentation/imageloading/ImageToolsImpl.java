package com.jrdev9.movies.app.presentation.imageloading;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

public class ImageToolsImpl implements ImageTools, ImageLoad, ImageRequest {

    private RequestManager instanceImageLoading;
    private RequestBuilder<Drawable> requestBuilder;

    @Inject
    ImageToolsImpl() {

    }

    public ImageToolsImpl with(Context context) {
        instanceImageLoading = Glide.with(context);
        return this;
    }

    public ImageRequest load(String url) {
        requestBuilder = instanceImageLoading.load(url);
        return this;
    }

    public void into(ImageView imageView) {
        requestBuilder.into(imageView);
    }
}