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
import com.gcme.ims.adapters.GoogleCardsPrayerAdapter;
import com.gcme.ims.models.prayers;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class prayerFragment extends Fragment {


    private GoogleCardsPrayerAdapter mGoogleCardsAdapter;

    public prayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prayer, container, false);
        ListView listView = (ListView) view.findViewById(R.id.recycler_view_prayers);

        mGoogleCardsAdapter = new GoogleCardsPrayerAdapter(getActivity(),
                DummyModelList());


        listView.setClipToPadding(false);
        listView.setDivider(null);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                16, r.getDisplayMetrics());
        listView.setDividerHeight(px);
        listView.setFadingEdgeLength(0);
        listView.setFitsSystemWindows(true);
        px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16,
                r.getDisplayMetrics());
        listView.setPadding(px, px, px, px);
        listView.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);


        listView.setAdapter(mGoogleCardsAdapter);


        return view;
    }

    public static ArrayList<prayers> DummyModelList() {
        ArrayList<prayers> list = new ArrayList<>();

        list.add(new prayers(0, "Isaac Reid", "this is dummy text"));
        list.add(new prayers(1, "Jason Graham", "this is dummy text"));
        list.add(new prayers(2, "Abigail Ross", "this is dummy text"));
        list.add(new prayers(3, "Justin Rutherford", "this is dummy text"));
        list.add(new prayers(4, "Nicholas Henderson", "this is dummy text"));

        return list;
    }
}