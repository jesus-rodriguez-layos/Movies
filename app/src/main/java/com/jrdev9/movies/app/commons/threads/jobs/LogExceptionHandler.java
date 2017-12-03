package com.jrdev9.movies.app.commons.threads.jobs;

import android.util.Log;

public class LogExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "LogExceptionHandler";

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e(TAG, "Unhandled UseCase Exception", ex);
    }
}
