package com.jrdev9.movies.app.commons.threads.jobs;


import com.jrdev9.movies.app.domain.usecases.JobResponse;

import java.util.concurrent.Callable;

public interface JobUseCase<T extends JobResponse> extends Callable<T> {

    @Override
    T call() throws Exception;
}
