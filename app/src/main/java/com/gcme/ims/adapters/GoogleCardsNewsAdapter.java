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
import com.gcme.ims.models.news;
import com.gcme.ims.models.testimonies;

import java.util.List;

public class GoogleCardsNewsAdapter extends RecyclerView.Adapter<GoogleCardsNewsAdapter.MyViewHolder> {

	private LayoutInflater mInflater;
	Activity context;
	private List<news> feedsList;

	public GoogleCardsNewsAdapter(Activity context, List<news> items) {

		this.context=context;
		this.feedsList = items;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View rootView = mInflater.inflate(R.layout.list_item_google_cards, parent, false);
		return new MyViewHolder(rootView);
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, final int position) {
		final news feeds = feedsList.get(position);

		String url = feeds.getNewsimg();
		Glide.with(context)
				.load(url)
				.asBitmap()
				.placeholder(R.mipmap.ic_launcher )
				.into(holder.image);


		//Pass the values of feeds object to Views

		holder.text.setText(feeds.getNewstitle());
//        holder.numberofchurches.setText((feeds.getnumber()));
//        File file = new File(feeds.getImageLocation());
		holder. image .setOnClickListener(new View.OnClickListener() {
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
	}


	@Override
	public int getItemCount() {
		return feedsList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {

		public ImageView image;
		//		public TextView title;
		public TextView text;
		public MyViewHolder(View itemView) {
			super(itemView);


			image = (ImageView) itemView
					.findViewById(R.id.list_item_google_cards_travel_image);

			text = (TextView) itemView
					.findViewById(R.id.list_item_google_cards_travel_text);



		}
	}

}


