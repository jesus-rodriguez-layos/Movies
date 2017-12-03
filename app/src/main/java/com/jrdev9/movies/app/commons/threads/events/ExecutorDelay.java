package com.jrdev9.movies.app.commons.threads.events;


public interface ExecutorDelay {

    void cancelLastRunnable();

    void cancel(Runnable runnable);

    void execute(long delay, Runnable runnable);
}
