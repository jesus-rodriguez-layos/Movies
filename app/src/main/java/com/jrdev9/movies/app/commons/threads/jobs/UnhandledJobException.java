package com.jrdev9.movies.app.commons.threads.jobs;

public class UnhandledJobException extends RuntimeException {

    public UnhandledJobException(String interactorName, String initiatorException) {
        super(String.format("Interactor %s does not handle the exception: %s", interactorName, initiatorException));
    }
}
