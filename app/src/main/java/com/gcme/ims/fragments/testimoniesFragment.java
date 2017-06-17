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
import com.gcme.ims.adapters.GoogleCardsNewsMainAdapter;
import com.gcme.ims.adapters.GoogleCardsTestimoniesAdapter;
import com.gcme.ims.adapters.GoogleCardsTestimoniesMainAdapter;
import com.gcme.ims.models.testimonies;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class testimoniesFragment extends Fragment {

    private GoogleCardsTestimoniesMainAdapter mGoogleCardstesTestimoniesAdapter;
    public testimoniesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_testimonies, container, false);
        ListView listViewTestimonies = (ListView) view.findViewById(R.id.testimonies_list_view);


        mGoogleCardstesTestimoniesAdapter = new GoogleCardsTestimoniesMainAdapter(getActivity(),
                DummyModelList());

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

        listViewTestimonies.setAdapter(mGoogleCardstesTestimoniesAdapter);


        return view;

    }

    public static ArrayList<testimonies> DummyModelList() {
        ArrayList<testimonies> list = new ArrayList<>();

        list.add(new testimonies(0, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "Isaac Reid", "this is dummy text"));
        list.add(new testimonies(1, "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg", "Jason Graham","this is dummy text"));
        list.add(new testimonies(2, "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg", "Abigail Ross", "this is dummy text"));
        list.add(new testimonies(3, "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg", "Justin Rutherford","this is dummy text"));
        list.add(new testimonies(4, "http://pengaja.com/uiapptemplate/newphotos/profileimages/4.jpg", "Nicholas Henderson", "this is dummy text"));

        return list;
    }

}
