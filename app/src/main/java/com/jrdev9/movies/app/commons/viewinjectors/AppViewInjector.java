package com.jrdev9.movies.app.commons.viewinjectors;

public interface AppViewInjector {

    <V> V injectView(V view);

    <V> V nullObjectPatternView(V view);
}
