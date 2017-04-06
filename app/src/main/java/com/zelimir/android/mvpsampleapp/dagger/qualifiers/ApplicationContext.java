package com.zelimir.android.mvpsampleapp.dagger.qualifiers;

import android.app.Application;
import android.content.Context;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Used to qualify the {@link Context} dependency as {@link Application} Context. Context can be of
 * type Application Context and an Activity Context. As both of these Objects are of type Context,
 * Dagger2 needs a way to know which Context needs to be used.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
