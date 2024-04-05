package com.example.lap02_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mData;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> data) {
        super(context, resource, data);
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = listItemView.findViewById(android.R.id.text1);
        textView.setText(mData.get(position));

        return listItemView;
    }
}

