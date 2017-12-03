package com.jrdev9.movies.app.commons.threads.events;


import android.os.Handler;

import javax.inject.Inject;

public class ExecutorDelayImp implements ExecutorDelay {

    private final Handler handler;
    private Runnable runnable;

    @Inject
    public ExecutorDelayImp() {
        handler = new Handler();
    }

    @Override
    public void cancel(Runnable runnable) {
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void cancelLastRunnable() {
        cancel(this.runnable);
    }

    @Override
    public void execute(long delay, Runnable runnable) {
        this.runnable = runnable;
        handler.postDelayed(runnable, delay);
    }
}
