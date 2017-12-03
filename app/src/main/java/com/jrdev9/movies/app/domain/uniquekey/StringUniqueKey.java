package com.jrdev9.movies.app.domain.uniquekey;

public class StringUniqueKey implements UniqueKey<StringUniqueKey> {

    private final String id;

    public StringUniqueKey(String id) {
        this.id = id;
    }

    @Override
    public boolean isEquals(StringUniqueKey other) {
        return other.id.equals(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
