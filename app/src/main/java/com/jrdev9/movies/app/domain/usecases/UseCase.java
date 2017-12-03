package com.jrdev9.movies.app.domain.usecases;

import com.jrdev9.movies.app.commons.threads.jobs.JobUseCase;

public interface UseCase<T extends JobResponse> extends JobUseCase<T> {

}
