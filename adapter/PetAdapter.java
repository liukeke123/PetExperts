package com.example.lk.petexperts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lk.petexperts.R;
import com.example.lk.petexperts.vo.Pet;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class PetAdapter extends BaseAdapter {

    private Context context;
    private List<Pet>list;

    public PetAdapter(Context context,List<Pet>list){
        this.context=context;
        this.list=list;
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
        LayoutInflater layout=LayoutInflater.from(context);
        View view=layout.inflate(R.layout.item,null);
        TextView nameTextView= (TextView) view.findViewById(R.id.textview_item);
        ImageView logoView= (ImageView) view.findViewById(R.id.imag_item);

        nameTextView.setText(list.get(position).getName());
        logoView.setImageResource(list.get(position).getImageid());


        return view;
    }
}
