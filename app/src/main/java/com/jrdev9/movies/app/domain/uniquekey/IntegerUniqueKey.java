package com.jrdev9.movies.app.domain.uniquekey;

public class IntegerUniqueKey implements UniqueKey<IntegerUniqueKey> {

    private final Integer id;

    public IntegerUniqueKey(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isEquals(IntegerUniqueKey other) {
        return other.id.equals(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }


}
