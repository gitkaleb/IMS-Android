package com.gcme.ims.fragments;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gcme.ims.R;
import com.gcme.ims.videoplayer.FragmentChannelVideos;
import com.gcme.ims.videoplayer.FragmentVideo;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * A simple {@link Fragment} subclass.
 */
public class videosFragment extends Fragment {
    private boolean isFullscreen;
    private Fragment mFragment;
    Bundle bundle;
//    String youtubechannel="UCZbN5eNWXsgPdausm9R_a6A";
    String youtubechannel="UCs4hi8VngnkBTBfuHqgTicA";
    private FrameLayout frmLayoutList;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    String address;
    /** The padding between the video list and the video in landscape orientation. */
    private static final int LANDSCAPE_VIDEO_PADDING_DP = 5;
    public videosFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_videos, container, false);

//        if (getArguments().getString("videosFragmentmessage")!=null){
//            String address = getArguments().getString("videosFragmentmessage");
//            if(address!=null){
//
//            onVideoSelected(address);
//
//        }

//        }

        // Set FragmentVideo object
            frmLayoutList = (FrameLayout) view.findViewById(R.id.fragment_container);

                       bundle = new Bundle();
            bundle.putString("CHANNEL_ID",
                    youtubechannel);
            bundle.putString("CHANNEL_TYPE",
                    "2");

            // Create FragmentChannelVideos object
            mFragment = new FragmentChannelVideos();
            mFragment.setArguments(bundle);

            // Replace fragment in fragment_container with FragmentChannelVideos
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, mFragment)
                    .commit();
            // Check Youtube API
//        }

        return view;
    }



}
