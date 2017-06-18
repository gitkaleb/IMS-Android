package com.gcme.ims;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.gcme.ims.Activitys.videoPlayer;
import com.gcme.ims.fragments.aboutFragment;
import com.gcme.ims.fragments.homeContainerFragment;
import com.gcme.ims.fragments.newsFragment;
import com.gcme.ims.Activitys.partnerActivity;
import com.gcme.ims.fragments.resourcesFragment;
import com.gcme.ims.fragments.testimoniesFragment;
import com.gcme.ims.fragments.videosFragment;
import com.gcme.ims.videoplayer.FragmentChannelVideos;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.io.File;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements  ViewPagerEx.OnPageChangeListener{
        private Drawer mDrawer = null;
        private SliderLayout mDemoSlider;

        // Set default selected drawer item
        private int mSelectedDrawerItem = 0;
        Toolbar toolbar;

        private String[] navTitles = {"Home", "News", "Testimonies", "Resources", "About"};

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            toolbar = (Toolbar) findViewById(R.id.toolbar);

            mDemoSlider = (SliderLayout) findViewById(R.id.slider);

            setSupportActionBar(toolbar);
            Slider();

            PrimaryDrawerItem[] mPrimaryDrawerItem = new PrimaryDrawerItem[5];

            for (int i = 0; i < 5; i++) {
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
                                    .withIcon(R.drawable.ic_partner)
                                    .withName(getString(R.string.partnerwithus))
                                    .withIdentifier(5)
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
                                if (mSelectedDrawerItem == 0) {
                                    setToolbarAndSelectedDrawerItem(navTitles[mSelectedDrawerItem],
                                            (mSelectedDrawerItem));

                                    android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                    t.replace(R.id.contentframe, new homeContainerFragment());
                                    t.commit();

                                } else if (mSelectedDrawerItem == 1) {
                                    setToolbarAndSelectedDrawerItem(

                                            navTitles[mSelectedDrawerItem],
                                            (mSelectedDrawerItem));


                                    android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                    t.replace(R.id.contentframe, new newsFragment());
                                    t.commit();

                                } else if (mSelectedDrawerItem == 2) {
                                    setToolbarAndSelectedDrawerItem(

                                            navTitles[mSelectedDrawerItem],
                                            (mSelectedDrawerItem));

                                    android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                    t.replace(R.id.contentframe, new testimoniesFragment());
                                    t.commit();

                                } else if (mSelectedDrawerItem == 3) {
                                    setToolbarAndSelectedDrawerItem(
                                            navTitles[mSelectedDrawerItem],
                                            (mSelectedDrawerItem));
                                    android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                    t.replace(R.id.contentframe, new resourcesFragment());
                                    t.commit();

                                } else if (mSelectedDrawerItem == 4) {
                                    setToolbarAndSelectedDrawerItem(
                                            navTitles[mSelectedDrawerItem],
                                            (mSelectedDrawerItem));
                                    android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                                    t.replace(R.id.contentframe, new aboutFragment());
                                    t.commit();

                                } else {

                                    // Open about page by calling ActivityAbout.java
                                    Intent partnerIntent = new Intent(MainActivity.this,
                                            partnerActivity.class);
                                    startActivity(partnerIntent);
                                    overridePendingTransition(R.anim.open_next, R.anim.close_main);

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



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void Slider() {
        //slider


        /**if there is news in the database do this**/


        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("GO",R.drawable.go);
        file_maps.put("Send",R.drawable.send);
        file_maps.put("Disciple",R.drawable.deciple);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }


        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

//    @Override
//    public void onSliderClick(BaseSliderView slider) {
//
//        //Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
//        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//        t.replace(R.id.contentframe, new aboutFragment());
//        t.commit();
//    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }







    private void setToolbarAndSelectedDrawerItem(String title, int selectedDrawerItem) {
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


    public static void update_by_Sync() {


    }

//    @Override
//    public void onVideoSelected(String ID) {
//        videoPlayer articleFrag = (videoPlayer)
//                getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//
//        if (articleFrag != null) {
//            // If article frag is available, we're in two-pane layout...
//
//            // Call a method in the ArticleFragment to update its content
//            articleFrag.onVideoSelected(ID);
//        } else {
//            // Otherwise, we're in the one-pane layout and must swap frags...
//
//            // Create fragment and give it an argument for the selected article
//            videosFragment newFragment = new videosFragment();
//            Bundle args = new Bundle();
//            args.putString("videosFragmentmessage", ID);
//            newFragment.setArguments(args);
//
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.contentframe, newFragment);
//            transaction.addToBackStack(null);
//
//            // Commit the transaction
//            transaction.commit();
//        }
//    }
}
