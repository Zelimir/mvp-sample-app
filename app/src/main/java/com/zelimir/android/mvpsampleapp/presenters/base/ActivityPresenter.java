package com.zelimir.android.mvpsampleapp.presenters.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Custom {@link Presenter} intended for usage with {@link Activity}.
 */
public class ActivityPresenter<V> extends Presenter<V> {

    /**
     * Should be called in {@link Activity#onCreate(Bundle)}.
     */
    public void create(final V view, final Bundle savedInstanceState) {
        takeView(view);
    }

    /**
     * Should be called in {@link Activity#onStart()}.
     */
    public void start() {
    }

    /**
     * Should be called in {@link Activity#onStop()}.
     */
    public void stop() {
    }

    /**
     * Should be called in {@link Activity#onDestroy()}.
     */
    public void destroy(final V view) {
        dropView(view);
    }

    /**
     * Should be called in {@link Activity#onSaveInstanceState(Bundle)}.
     */
    public void saveInstanceState(final Bundle outState) {
    }

    /**
     * Should be called in {@link Activity#onPause()}.
     */
    public void pause() {
    }

    /**
     * Should be called in {@link Activity#onResume()}.
     */
    public void resume() {
    }

    /**
     * Should be called in {@link Activity#onConfigurationChanged(Configuration)}.
     */
    public void configurationChanged(Configuration newConfig) {
    }

}
