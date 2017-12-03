package com.jrdev9.movies.app.commons.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonJson implements BaseJson {

    private final Gson gson;

    public GsonJson(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> String toJson(T obj) {
        return gson.toJson(obj);
    }

    @Override
    public <T> T fromJson(String json, Class<T> typeClass) {
        return gson.fromJson(json, typeClass);
    }

    @Override
    public <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
