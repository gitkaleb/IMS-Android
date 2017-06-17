package com.gcme.ims.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcme.ims.R;
import com.gcme.ims.models.prayers;
import com.gcme.ims.models.testimonies;

import java.util.List;

public class GoogleCardsPrayerAdapter extends ArrayAdapter<prayers>
		implements OnClickListener {

	private LayoutInflater mInflater;
	Activity context;

	public GoogleCardsPrayerAdapter(Activity context, List<prayers> items) {
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
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.list_item_google_cards_prayer, parent, false);
			holder = new ViewHolder();

			holder.categoryName = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_travel_title_prayer);
			holder.text = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_travel_text_prayer);

			convertView.setTag(holder);
			prayers item = getItem(position);

			holder.categoryName.setText(item.getPrayertitle());
			holder.text.setText(item.getPrayerdetail());



		} else {
			holder = (ViewHolder) convertView.getTag();
		}



		return convertView;
	}

	private static class ViewHolder {

		public TextView categoryName;
//		public TextView title;
		public TextView text;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();

	}
}
