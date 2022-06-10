package com.nurdev.landmeasurement;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;


public class CustomAdapter extends BaseAdapter {
  Context context;
    private List<ItemsModel> itemsModelsl;
    private List<ItemsModel> itemsModelListFiltered;
    private LayoutInflater inflater;
    private Object valueFilter;

    public CustomAdapter(List<ItemsModel> itemsModelsl, Context context) {
        this.itemsModelsl = itemsModelsl;
        this.itemsModelListFiltered = itemsModelsl;
        this.context = context;
    }
    @Override
    public int getCount() {
        return itemsModelListFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsModelListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.app_view,viewGroup,false);

        }
        ImageView imageView = view.findViewById(R.id.clogo);
        Glide.with(context).load(itemsModelListFiltered.get(i).getIcon()).placeholder(R.drawable.techzweb).into(imageView);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(itemsModelListFiltered.get(i).getUrl())));
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(itemsModelListFiltered.get(i).getUrl())));
                }
            }
        });
        TextView textView = view.findViewById(R.id.cname);
        textView.setText(itemsModelListFiltered.get(i).getName());
        return view;
    }


}
