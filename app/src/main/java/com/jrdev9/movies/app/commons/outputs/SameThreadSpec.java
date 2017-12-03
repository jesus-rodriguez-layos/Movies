package com.jrdev9.movies.app.commons.outputs;

import me.panavtec.threaddecoratedview.views.ThreadSpec;

public class SameThreadSpec implements ThreadSpec {

    @Override
    public void execute(Runnable action) {
        action.run();
    }
}
