package com.jrdev9.movies.app.commons.threads.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorizableThreadPoolExecutor extends ThreadPoolExecutor {

    public final static int CONCURRENT_INTERACTORS = 3;
    public final static int MAX_POOL_CONCURRENT_INTERACTORS = 10;

    private PriorizableJob priorizableJob;

    public PriorizableThreadPoolExecutor(long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(CONCURRENT_INTERACTORS, MAX_POOL_CONCURRENT_INTERACTORS, keepAliveTime, unit, workQueue, threadFactory);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        RunnableFuture<T> runnableFuture = super.newTaskFor(callable);
        return decorateFuture(runnableFuture, getCandidatePriority(callable));
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        RunnableFuture<T> runnableFuture = super.newTaskFor(runnable, value);
        return decorateFuture(runnableFuture, getCandidatePriority(runnable));
    }

    private int getCandidatePriority(Object callable) {
        return callable instanceof PriorizableJob
                ? ((PriorizableJob) callable).getPriority() : 0;
    }

    private <T> RunnableFuture<T> decorateFuture(RunnableFuture<T> runnableFuture, int priority) {
        return new PriorityRunnableFutureDecorated<>(runnableFuture, priority);
    }

    @Override
    public Future<?> submit(Runnable task) {
        if (task instanceof PriorizableJob) {
            this.priorizableJob = (PriorizableJob) task;
        }
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if (task instanceof PriorizableJob) {
            this.priorizableJob = (PriorizableJob) task;
        }
        return super.submit(task);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        if (priorizableJob != null && priorizableJob.getEvents() != null) {
            priorizableJob.getEvents().beforeExecute();
        }
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (priorizableJob != null && priorizableJob.getEvents() != null) {
            priorizableJob.getEvents().afterExecute();
        }
    }
}

