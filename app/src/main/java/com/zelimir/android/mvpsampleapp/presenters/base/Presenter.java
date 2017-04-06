package com.zelimir.android.mvpsampleapp.presenters.base;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Abstract class representing a Presenter in a Model-View-Presenter architecture.
 */
public abstract class Presenter<V> {

    private V view = null;

    /**
     * Should be called to give this presenter control of a view. This presenter can be used in
     * following types of UI:
     * <p>
     * 1. {@link Activity} - should be called from {@link Activity#onCreate(Bundle)}. <br/>
     * 2. {@link Fragment} - should be called from {@link Fragment#onViewCreated(View, Bundle)}. <br/>
     * 3. {@link View} - should be called from {@link View#onAttachedToWindow()}
     * <p>
     * When passed view is no longer active, {@link #dropView(Object)} should be called.
     *
     * @param view View which will be set to this {@link Presenter} and returned
     *             from {@link #getView()}.
     */
    protected final void takeView(@NonNull V view) {
        if (this.view != view) {
            this.view = view;
        }
    }

    /**
     * Should be called to remove view from the presenter. This presenter can be used in
     * following types of UI:
     * <p>
     * 1. {@link Activity} - should be called from {@link Activity#onDestroy()} (Bundle)}. <br/>
     * 2. {@link Fragment} - should be called from {@link Fragment#onDestroyView()} ()} (View, Bundle)}. <br/>
     * 3. {@link View} - should be called from {@link View#onDetachedFromWindow()} ()}
     * <p>
     *
     * @param view View which was previously set to this {@link Presenter}
     *             with {@link #takeView(Object)}.
     */
    protected void dropView(V view) {
        if (view == this.view) {
            this.view = null;
        }
    }

    /**
     * Returns the view managed by this presenter. It's recommended to first check if there is a
     * View available with {@link #hasView()}.
     * <p/>
     * Can return null if: <br/>
     * 1. {@link #takeView} was not called.<br/>
     * 2. This was called after {@link #dropView}.
     */
    protected final V getView() {
        return view;
    }

    /**
     * @return True if this presenter holds a view, false otherwise.
     */
    protected final boolean hasView() {
        return view != null;
    }

}
