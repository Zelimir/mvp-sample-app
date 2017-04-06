package com.zelimir.android.mvpsampleapp.dagger.modules;

import android.app.Activity;
import android.content.Context;

import com.zelimir.android.mvpsampleapp.dagger.qualifiers.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

}
