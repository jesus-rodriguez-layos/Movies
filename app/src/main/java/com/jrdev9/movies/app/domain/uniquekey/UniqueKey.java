package com.jrdev9.movies.app.domain.uniquekey;

import java.io.Serializable;

public interface UniqueKey<T extends UniqueKey> extends Serializable {

    boolean isEquals(T other);
}
