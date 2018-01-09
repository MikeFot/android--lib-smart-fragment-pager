package com.michaelfotiadis.smartfragmentpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;

import java.util.HashMap;

public class FragmentViewPagerTagManager {
    private final FragmentManager fragmentManager;
    private final SparseArray<String> fragmentTags = new SparseArray<>();

    public FragmentViewPagerTagManager(final FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public Fragment get(final int position) {
        return this.fragmentManager.findFragmentByTag(this.fragmentTags.get(position));
    }

    public boolean has(final int position) {
        return this.fragmentTags.indexOfKey(position) > 0
                && this.fragmentManager.findFragmentByTag(this.fragmentTags.get(position)) != null;
    }

    public Fragment itemInstantiated(final int position, final Fragment fragment) {
        this.fragmentTags.put(position, fragment.getTag());
        return fragment;
    }
}
