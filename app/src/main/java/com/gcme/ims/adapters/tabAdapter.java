package com.gcme.ims.adapters;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.app.Fragment;
/**
 * Created by kzone on 6/16/2017.
 */


import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gcme.ims.fragments.homeFragment;
import com.gcme.ims.fragments.prayerFragment;
import com.gcme.ims.fragments.resourcesFragment;

public class tabAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public tabAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if (position == 0) // if the position is 0 we are returning the First tab
        {
            homeFragment tab1 = new homeFragment();
            return tab1;
        } else if(position==1)             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            prayerFragment tab2 = new prayerFragment();
            return tab2;
        }else {
            resourcesFragment tab3 = new resourcesFragment();
            return tab3;
        }

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}