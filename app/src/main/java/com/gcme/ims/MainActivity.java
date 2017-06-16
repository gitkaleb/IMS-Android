package com.gcme.ims;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gcme.ims.fragments.aboutFragment;
import com.gcme.ims.fragments.homeContainerFragment;
import com.gcme.ims.fragments.homeFragment;
import com.gcme.ims.fragments.newsFragment;
import com.gcme.ims.fragments.partnerActivity;
import com.gcme.ims.fragments.testimoniesFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {
    private Drawer mDrawer = null;


    // Set default selected drawer item
    private int mSelectedDrawerItem = 0;
    Toolbar toolbar;

    private String[] navTitles = { "Home","News", "Testimonies","About"};

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
                                Intent aboutIntent = new Intent(getApplicationContext(),
                                        partnerActivity.class);
                                startActivity(aboutIntent);
                                overridePendingTransition(R.anim.open_next, R.anim.close_main);
                            }else if(

                                    mSelectedDrawerItem==0){  setToolbarAndSelectedDrawerItem(
                                    navTitles[mSelectedDrawerItem],
                                        (mSelectedDrawerItem));

                                android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                t.replace(R.id.contentframe, new homeContainerFragment());
                                t.commit();

                            }else if(mSelectedDrawerItem==1){  setToolbarAndSelectedDrawerItem(

                                    navTitles[mSelectedDrawerItem],
                                    (mSelectedDrawerItem));


                                android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                t.replace(R.id.contentframe, new newsFragment());
                                t.commit();

                            }else if(mSelectedDrawerItem==2){  setToolbarAndSelectedDrawerItem(

                                    navTitles[mSelectedDrawerItem],
                                    (mSelectedDrawerItem));

                                android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                t.replace(R.id.contentframe, new testimoniesFragment());
                                t.commit();

                            }else if(mSelectedDrawerItem==3){  setToolbarAndSelectedDrawerItem(
                                    navTitles[mSelectedDrawerItem],
                                    (mSelectedDrawerItem));
                                android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                t.replace(R.id.contentframe, new aboutFragment());
                                t.commit();

                            }
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();


        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.contentframe, new homeContainerFragment());
        t.commit();





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




}
