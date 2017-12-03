package com.jrdev9.movies.app.di.modules;

import com.jrdev9.movies.app.commons.threads.priority.PriorizableThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExecutorModule {

    @Provides
    @Singleton
    public ExecutorService provideExecutor(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
        return new PriorizableThreadPoolExecutor(
                0L,
                TimeUnit.MILLISECONDS,
                blockingQueue,
                threadFactory
        );
    }
}
