package com.gcme.ims.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcme.ims.MainActivity;
import com.gcme.ims.R;

import java.util.ArrayList;

public class singleDisplay extends AppCompatActivity {
    ImageView ToolbarChurchImage;
    TextView detailView,detailTitleview;
    Toolbar toolbar;
    Button partbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_display);
        ToolbarChurchImage= (ImageView) findViewById(R.id.churchheaderimage);
        detailView= (TextView) findViewById(R.id.detailText);
        partbutton= (Button) findViewById(R.id.partnerwithusbutton);
        detailTitleview= (TextView) findViewById(R.id.detailtitle);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
         if(bd != null)
        {
            String imgurl  = bd.getString("imgurl");
            String detailtitle  = bd.getString("detailtitle");
            String detaildescription  = bd.getString("detaildescription");

            populatedatausingid(imgurl,detailtitle,detaildescription);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        partbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent partnerIntent = new Intent(singleDisplay.this,
                        partnerActivity.class);
                startActivity(partnerIntent);
                overridePendingTransition(R.anim.open_next, R.anim.close_main);

            }
        });
//this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void populatedatausingid(String imgUrl,String detailTitle,String detailDescription) {


        Glide.with(this)
                .load(imgUrl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .into(ToolbarChurchImage);
        detailView.setText(detailDescription);
        detailTitleview.setText(detailTitle);


    }




}
