package com.jrdev9.movies.app.presentation.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

public abstract class BaseActivity extends AppCompatActivity implements BaseView, HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    protected Unbinder viewInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupInjection();
        super.onCreate(savedInstanceState);
        setupLayout();
        setupInjectViews();
    }

    private void setupLayout() {
        setContentView(getActivityLayout());
    }

    private void setupInjectViews() {
        viewInjector = ButterKnife.bind(this);
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewInjector.unbind();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }

    @Override
    public void showLoading() {
        //TODO: showLoading
    }

    @Override
    public void hideLoading() {
        //TODO: hideLoading
    }

    @LayoutRes
    protected abstract int getActivityLayout();

    protected abstract void setupInjection();

    protected abstract BasePresenter getPresenter();
}
