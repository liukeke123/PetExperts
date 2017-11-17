package com.example.lk.petexperts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lk.petexperts.R;
import com.example.lk.petexperts.vo.PetWeb;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class PetWebAdapter extends BaseAdapter {
    private Context context;
    private List<PetWeb> list;

    public PetWebAdapter(Context context, List<PetWeb> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
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
        LayoutInflater layout = LayoutInflater.from(context);
        View view = layout.inflate(R.layout.item1, null);
        TextView nameTextView = (TextView) view.findViewById(R.id.text_webitem);
        nameTextView.setText(list.get(position).getName());

        return view;
    }
}
