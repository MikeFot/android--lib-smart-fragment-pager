package com.michaelfotiadis.smartfragmentpagersample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.michaelfotiadis.smartfragmentpager.SmartFragmentPagerAdapter;
import com.michaelfotiadis.smartfragmentpager.SmartFragmentPagerBinder;
import com.michaelfotiadis.smartfragmentpager.SmartFragmentPagerPage;
import com.michaelfotiadis.smartfragmentpager.SmartFragmentPagerPages;

public class MainActivity extends AppCompatActivity {

    private static final int STARTING_PAGE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SmartFragmentPagerPages pages = getPages();

        final ViewPager pager = findViewById(R.id.view_pager);
        final SmartFragmentPagerAdapter mAdapter = new SmartFragmentPagerAdapter(getSupportFragmentManager());
        mAdapter.setFragments(pages);
        pager.setAdapter(mAdapter);
        pager.setOffscreenPageLimit(1);

        final TabLayout tabLayout = findViewById(R.id.tabs);

        final SmartFragmentPagerBinder binder =
                new SmartFragmentPagerBinder(
                        pager,
                        pages,
                        tabLayout,
                        R.color.colorAccent,
                        new SmartFragmentPagerBinder.NavBarTitleNeedsChangingListener() {
                            @Override
                            public void onNavBarTitleNeedsChanging(final CharSequence newTitle) {
                                setTitle(newTitle);
                            }
                        });

        binder.bind();

        pager.setCurrentItem(STARTING_PAGE);
        //noinspection ConstantConditions
        if (STARTING_PAGE == 0) {
            binder.onPageSelected(STARTING_PAGE);
        }

    }


    private SmartFragmentPagerPages getPages() {
        final SmartFragmentPagerPages pages = new SmartFragmentPagerPages();

        pages.add(new SmartFragmentPagerPage.Builder()
                .setNavBarTitle("News")
                .setTabTitle("Your Feed")
                .setTabIcon(R.drawable.ic_news)
                .setFragment(PageFragment.newInstance("Please enjoy this awesome newsfeed!", R.color.bg_two))
                .build());

        pages.add(new SmartFragmentPagerPage.Builder()
                .setNavBarTitle("Movies")
                .setTabTitle("Movies")
                .setTabIcon(R.drawable.ic_movies)
                .setFragment(PageFragment.newInstance("Watch a movie here!", R.color.bg_one))
                .build());

        pages.add(new SmartFragmentPagerPage.Builder()
                .setNavBarTitle("Extras")
                .setTabTitle("Extras")
                .setTabIcon(R.drawable.ic_extras)
                .setFragment(PageFragment.newInstance("Extra, extra, read all about it", R.color.bg_three))
                .build());

        return pages;
    }

}
