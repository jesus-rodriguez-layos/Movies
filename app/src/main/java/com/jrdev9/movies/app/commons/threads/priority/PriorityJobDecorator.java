package com.jrdev9.movies.app.commons.threads.priority;

import com.jrdev9.movies.app.commons.threads.events.EventJobExecution;
import com.jrdev9.movies.app.commons.threads.jobs.JobExecution;

import java.util.concurrent.Callable;

public class PriorityJobDecorator<T> implements Callable<T>, PriorizableJob {

    private JobExecution<T> execution;

    public PriorityJobDecorator(JobExecution<T> execution) {
        this.execution = execution;
    }

    @Override
    public T call() throws Exception {
        return (T) execution.getJobUseCase().call();
    }

    @Override
    public int getPriority() {
        return execution.getPriority();
    }

    @Override
    public String getDescription() {
        return execution.getClass().toString();
    }

    @Override
    public EventJobExecution getEvents() {
        return execution.getEvents();
    }
}
