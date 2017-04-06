package com.zelimir.android.mvpsampleapp.dagger.components;

import android.app.Activity;

import com.zelimir.android.mvpsampleapp.activities.MainActivity;
import com.zelimir.android.mvpsampleapp.dagger.modules.ActivityModule;
import com.zelimir.android.mvpsampleapp.dagger.scopes.ActivityScope;
import com.zelimir.android.mvpsampleapp.repo.PresenterRepo;

import dagger.Component;

@ActivityScope(ActivityComponent.class)
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    // Exposed to sub-graphs.
    Activity getActivity();

    PresenterRepo getPresenterRepo();

}
