package com.jrdev9.movies.app.commons.threads.jobs;

import com.jrdev9.movies.app.commons.threads.priority.PriorityJobDecorator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.inject.Inject;

public class JobInvokerImp implements JobInvoker {

    private ExecutorService executor;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    @Inject
    public JobInvokerImp(ExecutorService executor, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.executor = executor;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override
    public <T> Future<T> execute(JobExecution<T> jobExecution) {
        if (jobExecution.getJobResult() != null) {
            return (Future<T>) executor.submit(new JobExecutionFutureTask<>(jobExecution, uncaughtExceptionHandler));
        } else {
            return executor.submit(new PriorityJobDecorator<>(jobExecution));
        }
    }
}
