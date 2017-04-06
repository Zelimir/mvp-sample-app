package com.zelimir.android.mvpsampleapp.fragments;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;
import com.zelimir.android.mvpsampleapp.presenters.base.FragmentPresenterV2;

public abstract class PresentableFragment<P extends FragmentPresenterV2<V>, V extends BaseViewInt>
        extends BaseFragment {

    private FragmentPresenterV2<V> presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (hasPresenter()) {
            presenter.onAttach();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(getPresenter());
        if (hasPresenter()) {
            presenter.onCreate(savedInstanceState);
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final @Nullable ViewGroup container,
                             final Bundle savedInstanceState) {
        if (hasPresenter()) {
            presenter.onCreateView();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (hasPresenter()) {
            presenter.onViewCreated();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (hasPresenter()) {
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (hasPresenter()) {
            presenter.onResume(getViewInt());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (hasPresenter()) {
            presenter.onPause(getViewInt());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (hasPresenter()) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (hasPresenter()) {
            presenter.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (hasPresenter()) {
            final boolean isChangingConfigurations = getActivity().isChangingConfigurations();
            presenter.onDestroy(isChangingConfigurations);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (hasPresenter()) {
            presenter.onDetach();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (hasPresenter()) {
            presenter.onConfigurationChanged(newConfig);
        }
    }

    private void setPresenter(final FragmentPresenterV2<V> presenter) {
        this.presenter = presenter;
    }

    protected boolean hasPresenter() {
        return presenter != null;
    }

    /**
     * Get presenter responsible for managing this view.
     */
    protected abstract P getPresenter();

    /**
     * Get interface used in presenter for managing the View.
     */
    protected abstract V getViewInt();

}
