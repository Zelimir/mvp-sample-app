package com.zelimir.android.mvpsampleapp.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.zelimir.android.mvpsampleapp.dagger.qualifiers.ApplicationContext;
import com.zelimir.android.mvpsampleapp.nav.NavBus;
import com.zelimir.android.mvpsampleapp.repo.PresenterRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(final Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    NavBus provideNavBus() {
        return new NavBus();
    }

    @Provides
    @Singleton
    PresenterRepo providePresenterRepo() {
        return new PresenterRepo();
    }

}
