package com.gcme.ims.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcme.ims.R;
import com.gcme.ims.models.testimonies;

import java.util.List;

public class GoogleCardsTestimoniesMainAdapter  extends ArrayAdapter<testimonies>
		implements OnClickListener {
Context context;
	private LayoutInflater mInflater;

	public GoogleCardsTestimoniesMainAdapter(Context context, List<testimonies> items) {
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
		testimonies item = getItem(position);
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
		String url=item.getTestimonyimg();


		Glide.with(context)
				.load(url)
				.asBitmap()
				.placeholder(R.mipmap.ic_launcher )
				.into(holder.image);

		holder. image .setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

//
//                Intent i=new Intent(activity_gener.getActivity(),GenerList.class);
//                Bundle args = new Bundle();
//                args.putString("genere",feeds.getVideogenere());
//                i.putExtras(args);
//                activity_gener.getActivity().startActivity(i);




			}
		});



		holder.title.setText(item.getTestimonytitle());

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

















