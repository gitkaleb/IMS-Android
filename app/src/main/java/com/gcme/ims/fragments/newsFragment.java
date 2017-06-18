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
import com.gcme.ims.adapters.GoogleCardsNewsMainAdapter;
import com.gcme.ims.adapters.GoogleCardsTestimoniesAdapter;
import com.gcme.ims.models.news;
import com.gcme.ims.models.testimonies;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class newsFragment extends Fragment {

    private GoogleCardsNewsMainAdapter mGoogleCardstesNewsAdapter;
    private List<news> newsdata ;
    public newsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_news, container, false);
        ListView listViewNews = (ListView) view.findViewById(R.id.news_list_view);

        newsdata= SyncService.getNews();
        mGoogleCardstesNewsAdapter = new GoogleCardsNewsMainAdapter(getActivity(),
                newsdata);


        listViewNews.setClipToPadding(false);
        listViewNews.setDivider(null);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                16, r.getDisplayMetrics());
        listViewNews.setDividerHeight(px);
        listViewNews.setFadingEdgeLength(0);
        listViewNews.setFitsSystemWindows(true);
        px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16,
                r.getDisplayMetrics());
        listViewNews.setPadding(px, px, px, px);
        listViewNews.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
        listViewNews.canScrollHorizontally(ListView.SCROLL_AXIS_HORIZONTAL);

        listViewNews.setAdapter(mGoogleCardstesNewsAdapter);


        return view;
    }

//    public static ArrayList<news> DummyNewsList() {
//        ArrayList<news> list = new ArrayList<>();
//
//        list.add(new news(0, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "Isaac Reid", "this is dummy text"));
//        list.add(new news(1, "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg", "Jason Graham","this is dummy text"));
//        list.add(new news(2, "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg", "Abigail Ross", "this is dummy text"));
//        list.add(new news(3, "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg", "Justin Rutherford","this is dummy text"));
//        list.add(new news(4, "http://pengaja.com/uiapptemplate/newphotos/profileimages/4.jpg", "Nicholas Henderson", "this is dummy text"));
//
//        return list;
//    }

}
