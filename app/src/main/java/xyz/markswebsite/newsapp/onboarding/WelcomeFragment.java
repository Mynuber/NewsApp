package xyz.markswebsite.newsapp.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import xyz.markswebsite.newsapp.R;

/**
 * Created by Mark on 9/09/2017.
 */

public class WelcomeFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_welcome_page, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView welcomeImage = (ImageView) view.findViewById(R.id.welcome_image);
        Glide.with(this)
                .load(R.drawable.welcome_image)
                .into(welcomeImage);
        super.onViewCreated(view, savedInstanceState);
    }
}
