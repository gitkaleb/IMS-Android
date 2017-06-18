package com.gcme.ims.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcme.ims.Activitys.singleDisplay;
import com.gcme.ims.R;
import com.gcme.ims.models.devotional;

import java.util.List;

public class GoogleCardsDevotionalsAdapter extends ArrayAdapter<devotional>
		implements OnClickListener {
				Context context;
private LayoutInflater mInflater;
	devotional item;
public GoogleCardsDevotionalsAdapter(Context context, List<devotional> items) {
		super(context, 0, items);
		this.context=context;
		mInflater = (LayoutInflater) context
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

@Override
public long getItemId(int position) {
		return getItem(position).getId();
		}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
final ViewHolder holder;
		item = getItem(position);
		if (convertView == null) {
		convertView = mInflater.inflate(
		R.layout.list_item_google_cards_travel_main, parent, false);
		holder = new ViewHolder();
		holder.image = (ImageView) convertView
		.findViewById(R.id.list_item_google_cards_travel_image);

		holder.title = (TextView) convertView
		.findViewById(R.id.list_item_google_cards_travel_title);
		holder.text = (TextView) convertView
		.findViewById(R.id.list_item_google_cards_travel_text);

		convertView.setTag(holder);
		} else {
		holder = (ViewHolder) convertView.getTag();
		}
		String url=item.getDevotionalimg();


		Glide.with(context)
		.load(url)
		.asBitmap()
		.placeholder(R.drawable.logo )
		.into(holder.image);

		holder. image .setOnClickListener(new OnClickListener() {
@Override
public void onClick(View view) {

		String img=item.getDevotionalimg();
		String title=item.getDevotionaltitle();
		String description=item.getDevotionaldetail();

		Intent i=new Intent(context,singleDisplay.class);
		Bundle args = new Bundle();
		args.putString("imgurl",img);
		args.putString("detailtitle",title);
		args.putString("detaildescription",description);
		i.putExtras(args);
		context.startActivity(i);

		}
		});



		holder.title.setText(item.getDevotionaltitle());

		return convertView;
		}

private static class ViewHolder {
	public ImageView image;
	public TextView title;
	public TextView text;
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();
		switch (v.getId()) {

		}
	}
}




