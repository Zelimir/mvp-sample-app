package com.zelimir.android.mvpsampleapp.presenters.base;


import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Custom {@link Presenter} intended for usage with {@link Fragment} views.
 */
public class FragmentPresenter<T> extends Presenter<T> {

    /**
     * Should be called in {@link Fragment#onAttach(Context)}.
     */
    public void attach() {
    }

    /**
     * Should be called in {@link Fragment#onCreate(Bundle)}.
     */
    public void create(@Nullable Bundle savedInstanceState) {
    }

    /**
     * Should be called in {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     */
    public void createView() {
    }

    /**
     * Should be called in {@link Fragment#onViewCreated(View, Bundle)}.
     */
    public void viewCreated(T view) {
        takeView(view);
    }

    /**
     * Should be called in {@link Fragment#onStart()}.
     */
    public void start() {
    }

    /**
     * Should be called in {@link Fragment#onResume()}.
     */
    public void resume() {
    }

    /**
     * Should be called in {@link Fragment#onPause()}.
     */
    public void pause() {
    }

    /**
     * Should be called in {@link Fragment#onStop()}.
     */
    public void stop() {
    }

    /**
     * Should be called in {@link Fragment#onDestroyView()}.
     */
    public void destroyView() {
    }

    /**
     * Should be called in {@link Fragment#onDestroy()}.
     */
    public void destroy(T view) {
        dropView(view);
    }

    /**
     * Should be called in {@link Fragment#onDetach()}.
     */
    public void detach() {
    }

    /**
     * Should be called in {@link Fragment#onConfigurationChanged(Configuration)}.
     */
    public void configurationChanged(Configuration newConfig) {
    }

}
