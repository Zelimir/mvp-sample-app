package com.zelimir.android.mvpsampleapp.section;

/**
 * Interface for defining sections of this app (activities, fragments, views). Each section needs
 * to have an option to provide its own Dagger module.
 */
public interface Section<T> {

    // String getMortarScopeName();

    String getID();

    void createDaggerComponent(T parent);

}
