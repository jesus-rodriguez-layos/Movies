package com.jrdev9.movies.modules.discovermovies.presentation;

import com.jrdev9.movies.app.commons.mappers.ListMapper;
import com.jrdev9.movies.app.commons.threads.events.EventJobExecution;
import com.jrdev9.movies.app.commons.threads.jobs.JobExecution;
import com.jrdev9.movies.app.commons.threads.jobs.JobInvoker;
import com.jrdev9.movies.app.commons.viewinjectors.AppViewInjector;
import com.jrdev9.movies.app.di.scopes.ActivityScope;
import com.jrdev9.movies.app.domain.exceptions.errors.JobError;
import com.jrdev9.movies.app.presentation.base.BasePresenter;
import com.jrdev9.movies.modules.discovermovies.domain.models.DiscoverMoviesModel;
import com.jrdev9.movies.modules.discovermovies.domain.models.MovieModel;
import com.jrdev9.movies.modules.discovermovies.domain.usecases.DiscoverMoviesUseCase;
import com.jrdev9.movies.modules.discovermovies.presentation.mappers.DiscoverViewModelMapper;
import com.jrdev9.movies.modules.discovermovies.presentation.viewmodels.DiscoverMovieViewModel;

import java.util.List;

import javax.inject.Inject;

@ActivityScope
public class DiscoverMoviesPresenter extends BasePresenter<DiscoverMoviesView> {

    private final JobInvoker jobInvoker;
    private final EventJobExecution eventJobExecution;

    private final DiscoverMoviesUseCase discoverMoviesUseCase;
    private JobExecution<DiscoverMoviesModel> jobDiscoverMovies;
    private DiscoverMoviesModel discoverMoviesModel;
    private final ListMapper<MovieModel, DiscoverMovieViewModel> discoverViewModelMapperList;
    private List<DiscoverMovieViewModel> discoverMovieViewModelList;

    @Inject
    public DiscoverMoviesPresenter(AppViewInjector appViewInjector,
                                   JobInvoker jobInvoker,
                                   EventJobExecution eventJobExecution,
                                   DiscoverMoviesUseCase discoverMoviesUseCase,
                                   DiscoverViewModelMapper discoverViewModelMapper) {
        super(appViewInjector);
        this.jobInvoker = jobInvoker;
        this.eventJobExecution = eventJobExecution;
        this.discoverMoviesUseCase = discoverMoviesUseCase;
        this.discoverViewModelMapperList = new ListMapper<>(discoverViewModelMapper);
        setup();
    }

    @Override
    protected void onViewAttached() {
        discoverMovies();
    }

    private void setup() {
        setupJobDiscoverMovies();
    }

    private void setupJobDiscoverMovies() {
        jobDiscoverMovies = new JobExecution<>(discoverMoviesUseCase)
                .events(eventJobExecution)
                .result(this::successDiscoverMovies)
                .error(JobError.class, this::errorDiscoverMovies);
    }

    private void successDiscoverMovies(DiscoverMoviesModel discoverMoviesModel) {
        this.discoverMoviesModel = discoverMoviesModel;
        discoverMovieViewModelList = discoverViewModelMapperList.map(discoverMoviesModel.getMovieList());
        getView().showDiscoverMovies(discoverMovieViewModelList);
    }

    private void errorDiscoverMovies(JobError jobError) {
        //TODO: errorDiscoverMovies
    }

    private void discoverMovies() {
        jobDiscoverMovies.execute(jobInvoker);
    }
}
