package com.jrdev9.movies.app.commons.mappers;


public interface TwoWaysMapper<M, P> extends Mapper<M, P> {
    M inverseMap(P model);
}