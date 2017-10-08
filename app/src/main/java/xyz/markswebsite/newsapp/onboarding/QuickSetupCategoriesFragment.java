package xyz.markswebsite.newsapp.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xyz.markswebsite.newsapp.R;
import xyz.markswebsite.newsapp.Utility.SharedPreferenceUtil;
import xyz.markswebsite.newsapp.Utility.SourceUtils;
import xyz.markswebsite.newsapp.models.Source;
import xyz.markswebsite.newsapp.models.SourcesResponse;

/**
 * Created by Mark on 9/09/2017.
 */

public class QuickSetupCategoriesFragment extends Fragment {

    private RecyclerView mLanguageRecycler, mCategoriesRecycler;
    private RecyclerView.LayoutManager mLanguageLayoutManager, mCategoriesLayoutManager;
    private RecyclerView.Adapter mLanguageAdapter, mCategoriesAdapter;

    private Set<String> languagesSelected = new HashSet<>(), categoriesSelected = new HashSet<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_categories, container, false);

        mLanguageRecycler = (RecyclerView) rootView.findViewById(R.id.onboarding_language_recycler);
        mCategoriesRecycler = (RecyclerView) rootView.findViewById(R.id.onboarding_categories_recycler);

        setRecyclers();

        return rootView;
    }

    private void setRecyclers() {
        //TODO: get source list from SP as well as any saved settings and display them
        SourcesResponse sourceResponse =
                SharedPreferenceUtil.readObject((AppCompatActivity) getActivity(),
                        getString(R.string.SPK_SOURCE_RESPONSE),
                        SourcesResponse.class);

        setLanguageRecycler(SourceUtils.getLanguagesAvailable(sourceResponse));

        setCategoriesRecycler(SourceUtils.getCategoriesAvailable(sourceResponse));

    }

    private void setCategoriesRecycler(Set<String> categories) {
        mCategoriesRecycler.setHasFixedSize(true);
        mCategoriesLayoutManager = new LinearLayoutManager(getContext());
        mCategoriesRecycler.setLayoutManager(mCategoriesLayoutManager);

        mCategoriesAdapter = new SourceCategoriesAdapter(categories, new OnItemsSelected() {
            @Override
            public void onChanged(String language, boolean added) {
                //todo: if they change update a string to let the user know how many matches they have
            }
        });
        mCategoriesRecycler.setAdapter(mCategoriesAdapter);
        //todo write an adapter
    }

    private void setLanguageRecycler(Set<String> languages) {
        mLanguageRecycler.setHasFixedSize(true);
        mLanguageLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mLanguageRecycler.setLayoutManager(mLanguageLayoutManager);

        mLanguageAdapter = new SourceLanguageAdapter(languages, new OnItemsSelected() {
            @Override
            public void onChanged(String language, boolean added) {
                Log.d("123", "onChanged: " +  language + " was " + (added ? "added" : "removed") );
                //todo animate the bottom recyclerview and notify it of changes the user makes
            }
        });

        mLanguageRecycler.setAdapter(mLanguageAdapter);
    }

    public interface OnItemsSelected {
        void onChanged(String language, boolean added);
    }


}
