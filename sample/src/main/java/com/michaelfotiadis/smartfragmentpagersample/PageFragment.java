package com.michaelfotiadis.smartfragmentpagersample;


import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    private static final String EXTRA_CONTENT = PageFragment.class.getSimpleName() + ".content";
    private static final String EXTRA_BG = PageFragment.class.getSimpleName() + ".bg";

    public static Fragment newInstance(final String displayText, @ColorRes final int bgRes) {
        final Fragment fragment = new PageFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(EXTRA_CONTENT, displayText);
        bundle.putInt(EXTRA_BG, bgRes);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ViewGroup container = view.findViewById(R.id.frame);
        final TextView textView = view.findViewById(R.id.content);

        if (getArguments() != null) {
            textView.setText(getArguments().getString(EXTRA_CONTENT, ""));
            container.setBackgroundColor(ContextCompat.getColor(getContext(), getArguments().getInt(EXTRA_BG)));
        }

    }
}
