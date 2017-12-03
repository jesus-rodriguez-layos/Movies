package com.jrdev9.movies.app.domain.uniquekey;

import java.util.Date;

public class DateUniqueKey implements UniqueKey<DateUniqueKey> {

    private final Date id;

    public DateUniqueKey(Date id) {
        this.id = id;
    }

    @Override
    public boolean isEquals(DateUniqueKey other) {
        return other.id.equals(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }


}
