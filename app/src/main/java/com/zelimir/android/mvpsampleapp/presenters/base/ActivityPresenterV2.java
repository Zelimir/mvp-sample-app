package com.zelimir.android.mvpsampleapp.presenters.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;

/**
 * Custom {@link Presenter} intended for usage with {@link Activity}.
 */
public class ActivityPresenterV2<V extends BaseViewInt> extends PresenterV2<V> {

    /**
     * Should be called in {@link Activity#onCreate(Bundle)}. This method can be
     * overridden by interested subclasses.
     */
    public void onCreate(final Bundle savedInstanceState) {
    }

    /**
     * Should be called in {@link Activity#onStart()}. This method can be
     * overridden by interested subclasses.
     */
    public void onStart() {
    }

    /**
     * Should be called in {@link Activity#onStop()}. This method can be
     * overridden by interested subclasses.
     */
    public void onStop() {
    }

    /**
     * Should be called in {@link Activity#onDestroy()}. This methods triggers a call
     * to {@link PresenterV2#onDestroy()} so no need to override it.
     */
    public final void onDestroy(final boolean isActivityChangingConfigurations) {
        destroy(isActivityChangingConfigurations);
    }

    /**
     * Should be called in {@link Activity#onSaveInstanceState(Bundle)}. This method can be
     * overridden by interested subclasses.
     */
    public void onSaveInstanceState(final Bundle outState) {
    }

    /**
     * Should be called in {@link Activity#onPause()}. This methods triggers a call
     * to {@link PresenterV2#onSave(Bundle)} so no need to override it.
     */
    public final void onPause(final V view) {
        unregisterView(view);
    }

    /**
     * Should be called in {@link Activity#onResume()}. This methods triggers a call
     * to {@link PresenterV2#onLoad(Bundle)} so no need to override it.
     */
    public final void onResume(final V view) {
        registerView(view);
    }

    /**
     * Should be called in {@link Activity#onConfigurationChanged(Configuration)}. This method can
     * be overridden by interested subclasses.
     */
    public void onConfigurationChanged(final Configuration newConfig) {
    }

}
