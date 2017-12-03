package com.jrdev9.movies.app.domain.usecases;

import com.jrdev9.movies.app.domain.exceptions.errors.JobError;

public class JobResponse<T> {

    private JobError error;
    private T result;

    public JobResponse(JobError error) {
        this.error = error;
    }

    public JobResponse(T result) {
        this.result = result;
    }

    public JobError getError() {
        return error;
    }

    public T getResult() {
        return result;
    }

    public boolean hasError() {
        return error != null;
    }
}
