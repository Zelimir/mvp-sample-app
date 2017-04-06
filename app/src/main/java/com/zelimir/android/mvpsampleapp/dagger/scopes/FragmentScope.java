package com.zelimir.android.mvpsampleapp.dagger.scopes;

import android.app.Fragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Custom scope which allows us to have objects which depend on {@link Fragment} lifetime. This
 * allows us to use singletons which are limited to fragment. It also keeps are global object
 * graph clear of components which are used only in activities.
 * <p/>
 * This custom scope should be connected to Fragment's local component.
 */
@Scope
@Retention(RetentionPolicy.SOURCE)
public @interface FragmentScope {
    Class<?> value();
}
