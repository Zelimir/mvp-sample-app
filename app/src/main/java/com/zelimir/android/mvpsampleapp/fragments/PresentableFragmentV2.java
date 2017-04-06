package com.zelimir.android.mvpsampleapp.fragments;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zelimir.android.mvpsampleapp.presenters.BaseViewInt;
import com.zelimir.android.mvpsampleapp.presenters.base.PresenterV2;
import com.zelimir.android.mvpsampleapp.presenters.lifecycle.FragmentLifecycleDelegate;
import com.zelimir.android.mvpsampleapp.repo.PresenterRepo;

public abstract class PresentableFragmentV2<P extends PresenterV2<V>, V extends BaseViewInt>
        extends BaseFragment {

    private final FragmentLifecycleDelegate<P, V> lifecycleDelegate =
            new FragmentLifecycleDelegate<>(getClass());

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lifecycleDelegate.onAttach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleDelegate.setPresenterRepo(getPresenterRepo());
        lifecycleDelegate.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final @Nullable ViewGroup container,
                             final Bundle savedInstanceState) {
        lifecycleDelegate.onCreateView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lifecycleDelegate.onViewCreated();
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycleDelegate.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycleDelegate.onResume(getViewInt());
    }

    @Override
    public void onPause() {
        super.onPause();
        lifecycleDelegate.onPause(getViewInt());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleDelegate.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycleDelegate.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        lifecycleDelegate.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        final boolean isChangingConfigurations = getActivity().isChangingConfigurations();
        lifecycleDelegate.onDestroy(isChangingConfigurations);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        lifecycleDelegate.onDetach();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        lifecycleDelegate.onConfigurationChanged(newConfig);
    }

    protected boolean hasPresenter() {
        return lifecycleDelegate.hasPresenter();
    }

    protected abstract PresenterRepo getPresenterRepo();

    /**
     * Get presenter responsible for managing this view.
     */
    protected P getPresenter() {
        return lifecycleDelegate.getPresenter();
    }

    /**
     * Get interface used in presenter for managing the View.
     */
    protected abstract V getViewInt();

}
