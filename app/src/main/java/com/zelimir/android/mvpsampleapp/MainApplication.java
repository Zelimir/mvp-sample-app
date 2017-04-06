package com.zelimir.android.mvpsampleapp;


import android.app.Application;

import com.zelimir.android.mvpsampleapp.config.AppInfo;
import com.zelimir.android.mvpsampleapp.dagger.components.AppComponent;
import com.zelimir.android.mvpsampleapp.dagger.components.DaggerAppComponent;
import com.zelimir.android.mvpsampleapp.dagger.modules.AppModule;

import timber.log.Timber;

public class MainApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupTimber();
        setupDagger();
    }

    private void setupTimber() {
        if (AppInfo.isDebug()) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // TODO Log crash reports.
        }
    }

    private void setupDagger() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
