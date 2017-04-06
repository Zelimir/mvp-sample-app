package com.zelimir.android.mvpsampleapp.presenters.lifecycle;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zelimir.android.mvpsampleapp.intent.BundleKey;
import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;
import com.zelimir.android.mvpsampleapp.presenters.annotation.HasPresenter;
import com.zelimir.android.mvpsampleapp.presenters.base.PresenterV2;
import com.zelimir.android.mvpsampleapp.repo.PresenterRepo;

import timber.log.Timber;

public class UILifecycleDelegate<P extends PresenterV2<V>, V extends BaseViewInt> {

    private PresenterRepo presenterRepo;

    private final Class<?> uiClass;

    public UILifecycleDelegate(Class<?> uiClazz) {
        this.uiClass = uiClazz;
    }

    @Nullable
    private P presenter;

    public void setPresenterRepo(final PresenterRepo presenterRepo) {
        this.presenterRepo = presenterRepo;
    }

    @Nullable
    public P getPresenter() {
        return presenter;
    }

    /**
     * {@link android.app.Activity#onSaveInstanceState(Bundle)}, {@link android.app.Fragment#onSaveInstanceState(Bundle)}, {@link android.view.View#onSaveInstanceState()}.
     */
    public void onSaveState(final Bundle outState) {
        if (presenter != null) {
            outState.putString(BundleKey.PRESENTER_ID, presenter.getId());
        }
    }

    /**
     * {@link android.app.Activity#onCreate(Bundle)}, {@link android.app.Fragment#onCreate(Bundle)}, {@link android.view.View#onRestoreInstanceState(Parcelable)}.
     */
    public void onRestoreState(final Bundle savedState) {
        if (presenter == null && savedState != null) {
            final String presenterId = savedState.getString(BundleKey.PRESENTER_ID);
            Timber.d("yeah retrieved presenter ID: " + presenterId);

            //noinspection unchecked
            presenter = (P) presenterRepo.getPresenterFromStorage(presenterId);
            Timber.d("yeah found presenter in storage: " + presenter);
        }

        if (presenter == null) {
            HasPresenter annotation = uiClass.getAnnotation(HasPresenter.class);

            //noinspection unchecked
            Class<P> presenterClass = (annotation == null) ? null : (Class<P>) annotation.value();
            if (presenterClass != null) {
                try {
                    presenter = presenterClass.newInstance();
                    presenterRepo.addPresenterToStorage(presenter);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public boolean hasPresenter() {
        return presenter != null;
    }

    /**
     * {@link android.app.Activity#onResume()},
     * {@link android.app.Fragment#onResume()},
     * {@link android.view.View#onAttachedToWindow()}
     */
    final void registerView(final V view) {
        getPresenter();
        if (presenter != null && !presenter.hasView()) {
            presenter.registerView(view);
        }
    }

    /**
     * {@link Activity#onPause()} ()},
     * {@link Fragment#onPause()} ()},
     * {@link android.view.View#onDetachedFromWindow()}
     */
    final void unregisterView(final V view) {
        if (presenter != null && presenter.hasView()) {
            presenter.unregisterView(view);
        }
    }

    /**
     * {@link android.app.Activity#onDestroy()},
     * {@link android.app.Fragment#onDestroy()},
     * {@link android.view.View#onDetachedFromWindow()}
     *
     * @param isChangingConfigurations Should be retrieved from Activity.
     * @see Activity#isChangingConfigurations()
     */
    final void destroyPresenter(final boolean isChangingConfigurations) {
        if (presenter != null && !isChangingConfigurations) {
            presenterRepo.removePresenterFromStorage(presenter);
            presenter.destroy();
            presenter = null;
        }
    }

}
