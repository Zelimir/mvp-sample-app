package com.zelimir.android.mvpsampleapp.activities;


import android.content.res.Configuration;
import android.os.Bundle;

import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;
import com.zelimir.android.mvpsampleapp.presenters.base.ActivityPresenterV2;

public abstract class PresentableActivity<P extends ActivityPresenterV2<V>, V extends BaseViewInt>
        extends BaseActivity {

    private ActivityPresenterV2<V> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(getPresenter());

        if (hasPresenter()) {
            presenter.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (hasPresenter()) {
            presenter.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (hasPresenter()) {
            presenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (hasPresenter()) {
            presenter.onDestroy(isChangingConfigurations());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (hasPresenter()) {
            presenter.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (hasPresenter()) {
            presenter.onPause(getViewInt());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (hasPresenter()) {
            presenter.onResume(getViewInt());
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (hasPresenter()) {
            presenter.onConfigurationChanged(newConfig);
        }
    }

    private void setPresenter(final ActivityPresenterV2<V> presenter) {
        this.presenter = presenter;
    }

    protected boolean hasPresenter() {
        return presenter != null;
    }

    protected abstract P getPresenter();

    protected abstract V getViewInt();

}
