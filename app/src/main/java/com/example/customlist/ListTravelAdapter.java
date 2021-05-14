package com.example.customlist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListTravelAdapter extends BaseAdapter {
    Context ctx;
    int layoutItem;
    ArrayList<Travel> arrayList;

    public ListTravelAdapter(Context ctx, int layoutItem, ArrayList<Travel> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(layoutItem, parent, false);
        TextView tvTravel = convertView.findViewById(R.id.tvTravle);
        for (int i=1;i<= arrayList.size();i++){
            tvTravel.setText(i+": "+arrayList.get(position).getTravel());
        }

        ImageView imgEdit= convertView.findViewById(R.id.edit);

        ImageView imgRemove= convertView.findViewById(R.id.imgRemove);

        return convertView;
    }
}
