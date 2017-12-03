package com.jrdev9.movies.app.commons.threads.jobs;

import com.jrdev9.movies.app.commons.threads.priority.PriorityRunnableFutureDecorated;

import java.util.concurrent.PriorityBlockingQueue;

public class JobPriorityBlockingQueue extends PriorityBlockingQueue<Runnable> {

    public JobPriorityBlockingQueue(int initialCapacity) {
        super(initialCapacity, (runnableFirst, runnableSecond) -> {
            boolean firstIsPriority = runnableFirst instanceof PriorityRunnableFutureDecorated;
            boolean secondIsPriority = runnableSecond instanceof PriorityRunnableFutureDecorated;

            if (!firstIsPriority && !secondIsPriority) {
                return 0;
            } else if (!firstIsPriority) {
                return -1;
            } else if (!secondIsPriority) {
                return 1;
            }

            int priorityFirst = ((PriorityRunnableFutureDecorated) runnableFirst).getPriority();
            int prioritySecond = ((PriorityRunnableFutureDecorated) runnableSecond).getPriority();

            return Integer.valueOf(priorityFirst).compareTo(prioritySecond);
        });
    }
}
