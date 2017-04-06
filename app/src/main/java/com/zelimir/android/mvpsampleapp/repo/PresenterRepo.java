package com.zelimir.android.mvpsampleapp.repo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zelimir.android.mvpsampleapp.presenters.base.PresenterV2;

import java.util.Hashtable;

import javax.inject.Inject;

import timber.log.Timber;

public class PresenterRepo {

    private final Hashtable<String, PresenterV2> presenterMap = new Hashtable<>();

    /**
     * Add presenter to storage.
     */
    public void addPresenterToStorage(@NonNull final PresenterV2 presenter) {
        final String key = presenter.getId();
        Timber.d("yeah addPresenterToStorage map size: " + presenterMap.size());

        presenterMap.put(key, presenter);
    }

    /**
     * Get presenter from storage.
     */
    @Nullable
    public PresenterV2 getPresenterFromStorage(final String presenterId) {
        Timber.d("yeah getPresenterFromStorage map size: " + presenterMap.size());

        return presenterMap.get(presenterId);
    }

    public void removePresenterFromStorage(final PresenterV2 presenter) {
        Timber.d("yeah removePresenterFromStorage map size: " + presenterMap.size());

        removePresenterFromStorage(presenter.getId());
    }

    public void removePresenterFromStorage(final String presenterId) {
        presenterMap.remove(presenterId);
    }

    /**
     * Remove all presenters which were added with {@link #addPresenterToStorage(PresenterV2)}
     * from storage.
     */
    public void clearStorage() {
        presenterMap.clear();
    }

}
