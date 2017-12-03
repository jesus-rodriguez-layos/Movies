package com.jrdev9.movies.app.domain.uniquekey;

public class LongUniqueKey implements UniqueKey<LongUniqueKey> {

    private final Long id;

    public LongUniqueKey(Long id) {
        this.id = id;
    }

    @Override
    public boolean isEquals(LongUniqueKey other) {
        return other.id.equals(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }


}
