package com.zelimir.android.mvpsampleapp.presenters.base;

import android.view.View;

/**
 * Custom {@link Presenter} intended for usage with {@link android.view.View}.
 */
public class ViewPresenter<V> extends Presenter<V> {

    /**
     * Should be called in {@link View#onAttachedToWindow()}.
     */
    public void onAttachedToWindow(V view) {
        takeView(view);
    }

    /**
     * Should be called in {@link View#onDetachedFromWindow()}.
     */
    public void onDetachedFromWindow(V view) {
        dropView(view);
    }

}
