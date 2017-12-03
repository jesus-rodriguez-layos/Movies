package com.jrdev9.movies.app.di.modules;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jrdev9.movies.app.commons.json.BaseJson;
import com.jrdev9.movies.app.commons.json.GsonInterfaceAdapter;
import com.jrdev9.movies.app.commons.json.GsonJson;
import com.jrdev9.movies.app.commons.outputs.BackThreadSpec;
import com.jrdev9.movies.app.commons.outputs.MainThreadSpec;
import com.jrdev9.movies.app.commons.outputs.SameThreadSpec;
import com.jrdev9.movies.app.commons.threads.events.ExecutorDelay;
import com.jrdev9.movies.app.commons.threads.events.ExecutorDelayImp;
import com.jrdev9.movies.app.commons.threads.jobs.JobInvoker;
import com.jrdev9.movies.app.commons.threads.jobs.JobInvokerImp;
import com.jrdev9.movies.app.commons.threads.jobs.JobOutputThreadFactory;
import com.jrdev9.movies.app.commons.threads.jobs.JobPriorityBlockingQueue;
import com.jrdev9.movies.app.commons.threads.jobs.LogExceptionHandler;
import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjector;
import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjectorImpl;
import com.jrdev9.movies.app.di.qualifiers.BackThread;
import com.jrdev9.movies.app.di.qualifiers.SameThread;
import com.jrdev9.movies.app.di.qualifiers.UiThread;
import com.jrdev9.movies.app.domain.uniquekey.UniqueKey;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.panavtec.threaddecoratedview.views.ThreadSpec;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public AppViewInjector provideAppViewInjector() {
        return new AppViewInjectorImpl(new MainThreadSpec());
    }

    @Provides
    @Singleton
    @UiThread
    public ThreadSpec provideMainThread() {
        return new MainThreadSpec();
    }

    @Provides
    @Singleton
    @SameThread
    public ThreadSpec provideSameThread() {
        return new SameThreadSpec();
    }

    @Provides
    @Singleton
    @BackThread
    public ThreadSpec provideBackThread() {
        return new BackThreadSpec();
    }

    @Provides
    @Singleton
    public LogExceptionHandler provideLogExceptionHandler() {
        return new LogExceptionHandler();
    }

    @Provides
    @Singleton
    public JobInvoker provideInteractorInvoker(ExecutorService executor, LogExceptionHandler logExceptionHandler) {
        return new JobInvokerImp(executor, logExceptionHandler);
    }

    @Provides
    @Singleton
    public BlockingQueue<Runnable> provideBlockingQueue() {
        return new JobPriorityBlockingQueue(100);
    }

    @Provides
    @Singleton
    public ThreadFactory provideThreadFactory() {
        return new JobOutputThreadFactory();
    }

    @Provides
    @Singleton
    public ExecutorDelay provideExecutorDelay() {
        return new ExecutorDelayImp();
    }

    @Provides
    @Singleton
    public BaseJson provideJson(Gson gson) {
        return new GsonJson(gson);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(UniqueKey.class, new GsonInterfaceAdapter<UniqueKey>())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }
}
