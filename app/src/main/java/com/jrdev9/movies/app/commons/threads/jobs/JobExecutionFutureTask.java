package com.jrdev9.movies.app.commons.threads.jobs;


import com.jrdev9.movies.app.commons.threads.events.EventJobExecution;
import com.jrdev9.movies.app.commons.threads.priority.PriorizableJob;
import com.jrdev9.movies.app.domain.exceptions.errors.JobError;
import com.jrdev9.movies.app.domain.usecases.JobResponse;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class JobExecutionFutureTask<T> extends FutureTask<T> implements PriorizableJob {

    private final JobExecution<T> jobExecution;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final String description;

    public JobExecutionFutureTask(JobExecution<T> jobExecution,
                                  Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        super((Callable<T>) jobExecution.getJobUseCase());
        this.jobExecution = jobExecution;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        this.description = jobExecution.getJobUseCase().getClass().toString();
    }

    @Override
    public EventJobExecution getEvents() {
        return jobExecution.getEvents();
    }

    @Override
    protected void done() {
        try {
            super.done();
            handleResponse((JobResponse<T>) get());
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        Throwable causeException = e.getCause();
        unhandledException(causeException != null ? causeException : e);
    }

    private void handleResponse(JobResponse<T> response) {
        if (response.hasError()) {
            handleError(response.getError());
        } else {
            handleResult(response.getResult());
        }
    }

    private void handleResult(T result) {
        jobExecution.getJobResult().onResult(result);
    }

    private void handleError(JobError error) {
        JobResult errorResult = jobExecution.getInteractorErrorResult(error.getClass());
        if (errorResult != null) {
            errorResult.onResult(error);
        } else {
            errorResult = jobExecution.getInteractorErrorResult(JobError.class);
            if (errorResult != null) {
                errorResult.onResult(error);
            } else {
                unhandledException(new RuntimeException("Unhandled handleError action: " + error.getClass().toString()));
            }
        }
    }

    private void unhandledException(Throwable cause) {
        UnhandledJobException e = new UnhandledJobException(description, cause.getClass().getName());
        e.initCause(cause);
        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), e);
    }

    public int getPriority() {
        return jobExecution.getPriority();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
