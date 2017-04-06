package com.zelimir.android.mvpsampleapp.dagger.components;

import com.zelimir.android.mvpsampleapp.activities.MainActivity;
import com.zelimir.android.mvpsampleapp.dagger.modules.ActivityModule;
import com.zelimir.android.mvpsampleapp.dagger.modules.MainActivityModule;
import com.zelimir.android.mvpsampleapp.dagger.scopes.ActivityScope;

import dagger.Component;

@ActivityScope(MainActivityComponent.class)
@Component(dependencies = {AppComponent.class},
        modules = {ActivityModule.class, MainActivityModule.class})
public interface MainActivityComponent extends ActivityComponent {

    // Injection targets
    void inject(MainActivity mainActivity);

}
