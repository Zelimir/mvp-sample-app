package com.zelimir.android.mvpsampleapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.zelimir.android.mvpsampleapp.R;
import com.zelimir.android.mvpsampleapp.fragments.viewinterface.FragmentAViewInt;
import com.zelimir.android.mvpsampleapp.fragments.section.FragmentASection;
import com.zelimir.android.mvpsampleapp.presenters.FragmentAPresenter;
import com.zelimir.android.mvpsampleapp.presenters.annotation.HasPresenter;
import com.zelimir.android.mvpsampleapp.repo.PresenterRepo;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

@HasPresenter(FragmentAPresenter.class)
public class FragmentA extends PresentableFragmentV2<FragmentAPresenter, FragmentAViewInt>
        implements FragmentAViewInt {

    public static final String TAG = FragmentA.class.getSimpleName();

    @Inject
    PresenterRepo presenterRepo;

    @BindView(R.id.title_text)
    TextView titleView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FragmentASection.getDaggerComponent().inject(this);
        super.onCreate(savedInstanceState);
        Timber.d("yeah presenterRepo: " + presenterRepo);
        Timber.d("yeah presenter: " + getPresenter());
    }

    @Override
    protected int getContentLayoutResID() {
        return R.layout.fragment_a;
    }

    @Override
    protected FragmentAViewInt getViewInt() {
        return this;
    }

    @Override
    protected PresenterRepo getPresenterRepo() {
        return presenterRepo;
    }

    @Override
    public void setTitle(String title) {
        titleView.setText(title);
    }

}
