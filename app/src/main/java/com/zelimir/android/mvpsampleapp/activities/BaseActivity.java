package com.zelimir.android.mvpsampleapp.activities;


import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zelimir.android.mvpsampleapp.MainApplication;
import com.zelimir.android.mvpsampleapp.dagger.components.AppComponent;
import com.zelimir.android.mvpsampleapp.dagger.modules.ActivityModule;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Base {@link Activity} which should be extended by all of Applications's activities.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("onCreate");
        setContentView(getContentLayoutResID());
        ButterKnife.bind(this);
        createComponent(getAppComponent());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.d("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Timber.d("onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.d("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Timber.d("onConfigurationChanged");
    }

    /**
     * Get layout ID which will be used with this activity.
     */
    @LayoutRes
    protected abstract int getContentLayoutResID();

    /**
     * Create component which is limited to {@link Activity}.
     */
    protected abstract void createComponent(AppComponent appComponent);

    /**
     * Get {@link AppComponent} for dependency injection.
     */
    private AppComponent getAppComponent() {
        return MainApplication.getAppComponent();
    }

    /**
     * Get {@link ActivityModule} for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
