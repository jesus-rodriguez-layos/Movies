package com.jrdev9.movies.app.domain.exceptions.errors;

public interface JobError {

    void accept(UseCaseErrorVisitor useCaseErrorVisitor);
}
