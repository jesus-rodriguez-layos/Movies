package com.jrdev9.movies.app.commons.threads.jobs;

public interface JobResult<T> {

    void onResult(T result);
}
