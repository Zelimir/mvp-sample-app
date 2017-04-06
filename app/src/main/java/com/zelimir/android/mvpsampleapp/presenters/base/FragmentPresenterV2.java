package com.zelimir.android.mvpsampleapp.presenters.base;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;

/**
 * Custom {@link Presenter} intended for usage with {@link Fragment} views.
 */
public class FragmentPresenterV2<V extends BaseViewInt> extends PresenterV2<V> {

    /**
     * Should be called in {@link Fragment#onAttach(Context)}. This method can be
     * overridden by interested subclasses.
     */
    public void onAttach() {
    }

    /**
     * Should be called in {@link Fragment#onCreate(Bundle)}. This method can be
     * overridden by interested subclasses.
     */
    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    /**
     * Should be called in {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}. This
     * method can be overridden by interested subclasses.
     */
    public void onCreateView() {
    }

    /**
     * Should be called in {@link Fragment#onViewCreated(View, Bundle)}. This method can be
     * overridden by interested subclasses.
     */
    public void onViewCreated() {
    }

    /**
     * Should be called in {@link Fragment#onStart()}. This method can be
     * overridden by interested subclasses.
     */
    public void onStart() {
    }

    /**
     * Should be called in {@link Fragment#onResume()}. This methods triggers a call
     * to {@link PresenterV2#onLoad(Bundle)} so no need to override it.
     */
    public final void onResume(final V view) {
        registerView(view);
    }

    /**
     * Should be called in {@link Fragment#onPause()}. This methods triggers a call
     * to {@link PresenterV2#onSave(Bundle)} so no need to override it.
     */
    public final void onPause(final V view) {
        unregisterView(view);
    }

    /**
     * Should be called in {@link Fragment#onStop()}. This method can be
     * overridden by interested subclasses.
     */
    public void onStop() {
    }

    /**
     * Should be called in {@link Fragment#onDestroyView()}. This method can be
     * overridden by interested subclasses.
     */
    public void onDestroyView() {
    }

    /**
     * Should be called in {@link Fragment#onDestroy()}. This methods triggers a call
     * to {@link PresenterV2#onDestroy()} so no need to override it.
     */
    public final void onDestroy(final boolean isActivityChangingConfigurations) {
        destroy(isActivityChangingConfigurations);
    }

    /**
     * Should be called in {@link Fragment#onDetach()}. This method can be
     * overridden by interested subclasses.
     */
    public void onDetach() {
    }

    /**
     * Should be called in {@link Fragment#onConfigurationChanged(Configuration)}. This method can
     * be overridden by interested subclasses.
     */
    public void onConfigurationChanged(Configuration newConfig) {
    }

}
