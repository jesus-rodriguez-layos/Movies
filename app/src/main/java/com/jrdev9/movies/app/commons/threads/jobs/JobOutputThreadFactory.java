package com.jrdev9.movies.app.commons.threads.jobs;

import java.util.concurrent.ThreadFactory;

public class JobOutputThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "UseCaseInvoker" + r.toString());
    }
}
