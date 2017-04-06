package com.zelimir.android.mvpsampleapp.presenters.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;

import java.util.Locale;
import java.util.UUID;

import timber.log.Timber;

/**
 * Abstract class representing a Presenter in a Model-View-Presenter architecture.
 */
public class PresenterV2<V extends BaseViewInt> {

    private final static String PRESENTER_ID = "Presenter{className=%s,timestamp=%s,UUID=%s}";

    @Nullable
    private Bundle bundle;

    private final String id;

    private V view = null;

    public PresenterV2() {
        final String className = getClass().getName();
        final String uuid = UUID.randomUUID().toString();
        final long timestamp = System.nanoTime();

        this.id = String.format(Locale.US, PRESENTER_ID, className, timestamp, uuid);

        Timber.d("yeah created presenter with ID: " + id);
    }

    /**
     * Get ID of this presenter. Each presenter has unique ID which is created
     * during the presenter creation.
     */
    public String getId() {
        return id;
    }

    /**
     * Callback triggered when a view gets attached to this presenter. This method can be
     * overridden by interested subclasses.
     */
    protected void onLoad(final Bundle savedInstanceState) {
    }

    /**
     * Callback triggered when a view gets detached from this presenter. This method can be
     * overridden by interested subclasses.
     */
    protected void onSave(final Bundle outState) {
    }

    /**
     * Callback triggered when user leaves view ({@link Activity}, {@link Fragment} or
     * {@link View}). This method can be overridden by interested subclasses.
     */
    protected void onDestroy() {
    }

    /**
     * Should be called to give this presenter control of a view. When passed view is no longer
     * active, {@link #unregisterView(BaseViewInt)}} should be called.
     *
     * @param view View which will be set to this {@link Presenter} and returned
     *             from {@link #getView()}.
     */
    public final void registerView(@NonNull V view) {
        if (this.view != view) {
            this.view = view;
            onLoad(bundle);
        }
    }

    /**
     * Should be called to remove view from the presenter.
     *
     * @param view View which was previously set to this {@link Presenter}
     *             with {@link #registerView(BaseViewInt)}.
     */
    public final void unregisterView(V view) {
        if (view == this.view) {
            this.bundle = new Bundle();
            onSave(bundle);

            this.view = null;
        }
    }

    /**
     * Forwards call to {@link #destroy(boolean)} with boolean param set to false.
     */
    public final void destroy() {
         destroy(false);
    }

    /**
     * Should be called when user leaves the View which is managed by this presenter.
     *
     * @param isActivityChangingConfigurations Defines if Activity which holds View which is
     *                                         managed with this presenter is in the process of
     *                                         being destroyed in order to be recreated with a
     *                                         new configuration.
     */
    public final void destroy(final boolean isActivityChangingConfigurations) {
        if (!isActivityChangingConfigurations) {
            onDestroy();
        }
    }

    /**
     * Returns the view managed by this presenter. It's recommended to first check if there is a
     * View available with {@link #hasView()}.
     * <p/>
     * Can return null if: <br/>
     * 1. {@link #registerView} was not called.<br/>
     * 2. This was called after {@link #unregisterView}.
     */
    protected final V getView() {
        return view;
    }

    /**
     * @return True if this presenter holds a view, false otherwise.
     */
    public final boolean hasView() {
        return view != null;
    }

}
