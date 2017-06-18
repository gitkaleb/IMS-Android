package com.gcme.ims.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.gcme.ims.R;
import com.gcme.ims.videoplayer.FragmentChannelVideos;
import com.gcme.ims.videoplayer.FragmentVideo;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class videoPlayer extends FragmentActivity implements OnFullscreenListener{
    Toolbar toolbar;
    private boolean isFullscreen;
    private FragmentVideo mFragmentVideo;
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    private static final int LANDSCAPE_VIDEO_PADDING_DP = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        mFragmentVideo =
                (FragmentVideo) getFragmentManager().findFragmentById(R.id.video_fragment_container);
        checkYouTubeApi();
        toolbar = (Toolbar) findViewById(R.id.videotoolbar);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {
            String videolink  = bd.getString("videoId");
            String videoTitle  = bd.getString("videoTitle");
            onVideoSelected(videolink);
            toolbar.setTitle(videoTitle);
//            setSupportActionBar(toolbar);
        }


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Recreate the activity if user performed a recovery action
            recreate();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        layout();
    }

    @Override
    public void onFullscreen(boolean isFullscreen) {
        this.isFullscreen = isFullscreen;
        layout();
    }


    private void layout() {
        boolean isPortrait =
                getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        if (isFullscreen) {
            toolbar.setVisibility(View.GONE);
            setLayoutSize(mFragmentVideo.getView(), MATCH_PARENT, MATCH_PARENT);
        } else if (isPortrait) {
            toolbar.setVisibility(View.VISIBLE);
            setLayoutSize(mFragmentVideo.getView(), WRAP_CONTENT, WRAP_CONTENT);
        } else {
            toolbar.setVisibility(View.VISIBLE);
            int screenWidth = dpToPx(getResources().getConfiguration().screenWidthDp);
            int videoWidth = screenWidth - screenWidth / 4 - dpToPx(LANDSCAPE_VIDEO_PADDING_DP);
            setLayoutSize(mFragmentVideo.getView(), videoWidth, WRAP_CONTENT);
        }
    }


    // Method to convert dp to pixel
    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }

    // Method to set layout size
    private static void setLayoutSize(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }



    private void checkYouTubeApi() {
        YouTubeInitializationResult errorReason =
                YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this);
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else if (errorReason != YouTubeInitializationResult.SUCCESS) {
            String errorMessage =
                    String.format(getString(R.string.error_player),
                            errorReason.toString());

        }
    }



    public void onVideoSelected(String ID) {
        FragmentVideo mFragmentVideo =
                (FragmentVideo) getFragmentManager().findFragmentById(R.id.video_fragment_container);
        mFragmentVideo.setVideoId(ID);


    }





}
