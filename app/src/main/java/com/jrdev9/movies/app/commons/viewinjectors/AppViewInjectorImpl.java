package com.jrdev9.movies.app.commons.viewinjectors;

import javax.inject.Inject;

import me.panavtec.threaddecoratedview.views.ThreadSpec;
import me.panavtec.threaddecoratedview.views.ViewInjector;

public class AppViewInjectorImpl implements AppViewInjector {

    private ThreadSpec threadSpec;

    @Inject
    public AppViewInjectorImpl(ThreadSpec threadSpec) {
        this.threadSpec = threadSpec;
    }

    @Override
    public <V> V injectView(V view) {
        return ViewInjector.inject(view, threadSpec);
    }

    @Override
    public <V> V nullObjectPatternView(V view) {
        return ViewInjector.nullObjectPatternView(view);
    }
}
