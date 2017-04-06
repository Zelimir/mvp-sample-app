package com.zelimir.android.mvpsampleapp.section;


import android.app.Fragment;

public abstract class FragmentSection<T> implements Section<T> {

    public abstract Fragment getFragment();

}
