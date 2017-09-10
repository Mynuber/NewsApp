package xyz.markswebsite.newsapp.onboarding;

import android.animation.ArgbEvaluator;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

import xyz.markswebsite.newsapp.R;

public class OnboardingPager extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private ImageView[] indicators = new ImageView[3];
    private int[] colourList = new int[3];
    private Button finishButton, skipButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_pager);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        findViews();
        setPageListener();
    }

    public void findViews() {
        indicators[0] = (ImageView) findViewById(R.id.intro_indicator_0);
        indicators[1] = (ImageView) findViewById(R.id.intro_indicator_1);
        indicators[2] = (ImageView) findViewById(R.id.intro_indicator_2);

        colourList[0] = ResourcesCompat.getColor(getResources(), R.color.firenze1, null);
        colourList[1] = ResourcesCompat.getColor(getResources(), R.color.firenze4, null);
        colourList[2] = ResourcesCompat.getColor(getResources(), R.color.firenze5, null);

        nextButton = (Button) findViewById(R.id.intro_btn_next);
        skipButton = (Button) findViewById(R.id.intro_btn_skip);
        finishButton = (Button) findViewById(R.id.intro_btn_finish);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
            }
        });

        View.OnClickListener skipSettings = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: skip and disable onboarding
                Log.d("", "onClick: skip this plz");
            }
        };

        skipButton.setOnClickListener(skipSettings);
        finishButton.setOnClickListener(skipSettings);

    }


    public void setPageListener(){
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ArgbEvaluator evaluator = new ArgbEvaluator();
                int colour = (Integer) evaluator.evaluate(positionOffset,
                        colourList[position],
                        colourList[position == 2 ? position : position + 1]);
                mViewPager.setBackgroundColor(colour);
            }

            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);

                nextButton.setVisibility(position == 2? View.GONE : View.VISIBLE);
                finishButton.setVisibility(position == 2? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == position ? R.drawable.circle : R.drawable.circle_outline
            );
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private int NUM_ONBOARD_PAGES = 3;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    //Welcome page
                    return new WelcomeFragment();
                case 1:
                    //Language and Categories QuickSetup
                    return new QuickSetupCategoriesFragment();
                case 2:
                    //available sources
                    return new QuickSetupNewsSourceFragment();
                default:
                    throw new RuntimeException("position is out of bounds? search for this");
            }
        }

        @Override
        public int getCount() {
            return NUM_ONBOARD_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Welcome";
                case 1:
                    return "Categories and Language";
                case 2:
                    return "Sources";
            }
            return null;
        }
    }
}
