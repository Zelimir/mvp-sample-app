package com.zelimir.android.mvpsampleapp.fragments.section;

import android.app.Fragment;
import android.os.Bundle;

import com.zelimir.android.mvpsampleapp.dagger.components.ActivityComponent;
import com.zelimir.android.mvpsampleapp.dagger.components.MainActivityComponent;
import com.zelimir.android.mvpsampleapp.dagger.scopes.ActivityScope;
import com.zelimir.android.mvpsampleapp.fragments.FragmentA;
import com.zelimir.android.mvpsampleapp.fragments.viewinterface.FragmentAViewInt;
import com.zelimir.android.mvpsampleapp.presenters.FragmentAPresenter;
import com.zelimir.android.mvpsampleapp.presenters.base.FragmentPresenterV2;
import com.zelimir.android.mvpsampleapp.section.DataDriven;
import com.zelimir.android.mvpsampleapp.section.FragmentSection;
import com.zelimir.android.mvpsampleapp.section.Section;

import javax.inject.Inject;

import dagger.Provides;
import timber.log.Timber;


public class FragmentASection extends FragmentSection<ActivityComponent>
        implements DataDriven {

    private final String fragmentTag;

    private Bundle bundle;

    private static Component component;

    public FragmentASection(final String sectionID) {
        this.bundle = new Bundle();
        this.fragmentTag = FragmentA.TAG + "{sectionID: " + sectionID + "}";
//        this.fragmentTag = FragmentA.TAG + "{timestamp: " + System.nanoTime() + ", randomInt: " + (int)(Math.random() * Integer.MAX_VALUE);
    }

    @Override
    public String getID() {
        return "fragmentA";
    }

    @Override
    public Fragment getFragment() {
        return new FragmentA();
    }

    public String getFragmentTag() {
        // Timber.d("fragment tag: " + fragmentTag);
        return fragmentTag;
    }

//    @Override
//    public Class<? extends Screen> getScreenClass() {
//        return VideoGuideScreen.class;
//    }

    @Override
    public void setBundle(final Bundle bundle) {
        this.bundle = (bundle == null) ? this.bundle : bundle;
    }

    public static Component getDaggerComponent() {
        return component;
    }

    @Override
    public void createDaggerComponent(final ActivityComponent parent) {
        component = DaggerFragmentASection_Component.builder()
                .activityComponent(parent)
                .module(new Module())
                .build();

        Timber.d("yeah component: " + component);
    }

    @dagger.Module
    public class Module {

        @ActivityScope(Component.class)
        @Provides
        public Bundle provideBundle() {
            return bundle;
        }

    }

    @ActivityScope(Component.class)
    @dagger.Component(dependencies = {ActivityComponent.class}, modules = {Module.class})
    public interface Component extends ActivityComponent {

        // Injection targets
        void inject(FragmentA fragmentA);

        void inject(FragmentAPresenter fragmentAPresenter);

        // Provided dependencies
        Bundle getBundle();
    }

}
