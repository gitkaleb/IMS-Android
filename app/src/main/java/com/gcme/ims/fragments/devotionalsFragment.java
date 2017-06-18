package com.gcme.ims.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gcme.ims.R;
import com.gcme.ims.Services.SyncService;
import com.gcme.ims.adapters.GoogleCardsDevotionalsAdapter;
import com.gcme.ims.models.devotional;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class devotionalsFragment extends Fragment {

    GoogleCardsDevotionalsAdapter mGoogleCardstesdevotionalsAdapter;
    List<devotional> resourcesdata ;
    public devotionalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_devotionals, container, false);
        ListView listViewTestimonies = (ListView) view.findViewById(R.id.devotional_list_view);
        resourcesdata= SyncService.getresources();

        mGoogleCardstesdevotionalsAdapter = new GoogleCardsDevotionalsAdapter(getActivity(),
                resourcesdata);

        listViewTestimonies.setClipToPadding(false);
        listViewTestimonies.setDivider(null);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                16, r.getDisplayMetrics());
        listViewTestimonies.setDividerHeight(px);
        listViewTestimonies.setFadingEdgeLength(0);
        listViewTestimonies.setFitsSystemWindows(true);
        px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16,
                r.getDisplayMetrics());
        listViewTestimonies.setPadding(px, px, px, px);
        listViewTestimonies.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
        listViewTestimonies.canScrollHorizontally(ListView.SCROLL_AXIS_HORIZONTAL);

        listViewTestimonies.setAdapter(mGoogleCardstesdevotionalsAdapter);


        return view;

    }

//    public static ArrayList<devotional> DummyDevotionalsModelList() {
//        ArrayList<devotional> list = new ArrayList<>();
//
//        list.add(new devotional(0, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "Isaac Reid", "this is dummy text"));
//        list.add(new devotional(1, "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg", "Jason Graham", "this is dummy text"));
//        list.add(new devotional(2, "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg", "Abigail Ross", "this is dummy text"));
//        list.add(new devotional(3, "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg", "Justin Rutherford", "this is dummy text"));
//        list.add(new devotional(4, "http://pengaja.com/uiapptemplate/newphotos/profileimages/4.jpg", "Nicholas Henderson", "this is dummy text"));
//
//        return list;
//    }
}