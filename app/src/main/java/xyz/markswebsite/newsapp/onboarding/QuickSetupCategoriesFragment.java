package xyz.markswebsite.newsapp.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.markswebsite.newsapp.R;
import xyz.markswebsite.newsapp.models.Source;

/**
 * Created by Mark on 9/09/2017.
 */

public class QuickSetupCategoriesFragment extends Fragment {

    private RecyclerView mLanguageRecycler, mCategoriesRecycler;
    private RecyclerView.LayoutManager mLanguageLayoutManager, mCategoriesLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_categories, container, false);

        mLanguageRecycler = (RecyclerView) rootView.findViewById(R.id.onboarding_language_recycler);
        mCategoriesRecycler = (RecyclerView) rootView.findViewById(R.id.onboarding_categories_recycler);

        mLanguageRecycler.setHasFixedSize(true);
        mCategoriesRecycler.setHasFixedSize(true);

        mL

        return rootView;
    }

}
