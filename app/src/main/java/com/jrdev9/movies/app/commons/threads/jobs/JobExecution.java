package com.jrdev9.movies.app.commons.threads.jobs;

import com.jrdev9.movies.app.commons.threads.events.EventJobExecution;
import com.jrdev9.movies.app.domain.exceptions.errors.JobError;
import com.jrdev9.movies.app.domain.usecases.JobResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class JobExecution<T> {

    private final Map<Class<? extends JobError>, JobResult<? extends JobError>> errors = new HashMap<>(0);
    private final JobUseCase<JobResponse<T>> jobUseCase;
    private JobResult<T> jobResult;
    private int priority;
    private Future<T> futureExecute;
    private EventJobExecution events;

    public JobExecution(JobUseCase<JobResponse<T>> jobUseCase) {
        this.jobUseCase = jobUseCase;
    }

    public JobExecution<T> result(JobResult<T> jobResult) {
        this.jobResult = jobResult;
        return this;
    }

    public JobExecution<T> error(Class<? extends JobError> errorClass,
                                 JobResult<? extends JobError> interactorError) {
        this.errors.put(errorClass, interactorError);
        return this;
    }

    public JobExecution<T> events(EventJobExecution events) {
        this.events = events;
        return this;
    }

    public JobExecution<T> priority(int priority) {
        this.priority = priority;
        return this;
    }

    public JobUseCase<JobResponse<T>> getJobUseCase() {
        return jobUseCase;
    }

    public JobResult<? extends JobError> getInteractorErrorResult(Class<? extends JobError> errorClass) {
        return errors.get(errorClass);
    }

    public JobResult<T> getJobResult() {
        return jobResult;
    }

    public EventJobExecution getEvents() {
        return events;
    }

    public void execute(JobInvoker jobInvoker) {
        this.futureExecute = jobInvoker.execute(this);
    }

    public void cancel() {
        if (this.futureExecute != null && !this.futureExecute.isCancelled()) {
            this.futureExecute.cancel(true);
        }
    }

    public int getPriority() {
        return priority;
    }
}
