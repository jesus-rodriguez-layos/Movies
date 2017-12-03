package com.jrdev9.movies.app.domain.exceptions.errors;

public interface UseCaseErrorVisitor {

    void visit(InternalError error);
}
