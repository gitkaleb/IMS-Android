package com.gcme.ims.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gcme.ims.R;
import com.gcme.ims.adapters.GoogleCardsNewsAdapter;
import com.gcme.ims.adapters.GoogleCardsTestimoniesAdapter;
import com.gcme.ims.models.news;
import com.gcme.ims.models.testimonies;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {


    private GoogleCardsTestimoniesAdapter mGoogleCardstestimonyAdapter;
    private GoogleCardsNewsAdapter mGoogleCardsnewsAdapter;
    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

       RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_news);
        RecyclerView recyclerViewtestimonies = (RecyclerView) view.findViewById(R.id.recycler_view_testimones);





//        listView.setClipToPadding(false);
//        listView.setDivider(null);
//        Resources r = getResources();
//        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                16, r.getDisplayMetrics());
//        listView.setDividerHeight(px);
//        listView.setFadingEdgeLength(0);
//        listView.setFitsSystemWindows(true);
//        px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60,
//                r.getDisplayMetrics());
//        listView.setPadding(px, px, px, px);
//        listView.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
//        listView.canScrollHorizontally(ListView.SCROLL_AXIS_HORIZONTAL);
//
//        listView.setAdapter(mGoogleCardsAdapter);


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        LinearLayoutManager testimonylayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        mGoogleCardsAdapter = new GoogleCardsNewsAdapter(getActivity(),
//                DummyModelList());


        mGoogleCardstestimonyAdapter = new GoogleCardsTestimoniesAdapter(getActivity(),
                DummyModelList());

        recyclerViewtestimonies.setAdapter(mGoogleCardstestimonyAdapter);
        recyclerViewtestimonies.setLayoutManager(testimonylayoutManager);







        mGoogleCardsnewsAdapter = new GoogleCardsNewsAdapter(getActivity(),
                DummyNewsList());

        recyclerView.setAdapter(mGoogleCardsnewsAdapter);
        recyclerView.setLayoutManager(layoutManager);



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

    public static ArrayList<news> DummyNewsList() {
        ArrayList<news> list = new ArrayList<>();

        list.add(new news(0, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "Isaac Reid", "this is dummy text"));
        list.add(new news(1, "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg", "Jason Graham","this is dummy text"));
        list.add(new news(2, "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg", "Abigail Ross", "this is dummy text"));
        list.add(new news(3, "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg", "Justin Rutherford","this is dummy text"));
        list.add(new news(4, "http://pengaja.com/uiapptemplate/newphotos/profileimages/4.jpg", "Nicholas Henderson", "this is dummy text"));

        return list;
    }


}
