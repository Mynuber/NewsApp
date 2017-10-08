package xyz.markswebsite.newsapp.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
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

    private SourcesResponse mSourceResponse;

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
        SourcesResponse sourceResponse =
                SharedPreferenceUtil.readObject((AppCompatActivity) getActivity(),
                        getString(R.string.SPK_SOURCE_RESPONSE),
                        SourcesResponse.class);

        mSourceResponse = sourceResponse;

        setLanguageRecycler(SourceUtils.getLanguagesAvailable(sourceResponse));
        updateLanguagesSelectedFromAdapter();
        setCategoriesRecycler(SourceUtils.getCategoriesAvailable(sourceResponse, languagesSelected));
    }

    private void updateLanguagesSelectedFromAdapter(){
        languagesSelected.addAll(((SourceLanguageAdapter)mLanguageRecycler.getAdapter()).getSelectedLanguages());
    }

    private void changeLanguages(String language, boolean added){
        if(added){
            languagesSelected.add(language);
        }else {
            languagesSelected.remove(language);
        }

        ((SourceCategoriesAdapter)(mCategoriesRecycler.getAdapter())).setNewCategories(
                SourceUtils.getCategoriesAvailable(mSourceResponse, languagesSelected)
        );

    }

    private void setCategoriesRecycler(Set<String> categories) {
        mCategoriesRecycler.setHasFixedSize(true);
        mCategoriesLayoutManager = new LinearLayoutManager(getContext());
        mCategoriesRecycler.setLayoutManager(mCategoriesLayoutManager);

        mCategoriesAdapter = new SourceCategoriesAdapter(categories, new OnItemsSelected() {
            @Override
            public void onChanged(String language, boolean added) {
                //todo
//                changeLanguages(language, added);
            }
        });

        mCategoriesRecycler.setAdapter(mCategoriesAdapter);
        mCategoriesRecycler.setItemAnimator(new DefaultItemAnimator());
    }

    private void setLanguageRecycler(Set<String> languages) {
        mLanguageRecycler.setHasFixedSize(true);
        mLanguageLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mLanguageRecycler.setLayoutManager(mLanguageLayoutManager);

        mLanguageAdapter = new SourceLanguageAdapter(languages, new OnItemsSelected() {
            @Override
            public void onChanged(String language, boolean added) {
//                Log.d("123", "onChanged: " +  language + " was " + (added ? "added" : "removed") );
                changeLanguages(language, added);
            }
        });

        mLanguageRecycler.setAdapter(mLanguageAdapter);
    }

    public interface OnItemsSelected {
        void onChanged(String language, boolean added);
    }


}
