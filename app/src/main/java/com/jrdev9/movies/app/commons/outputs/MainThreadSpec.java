package com.jrdev9.movies.app.commons.outputs;

import android.os.Handler;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

public class MainThreadSpec implements ThreadSpec {

    private Handler handler;

    public MainThreadSpec() {
        handler = new Handler();
    }

    @Override
    public void execute(Runnable action) {
        handler.post(action);
    }
}
