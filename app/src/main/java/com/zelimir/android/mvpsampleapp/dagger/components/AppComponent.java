package com.zelimir.android.mvpsampleapp.dagger.components;


import com.zelimir.android.mvpsampleapp.dagger.modules.AppModule;
import com.zelimir.android.mvpsampleapp.nav.NavBus;
import com.zelimir.android.mvpsampleapp.repo.PresenterRepo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    // Exposed to sub-graphs.
    NavBus getNavBus();

    PresenterRepo getPresenterRepo();

}
