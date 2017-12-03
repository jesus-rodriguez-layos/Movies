package com.jrdev9.movies.app.commons.threads.priority;

import com.jrdev9.movies.app.commons.threads.events.EventJobExecution;

public interface PriorizableJob {

    int getPriority();

    String getDescription();

    EventJobExecution getEvents();
}
