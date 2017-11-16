package com.jrdev9.movies.app.presentation.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

public abstract class BaseActivity extends AppCompatActivity implements BaseView, HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @LayoutRes
    protected abstract int getActivityLayout();

    protected abstract void setupInjection();

    protected abstract BasePresenter getPresenter();

    protected Unbinder unbinder;

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupInjection();
        super.onCreate(savedInstanceState);
        setupLayout();
        setupInjectViews();
    }

    protected void setupLayout() {
        View rootView = inflateView(getActivityLayout(), null, false);
        setContentView(rootView);
    }

    protected View inflateView(@LayoutRes int layoutId, ViewGroup parent, boolean attach) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        return layoutInflater.inflate(layoutId, parent, attach);
    }

    protected void setupInjectViews() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
}
