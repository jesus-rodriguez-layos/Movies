package com.jrdev9.movies.app.commons.threads.jobs;


import java.util.concurrent.Future;

public interface JobInvoker {

    <T> Future<T> execute(JobExecution<T> jobExecution);
}
