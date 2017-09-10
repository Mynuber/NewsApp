package xyz.markswebsite.newsapp.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.markswebsite.newsapp.R;

/**
 * Created by Mark on 9/09/2017.
 */

public class QuickSetupNewsSourceFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_sources, container, false);
        return rootView;
    }
}
