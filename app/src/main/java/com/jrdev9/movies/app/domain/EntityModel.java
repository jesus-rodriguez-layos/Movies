package com.jrdev9.movies.app.domain;


import com.jrdev9.movies.app.domain.uniquekey.UniqueKey;

import java.io.Serializable;

public class EntityModel<T extends UniqueKey> implements Serializable {

    private final T uniqueKey;

    public EntityModel(T uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public T getUniqueKey() {
        return uniqueKey;
    }

    @Override
    public boolean equals(Object obj) {
        EntityModel entityModel = (EntityModel) obj;
        return entityModel.uniqueKey.isEquals(uniqueKey);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

}
