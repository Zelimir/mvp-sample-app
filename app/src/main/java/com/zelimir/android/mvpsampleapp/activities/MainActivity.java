package com.zelimir.android.mvpsampleapp.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zelimir.android.mvpsampleapp.R;
import com.zelimir.android.mvpsampleapp.dagger.components.AppComponent;
import com.zelimir.android.mvpsampleapp.dagger.components.DaggerMainActivityComponent;
import com.zelimir.android.mvpsampleapp.dagger.components.MainActivityComponent;
import com.zelimir.android.mvpsampleapp.dagger.modules.MainActivityModule;
import com.zelimir.android.mvpsampleapp.fragments.section.FragmentASection;
import com.zelimir.android.mvpsampleapp.nav.NavBus;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;


public class MainActivity extends BaseActivity {

    @Inject
    NavBus navBus;

    @BindView(R.id.title_text)
    TextView titleView;

    @BindView(R.id.main_container)
    FrameLayout mainContainer;

    @BindString(R.string.main_activity_title)
    String title;

    private MainActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle();
        addFragmentA();
        addFragmentAToBackup();
    }

    @Override
    protected int getContentLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void createComponent(final AppComponent appComponent) {
        if (mainActivityComponent == null) {
            mainActivityComponent = DaggerMainActivityComponent.builder()
                    .activityModule(getActivityModule())
                    .mainActivityModule(new MainActivityModule())
                    .appComponent(appComponent)
                    .build();
        }

        mainActivityComponent.inject(this);
    }

    private void setTitle() {
        titleView.setText(title);
    }

    private void addFragmentA() {
        final FragmentASection section = new FragmentASection("mainContainer");

        final FragmentManager fragmentManager = getFragmentManager();

        final Fragment fragment = fragmentManager.findFragmentByTag(section.getFragmentTag());

        if (fragment == null) {
            final Bundle bundle = new Bundle();
            bundle.putString("TITLE", "fragment title from activity for main container");

            section.setBundle(bundle);
            section.createDaggerComponent(mainActivityComponent);
            fragmentManager.beginTransaction()
                    .add(R.id.main_container, section.getFragment(), section.getFragmentTag())
                    .commit();
        }

    }

    private void addFragmentAToBackup() {
        final FragmentASection section = new FragmentASection("backupContainer");

        final FragmentManager fragmentManager = getFragmentManager();

        final Fragment fragment = fragmentManager.findFragmentByTag(section.getFragmentTag());

        if (fragment == null) {
            final Bundle bundle = new Bundle();
            bundle.putString("TITLE", "fragment title from activity for backup container");

            section.setBundle(bundle);
            section.createDaggerComponent(mainActivityComponent);
            fragmentManager.beginTransaction()
                    .add(R.id.backup_container, section.getFragment(), section.getFragmentTag())
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
