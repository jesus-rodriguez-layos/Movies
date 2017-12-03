package com.jrdev9.movies.app.commons.mappers;


public interface Mapper<M, P> {
    P map(M model);
}
