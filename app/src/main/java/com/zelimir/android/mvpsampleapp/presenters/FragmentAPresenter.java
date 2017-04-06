package com.zelimir.android.mvpsampleapp.presenters;


import android.os.Bundle;

import com.zelimir.android.mvpsampleapp.dagger.scopes.ActivityScope;
import com.zelimir.android.mvpsampleapp.fragments.viewinterface.FragmentAViewInt;
import com.zelimir.android.mvpsampleapp.fragments.section.FragmentASection;
import com.zelimir.android.mvpsampleapp.presenters.base.FragmentPresenter;
import com.zelimir.android.mvpsampleapp.presenters.base.FragmentPresenterV2;

import javax.inject.Inject;

import timber.log.Timber;

public class FragmentAPresenter extends FragmentPresenterV2<FragmentAViewInt> {

    @Inject
    Bundle bundle;

    public FragmentAPresenter() {
        FragmentASection.getDaggerComponent().inject(this);
    }

    @Override
    protected void onLoad(Bundle savedInstanceState) {
        super.onLoad(savedInstanceState);

        final String title = bundle != null ? bundle.getString("TITLE") : "";
        Timber.d("yeah bundle title: " + title);
        Timber.d("yeah view: " + getView());

        if (hasView()) {
            getView().setTitle(title);
        }
    }

    @Override
    protected void onSave(Bundle outState) {
        super.onSave(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
