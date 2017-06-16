package com.gcme.ims;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gcme.ims.adapters.tabAdapter;
import com.gcme.ims.tab.SlidingTabLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager viewPager;
    private tabAdapter mAdapter;
    private ActionBar actionBar;
    private Drawer mDrawer = null;
    SlidingTabLayout tabs;


    private String[] tabTitles = { "Home", "Prayers", "Resources" };
    private String[] navTitles = { "Home","News", "Testimonies","About"};
    int Numboftabs = 3;

    // Set default selected drawer item
    private int mSelectedDrawerItem = 0;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        PrimaryDrawerItem[] mPrimaryDrawerItem = new PrimaryDrawerItem[4];

        for(int i = 0; i < 4; i++) {
            mPrimaryDrawerItem[i] = new PrimaryDrawerItem()
                    .withName(navTitles[i])
                    .withIdentifier(i)
                    .withSelectable(false);

        }


        // Create drawer menu
        mDrawer = new DrawerBuilder(this)

                .withActivity(MainActivity.this)
              .withToolbar(toolbar)
//              .withRootView(R.id.drawer_container)
                .withActionBarDrawerToggleAnimated(true)
                .withSavedInstance(savedInstanceState)
                // Add menu items to the drawer
                .addDrawerItems(
                        mPrimaryDrawerItem
                )

                .addStickyDrawerItems(
                        new SecondaryDrawerItem()
                                .withName(getString(R.string.partnerwithus))
                                .withIdentifier(4)
                                .withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // Check if the drawerItem is set.
                        // There are different reasons for the drawerItem to be null
                        // --> click on the header
                        // --> click on the footer
                        // Those items don't contain a drawerItem
                        mSelectedDrawerItem = position;
                        if (drawerItem != null) {

                            if (mSelectedDrawerItem == 4) {
                                // Open about page by calling ActivityAbout.java
//                                Intent aboutIntent = new Intent(getApplicationContext(),
//                                        ActivityAbout.class);
//                                startActivity(aboutIntent);
//                                overridePendingTransition(R.anim.open_next, R.anim.close_main);
                            }else{  setToolbarAndSelectedDrawerItem(
                                    navTitles[mSelectedDrawerItem],
                                        (mSelectedDrawerItem));

                            }
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();







        mAdapter = new tabAdapter(getSupportFragmentManager(), tabTitles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mAdapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tab);
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


    }

    private void setToolbarAndSelectedDrawerItem(String title, int selectedDrawerItem){
        toolbar.setTitle(title);
        mDrawer.setSelection(selectedDrawerItem, false);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
