package com.gcme.ims.fragments;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gcme.ims.R;
import com.gcme.ims.adapters.resourceTabAdapter;
import com.gcme.ims.adapters.tabAdapter;
import com.gcme.ims.tab.SlidingTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class resourcesFragment extends Fragment {

    private ViewPager viewPager;
    private resourceTabAdapter mAdapter;
    private ActionBar actionBar;

    SlidingTabLayout tabs;


    private String[] tabTitles = { "Devotionals", "Videos" };
    int Numboftabs = 2;
    public resourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_resources, container, false);



        mAdapter = new resourceTabAdapter(getFragmentManager(), tabTitles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) view.findViewById(R.id.resourceviewpager);
        viewPager.setAdapter(mAdapter);

        tabs = (SlidingTabLayout) view.findViewById(R.id.resourcetab);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.primary_light);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);


        return view;
    }

}
