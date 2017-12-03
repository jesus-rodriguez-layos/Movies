package com.jrdev9.movies.app.commons.json;

import java.lang.reflect.Type;

public interface BaseJson {

    <T> String toJson(T obj);

    <T> T fromJson(String json, Class<T> typeClass);

    <T> T fromJson(String json, Type type);
}
